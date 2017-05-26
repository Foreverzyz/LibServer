package com.server.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.server.service.IUserService;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = -3237272788137360516L;
	private IUserService userService;
	private String username;
	private String password;
	private Map session;
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validateLogin(){
		if (userService.validateLogin(username, password)) {
			ActionContext.getContext().getSession().put("username", getUsername());
			ActionContext.getContext().getSession().put("password", getPassword());
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String check_add_jump(){
		if(ActionContext.getContext().getSession().get("username").equals("admin")){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
