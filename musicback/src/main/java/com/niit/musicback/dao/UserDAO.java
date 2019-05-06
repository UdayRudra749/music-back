package com.niit.musicback.dao;

import com.niit.musicback.model.User;

public interface UserDAO {
	
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);

}
