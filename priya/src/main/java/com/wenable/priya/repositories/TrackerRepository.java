package com.wenable.priya.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wenable.priya.beans.Tracker;

public interface TrackerRepository extends MongoRepository<Tracker, String>{

}
