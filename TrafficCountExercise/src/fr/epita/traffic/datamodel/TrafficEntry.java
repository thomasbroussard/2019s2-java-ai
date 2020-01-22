package fr.epita.traffic.datamodel;

import java.util.Date;

public class TrafficEntry {
	
	//ID (0)
	private Integer id;
	
	//Traffic Volume Count Location  Address (1)
	private String trafficVolumeLocationAddress;
	
	//Street(2)
	private String street;
	
	//Indexed from Street
	private String indexedStreet;
	
	
	//Date of Count(3)
	private Date dateOfCount;
	
	private Integer weekNumber;
	
	private Integer dayInWeek;
	
	
	

	// Total Passing Vehicle Volume(4)
	private Integer totalPassingVehicleVolumes;
	
	// VehicleVolumeByEachDirectionOfTraffic(5)
	private Integer vehicleVolumeForMainDirection;
	
	// VehicleVolumeByEachDirectionOfTraffic(5)
	private Integer vehicleVolumeForOppositeDirection;
	
	// Latitude(6)
	private Double latitude;
	
	// longitude(7)
	private Double longitude;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrafficVolumeLocationAddress() {
		return trafficVolumeLocationAddress;
	}

	public void setTrafficVolumeLocationAddress(String trafficVolumeLocationAddress) {
		this.trafficVolumeLocationAddress = trafficVolumeLocationAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Date getDateOfCount() {
		return dateOfCount;
	}

	public void setDateOfCount(Date dateOfCount) {
		this.dateOfCount = dateOfCount;
	}

	public Integer getTotalPassingVehicleVolumes() {
		return totalPassingVehicleVolumes;
	}

	public void setTotalPassingVehicleVolumes(Integer totalPassingVehicleVolumes) {
		this.totalPassingVehicleVolumes = totalPassingVehicleVolumes;
	}


	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getIndexedStreet() {
		return indexedStreet;
	}

	public void setIndexedStreet(String indexedStreet) {
		this.indexedStreet = indexedStreet;
	}

	public Integer getVehicleVolumeForMainDirection() {
		return vehicleVolumeForMainDirection;
	}

	public void setVehicleVolumeForMainDirection(Integer vehicleVolumeForMainDirection) {
		this.vehicleVolumeForMainDirection = vehicleVolumeForMainDirection;
	}

	public Integer getVehicleVolumeForOppositeDirection() {
		return vehicleVolumeForOppositeDirection;
	}

	public void setVehicleVolumeForOppositeDirection(Integer vehicleVolumeForOppositeDirection) {
		this.vehicleVolumeForOppositeDirection = vehicleVolumeForOppositeDirection;
	}

	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	public Integer getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(Integer dayInWeek) {
		this.dayInWeek = dayInWeek;
	}




	

}
