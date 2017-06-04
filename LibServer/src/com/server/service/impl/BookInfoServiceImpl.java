package com.server.service.impl;

import com.server.dao.IBookInfoDAO;
import com.server.service.IBookInfoService;

public class BookInfoServiceImpl implements IBookInfoService {
	private IBookInfoDAO bookInfoDAO;

	public IBookInfoDAO getBookInfoDAO() {
		return bookInfoDAO;
	}

	public void setBookInfoDAO(IBookInfoDAO bookInfoDAO) {
		this.bookInfoDAO = bookInfoDAO;
	}
	
	
}
