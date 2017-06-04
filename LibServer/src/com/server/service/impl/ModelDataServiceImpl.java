package com.server.service.impl;

import com.server.dao.IModelDataDao;
import com.server.service.IModelDataService;

public class ModelDataServiceImpl implements IModelDataService {
	
	private IModelDataDao modelDataDAO;


	public IModelDataDao getModelDataDAO() {
		return modelDataDAO;
	}

	public void setModelDataDAO(IModelDataDao modelDataDAO) {
		this.modelDataDAO = modelDataDAO;
	}
}
