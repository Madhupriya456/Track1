package com.wenable.priya.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.wenable.priya.beans.User;
import com.wenable.priya.dao.UserDao;
import com.wenable.priya.repositories.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
     
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

}
