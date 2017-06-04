package com.server.action;

import com.opensymphony.xwork2.ActionSupport;
import com.server.service.IModelDataService;


public class ModelDataAction extends ActionSupport{

	private static final long serialVersionUID = 3107353585465873881L;
	private IModelDataService modelDataService;

	public IModelDataService getModelDataService() {
		return modelDataService;
	}

	public void setModelDataService(IModelDataService modelDataService) {
		this.modelDataService = modelDataService;
	}
	
	
}
