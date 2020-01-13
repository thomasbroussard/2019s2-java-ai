package fr.epita.traffic.launcher;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.IntStream;

import fr.epita.traffic.datamodel.TrafficEntry;
import fr.epita.traffic.services.TrafficEntryCSVDAO;

public class Launcher {

	public static void main(String[] args) throws IOException, ParseException {
		TrafficEntryCSVDAO dao = new TrafficEntryCSVDAO();
		List<TrafficEntry> list = dao.readAll();
		
		System.out.println("list size : " +  list.size());
		
		Integer count = 0;
		for (TrafficEntry entry : list) {
			count += entry.getTotalPassingVehicleVolumes();
			
		}
		
		IntStream trafficMappedToTotalPassingVolume = list.stream().mapToInt(TrafficEntry::getTotalPassingVehicleVolumes);
		
		
		System.out.println("total passing vehicles : " + count);
		System.out.println("total passing vehicles 2  : " + count2);
			
	}

}
