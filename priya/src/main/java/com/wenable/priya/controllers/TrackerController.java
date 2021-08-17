package com.wenable.priya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.priya.beans.Tracker;
import com.wenable.priya.services.TrackerService;

@RestController

public class TrackerController {
	
	@Autowired
	TrackerService service;
	
	@PostMapping("/track/signup")
	public ResponseEntity<Tracker> addTrack(@RequestBody Tracker bean)
	{
		Tracker track=service.addTrack(bean);
		return ResponseEntity.ok(track);
	}
	
	@GetMapping("/track/all")
	public ResponseEntity<List<Tracker>> getTrack()
	{
		List<Tracker> track=service.getTrack();
		return ResponseEntity.ok(track);
	}
	
	@GetMapping("/track/{trackId}")
	public ResponseEntity<Tracker> getByTrackId(@PathVariable String trackId)
	{
		Tracker track=service.getByTrackId(trackId);
		return ResponseEntity.ok(track);
	}

	@PutMapping("/update/{trackId}")
	public ResponseEntity<Tracker> updateTrack(@RequestBody Tracker bean,@PathVariable String trackId)
	{
		Tracker track=service.updateTrack(bean,trackId);
		return ResponseEntity.ok(track);
	}
	
	@DeleteMapping("delete/{trackId}")
	public void deletetrack (@PathVariable String trackId)
	{
		service.delete(trackId);
	}
}
