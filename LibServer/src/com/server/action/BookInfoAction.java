package com.server.action;

import com.opensymphony.xwork2.ActionSupport;
import com.server.service.IBookInfoService;

public class BookInfoAction extends ActionSupport{

	private static final long serialVersionUID = -9221533619992759667L;
	private IBookInfoService bookInfoService;
	public IBookInfoService getBookInfoService() {
		return bookInfoService;
	}
	public void setBookInfoService(IBookInfoService bookInfoService) {
		this.bookInfoService = bookInfoService;
	}
	

}
