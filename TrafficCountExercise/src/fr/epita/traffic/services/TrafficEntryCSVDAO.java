package fr.epita.traffic.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
			Date date = formatter.parse(parts[3]);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			te.setWeekNumber(calendar.get(Calendar.WEEK_OF_YEAR));
			te.setDayInWeek(calendar.get(Calendar.DAY_OF_WEEK));
			
			te.setDateOfCount(date);
			te.setLatitude(Double.valueOf(parts[6]));
			te.setLongitude(Double.valueOf(parts[7]));
			te.setTotalPassingVehicleVolumes(Integer.valueOf(parts[4]));
			te.setStreet(parts[2]);
			te.setTrafficVolumeLocationAddress(parts[1]);
			//North Bound: 7500 / South Bound: 8100
			
			String globalCountsByDirection = parts[5];
			String[] directionParts = globalCountsByDirection.split("/");
			Integer mainDirection = Integer.valueOf(directionParts[0].split(":")[1].trim());
			Integer oppositeDirection = Integer.valueOf(directionParts[1].split(":")[1].trim());
			te.setVehicleVolumeForMainDirection(mainDirection);
			te.setVehicleVolumeForOppositeDirection(oppositeDirection);
	
			resultList.add(te);
		}
		
		return resultList;
		
	}
}
