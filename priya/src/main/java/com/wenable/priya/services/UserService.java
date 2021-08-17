package com.wenable.priya.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.wenable.priya.beans.User;
import com.wenable.priya.dao.UserDao;
import com.wenable.priya.repositories.UserRepository;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao dao;
    
    @Autowired
    UserRepository repo;
    
    public User add(User bean,boolean wer) throws Exception {
		User user=null;
		if(bean.getPassword()==null)
		{
			throw new Exception("password cant be null");
		}
		if(wer)
		{
			throw new Exception("username already exist");
		}
		else
		{
			user=dao.add(bean);	
		}
		return user;	 
	}
    
    public boolean existsByUsername(String userName) {
		return dao.existsByUsername(userName);
	}

    public List<User> getAll() {
		
		return dao.getAll();
	}
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user=repo.findByUsername(username);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());

    }

	public User addUserToTrackId(String id, User bean) {
			User user=getById(id);
			if(user.getTrackId()!=null)
			{
				System.out.println("trackid already exist");
			}
			else
			{
				user.setTrackId(bean.getTrackId());
			}
			return dao.add(user);
		}

	public User getById(String id) {		
		return dao.getById(id);
	}

	public List<User> getByTrackId(String trackId) {
		
		return dao.getByTrackId(trackId);
	}

	public void deleteById(String id) {
		dao.deleteById(id);	
	}

	
}
