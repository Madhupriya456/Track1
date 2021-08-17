package com.wenable.priya.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.wenable.priya.beans.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	 @Query(value="{username: ?0}",exists= true)
	  	boolean existsByUsername(String userName);

	 
	 @Query("{username: ?0}")
	User findByUsername(String username);

	 @Query("{trackId: ?0}")
	List<User> findBytrackId(String trackId);

}
