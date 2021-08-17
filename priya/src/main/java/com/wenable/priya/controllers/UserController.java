package com.wenable.priya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.priya.beans.User;
import com.wenable.priya.services.UserService;
import com.wenable.priya.utils.JwtUtil;



@RestController

public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping("/signup")
	   public ResponseEntity<User> addUser(@RequestBody User bean) throws Exception 
	   {
		   boolean wer=service.existsByUsername(bean.getUsername());  
	       User user=service.add(bean,wer);
		   return ResponseEntity.ok(user);
	   }
		
	   @GetMapping("/all")
	   public ResponseEntity<List<User>> getUser()
	   {
		  List<User> user=service.getAll();
		  return ResponseEntity.ok(user);
	   }
	
	   @PostMapping("/login")
	    public ResponseEntity<String> generateToken(@RequestBody User bean) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(bean.getUsername(), bean.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        String token=util.generateToken(bean.getUsername());
	        return ResponseEntity.ok(token);
	    }
	   
	   @GetMapping("/user/{id}")
	   public ResponseEntity<User> getById(@PathVariable String id)
	   {
		   User user=service.getById(id);
		   return ResponseEntity.ok(user);
	   }
	   
	  @PostMapping("/{id}")
	  public ResponseEntity<User> addUserToTrackId(@RequestBody User bean,@PathVariable String id)
	   {
		   User user=service.addUserToTrackId(id,bean);
		   return ResponseEntity.ok(user);
	   }
	  
	  @GetMapping("/{trackId}")
	  public ResponseEntity<List<User>> getByTrackId(@PathVariable String trackId)
	  {
		  List<User> user=service.getByTrackId(trackId);
		   return ResponseEntity.ok(user);
	  }
	  
	  @DeleteMapping("/{id}")
	  public void deleteById(@PathVariable String id)
	   {
		   service.deleteById(id);
		  
	   }
}
