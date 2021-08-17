package com.wenable.priya.beans;


import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;

public class Tracker {
    @Id
    private String trackId;
	private String latitude;
	private String longitude;	
	private String place;
	
	private String time;
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTrackId() {
		return trackId;
	}
	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}
	
	public LocalDateTime getTime() {
		
		return time1;
	}
	public void setTime(String time1) {
		this.time = time1;
	}
	
		LocalDateTime time1= LocalDateTime.now();
}
