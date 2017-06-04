package com.server.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class JumpLogicAction extends ActionSupport{
	private static final long serialVersionUID = 8446226297293417570L;
	
	public String check_add_jump(){
		if(ActionContext.getContext().getSession().get("username").equals("admin")){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String check_bookmanage_jump(){
		if(ActionContext.getContext().getSession().get("username").equals("admin")){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String check_searchbook_jump(){
		if(ActionContext.getContext().getSession().get("username").equals("admin")){
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
}
