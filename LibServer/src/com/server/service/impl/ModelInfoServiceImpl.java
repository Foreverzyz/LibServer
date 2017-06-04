package com.server.service.impl;

import com.server.dao.IModelInfoDao;
import com.server.service.IModelInfoService;

public class ModelInfoServiceImpl implements IModelInfoService {
	private IModelInfoDao modelInfoDAO;

	public IModelInfoDao getModelInfoDAO() {
		return modelInfoDAO;
	}

	public void setModelInfoDAO(IModelInfoDao modelInfoDAO) {
		this.modelInfoDAO = modelInfoDAO;
	}

	
	
}
