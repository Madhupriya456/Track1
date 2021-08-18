package com.wenable.priya.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.wenable.priya.beans.User;
import com.wenable.priya.dao.UserDao;
import com.wenable.priya.repositories.UserRepository;

@Repository
public class UserDaoImpl implements UserDao ,UserDetailsService{
     
	@Autowired
	UserRepository repo;
	
	public User add(User user)
	{
		return repo.save(user);		
	}
	
	@Override
	public boolean existsByUsername(String userName) {
		return repo.existsByUsername(userName);
	}
	
	@Override
	public List<User> getAll() {	
		return repo.findAll();
	}

	@Override
	public User getById(String id) {		
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<User> getByTrackId(String trackId) {
		return repo.findBytrackId(trackId);
	}

	@Override
	public void deleteById(String id) {
		repo.deleteById(id);		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
	   User user=repo.findByUsername(username);
	   return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}
}
