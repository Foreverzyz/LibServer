package com.server.action;

import com.opensymphony.xwork2.ActionSupport;
import com.server.service.IModelInfoService;

public class ModelInfoAction extends ActionSupport{

	private static final long serialVersionUID = -1076951657115957016L;
	private IModelInfoService modelInfoService;

	public IModelInfoService getModelInfoService() {
		return modelInfoService;
	}

	public void setModelInfoService(IModelInfoService modelInfoService) {
		this.modelInfoService = modelInfoService;
	}
	
}
