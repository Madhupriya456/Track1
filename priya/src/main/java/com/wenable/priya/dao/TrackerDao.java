package com.wenable.priya.dao;

import java.util.List;

import com.wenable.priya.beans.Tracker;

public interface TrackerDao {

	Tracker add(Tracker bean);

	List<Tracker> getAll();

	Tracker update(Tracker bean, String trackId);

	void deleteById(String trackId);

	Tracker getByTrackId(String trackId);

}
