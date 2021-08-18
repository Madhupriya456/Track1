package com.wenable.priya.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wenable.priya.beans.Tracker;
import com.wenable.priya.dao.TrackerDao;
import com.wenable.priya.repositories.TrackerRepository;

@Repository
public class TrackerDaoImpl implements TrackerDao{

	@Autowired
	TrackerRepository repo;
	
	@Override
	public Tracker add(Tracker bean) {
		return repo.save(bean);
	}

	@Override
	public List<Tracker> getAll() {		
		return repo.findAll();
	}

	@Override
	public Tracker update(Tracker bean, String trackId) {
		return repo.save(bean);
	}

	@Override
	public void deleteById(String trackId) {
		repo.deleteById(trackId);
	}

	@Override
	public Tracker getByTrackId(String trackId) {
		return repo.findById(trackId).orElse(null);
	}
	  
}
