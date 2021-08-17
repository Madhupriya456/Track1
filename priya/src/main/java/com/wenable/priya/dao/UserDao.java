package com.wenable.priya.dao;

import java.util.List;

import com.wenable.priya.beans.User;

public interface UserDao {

	List<User> getAll();

	User add(User bean);

	boolean existsByUsername(String userName);

	User getById(String id);

	List<User> getByTrackId(String trackId);

	void deleteById(String id);

	

}
