package com.server.dao;

import com.server.entity.User;


public interface IUserDao {
	public boolean validateLogin(String username,String passwd);
	public boolean addUser(User user);
}
