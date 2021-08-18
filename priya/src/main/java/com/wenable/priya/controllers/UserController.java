package com.wenable.priya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.priya.beans.Token;
import com.wenable.priya.beans.User;
import com.wenable.priya.dao.impl.UserDaoImpl;
import com.wenable.priya.services.UserService;
import com.wenable.priya.utils.JwtUtil;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	UserDaoImpl impl;
	
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
	 public ResponseEntity<Token> generateToken(@RequestBody User bean) throws Exception 
	 {
	    try 
	    {
	       authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(bean.getUsername(), bean.getPassword()));
	    } 
	    catch (Exception ex) 
	    {
	            throw new Exception("inavalid username/password");
	    }
	    final UserDetails userDetails=impl.loadUserByUsername(bean.getUsername());
	    final String jwt=util.generateToken(userDetails);
	    return ResponseEntity.ok(new Token(jwt));
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
	  
	  @PutMapping("/{id}")
	  public ResponseEntity<User> updateUser(@RequestBody User bean,@PathVariable String id)
	  {
		  User user=service.update(id,bean);
		  return ResponseEntity.ok(user);
	  }
}
