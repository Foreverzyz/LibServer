package com.server.action;

import com.opensymphony.xwork2.ActionSupport;
import com.server.entity.Rssi;
import com.server.service.IRssiService;

public class GrssiAction extends ActionSupport{
	
	private static final long serialVersionUID = -2036587459243935176L;
	private IRssiService rService;
	private Rssi rssi;
	public IRssiService getrService() {
		return rService;
	}
	public void setrService(IRssiService rService) {
		this.rService = rService;
	}
	public Rssi getRssi() {
		return rssi;
	}
	public void setRssi(Rssi rssi) {
		this.rssi = rssi;
	}
}
