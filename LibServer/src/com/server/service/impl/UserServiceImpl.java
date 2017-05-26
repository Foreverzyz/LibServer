package com.server.service.impl;

import com.server.dao.IUserDao;
import com.server.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean validateLogin(String username, String passwd) {		
		return userDao.validateLogin(username, passwd);
	}

}
