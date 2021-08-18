package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.beans.User;
import com.example.demo.dao.UserDao;
import com.example.demo.repositories.UserRepository;

public  class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository repo;
	
	public User add(User user)
	{
		return repo.save(user);		
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
	public void deleteById(String id) {
	repo.deleteById(id);
		
	}

	@Override
	public User update(String id, User bean) {
		
		return repo.save(bean);
	}

	
//	@Override
//	public boolean existsByUsernamePassword(String userName,String password) {
//		return repo.existsByUsernamePassword(userName,password);
//	}

	@Override

	public boolean existsByUsername(String userName) {
		return repo.existsByUsername(userName);
	}

@Override
public List<User> getBySchoolId(String schoolId) {
	// TODO Auto-generated method stub
	return null;
}


		
	
}
