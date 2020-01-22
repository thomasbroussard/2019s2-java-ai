package fr.epita.traffic.launcher;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.function.ToIntFunction;

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
		
		int count2 = list
				.stream()
				.mapToInt(TrafficEntry::getTotalPassingVehicleVolumes)
				.sum();
		
		double average = calculateAverageOn(list, TrafficEntry::getTotalPassingVehicleVolumes);
		
		
		System.out.println("total passing vehicles : " + count2);
		System.out.println("average passing vehicles : " + average);
	
			
	}

	private static <T> double calculateAverageOn(List<T> list, ToIntFunction<T> function) {
		double average = list
				.stream()
				.mapToInt(function)
				.average()
				.getAsDouble();
		return average;
	}
	
	private static int calculateSumOn(List<TrafficEntry> list, ToIntFunction<TrafficEntry> function) {
		
	}

}
