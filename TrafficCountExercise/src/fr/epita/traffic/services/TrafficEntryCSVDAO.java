package fr.epita.traffic.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.epita.traffic.datamodel.TrafficEntry;

public class TrafficEntryCSVDAO {

	
	
	public List<TrafficEntry> readAll() throws IOException, ParseException{
		List<String> lines = Files.readAllLines(new File("Average_Daily_Traffic_Counts.csv").toPath());
		//because of the header:
		lines.remove(0);
		List<TrafficEntry> resultList = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		for (String line : lines) {
			String[] parts = line.split(",");
			TrafficEntry te = new TrafficEntry();
			te.setId(Integer.valueOf(parts[0]));
			te.setDateOfCount(formatter.parse(parts[3]));
			te.setLatitude(Double.valueOf(parts[6]));
			te.setLongitude(Double.valueOf(parts[7]));
			te.setTotalPassingVehicleVolumes(Integer.valueOf(parts[4]));
			te.setStreet(parts[2]);
			te.setTrafficVolumeLocationAddress(parts[1]);
			te.setVehicleVolumeByEachDirection(parts[5]);
			resultList.add(te);
		}
		
		return resultList;
		
	}
}
