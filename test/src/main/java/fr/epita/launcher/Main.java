package fr.epita.launcher;

import org.apache.spark.ml.classification.DecisionTreeClassificationModel;
import org.apache.spark.ml.classification.DecisionTreeClassifier;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.StringIndexerModel;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.mllib.evaluation.MulticlassMetrics;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataTypes;

public class Main {
	
	public static void main(String[] args) {
		
		//preparing spark session
		
        SparkSession spark = SparkSession
                .builder()
                .config("spark.master", "local")
                .config("spark.ui.enabled", false)
                .config("spark.sql.shuffle.partitions", "1")
                .appName("titanic")
                .getOrCreate();
		
        // reducing error level
        spark.sparkContext().setLogLevel("ERROR");
                

        
        // preparing dataframe
        Dataset<Row> df = spark.read()
                .format("csv")
                .option("header", "true")
                .option("inferSchema", "true")
                .csv("data/input.csv");
		
        
       
        
        // show dataset
        df.show();
        // base statistics
        df.describe().show();
        


        
        // removing missing values
        df = df.na().drop();
        //show impact of missing values
        df.describe().show();
        
        
        //displaying count by category
        String labelColumn ="Survived";
        out("count by category");
        Dataset<Row> counts = df.sort(functions.asc(labelColumn))
        		.groupBy(labelColumn)
        		.agg(functions.count("*"));
        
        counts.show();
        
        
        //indexing
        String colName = "Sex";
        df = new StringIndexer()
                .setInputCol(colName)
                .setOutputCol("idx_" + colName)
                .setHandleInvalid("skip")
                .fit(df)
                .transform(df);
        
        
        
        out("after indexing");
        df.show();
        
        out("schema");
        df.printSchema();
        
        // getting train and test dataset
        Dataset<Row>[] trainTest = df.randomSplit(new double[] {0.8,0.2});
        Dataset<Row> train = trainTest[0];
        Dataset<Row> test = trainTest[1];
        
        
        //preparing to train
        //assembling features
        String featuresColumn = "features";
        train = new VectorAssembler()
                .setInputCols(new String[] {"Pclass", "idx_Sex", "Age","Siblings/Spouses Aboard", "Parents/Children Aboard", "Fare"})
                .setOutputCol(featuresColumn)
                .transform(train);
        
        String predictionColumn = "predicted";
        DecisionTreeClassifier decision = new DecisionTreeClassifier()
        		.setLabelCol(labelColumn)
        		.setPredictionCol(predictionColumn)
        		.setFeaturesCol(featuresColumn);

       
        //train schema
        train.printSchema();
       
        DecisionTreeClassificationModel model = decision
        		.fit(train);
		Dataset<Row> predicted = model
        		.transform(train);
        	
        
        predicted.select("predicted").show();
        
        predicted = predicted.withColumn("label_temp", predicted.col(labelColumn).cast(DataTypes.DoubleType))
        .drop(labelColumn)
        .withColumnRenamed("label_temp", labelColumn);
        
        predicted.select("predicted", labelColumn).show();
        
        MulticlassMetrics metrics = new MulticlassMetrics(predicted.select(labelColumn, predictionColumn));
        
        out(metrics.confusionMatrix().toString());
      
        out("precision");
        out(metrics.precision(0.0));
        out("recall");
        out(metrics.recall(0.0));
        out("f1");
        out(metrics.fMeasure(0.0));        
		
        out("param explanation: ", model.explainParams());
        
        out("feature importance");
        double[] doubleArray = model.featureImportances().toArray();
        for (double d : doubleArray) {
        	System.out.println(d);
        }
        
	}

	private static void out(Object... message) {
		String output = "";
		if (message!= null && message.length >0) {
			for (Object m : message) {
				output+= String.valueOf(m) + "\n";
			}
		}
		System.out.println("\n--------------\n"+output);
	}
	
	   public static Dataset<Row> stringToIndex(Dataset<Row> originalDF, String... colNames) {

	        for (String colName : colNames) {
	            if (colName == null){
	                continue;
	            }
	            StringIndexerModel indexer = new StringIndexer()
	                    .setInputCol(colName)
	                    .setOutputCol("idx_" + colName)
	                    .fit(originalDF);


	            originalDF = indexer
	                    .transform(originalDF)
	                    .drop(colName)
	                    .withColumnRenamed("idx_" + colName, colName);

	        }
	        return originalDF;
	    }


}
