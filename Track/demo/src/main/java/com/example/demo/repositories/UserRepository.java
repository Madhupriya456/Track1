package com.example.demo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.example.demo.beans.User;


public interface UserRepository extends MongoRepository<User,String> {

	@Query("{userName: ?0}")
	User findByUsername(String username);
	
	 @Query(value="{userName: ?0}",exists= true)
	  	boolean existsByUsername(String userName);

	  
	  
}
