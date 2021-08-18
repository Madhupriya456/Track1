package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.User;
import com.example.demo.services.UserService;
import com.example.demo.util.JwtUtility;


@RestController

public class TokenController {
    
	@Autowired
	UserService service;
	
	@Autowired
	JwtUtility util;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public ResponseEntity<String> get()
	{
		return ResponseEntity.ok("Hii");
	}
	 @PostMapping("/authenticate")
	    public String authenticate(@RequestBody User bean) throws Exception{

	        try {
	                authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                            bean.getUserName(),
	                            bean.getPassword()
	                    )
	            );
	        }  catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        return util.generateToken(bean.getUserName());
	    }
}
