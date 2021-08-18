package com.wenable.priya.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wenable.priya.beans.User;
import com.wenable.priya.dao.UserDao;
import com.wenable.priya.repositories.UserRepository;

@Service
public class UserService  {

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
    
	public User addUserToTrackId(String id, User bean) 
	{
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

	public User update(String id, User bean) {
		User user=getById(id);
		if(user!=null)
		{
			if(bean.getPassword()!=null)
			{
				user.setPassword(bean.getPassword());
			}
			if(bean.getMobileno()!=null)
			{
				user.setMobileno(bean.getMobileno());
			}
		}
		return dao.add(user);
		
	}
	
}
