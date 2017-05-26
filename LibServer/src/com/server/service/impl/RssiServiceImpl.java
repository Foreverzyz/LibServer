package com.server.service.impl;

import java.util.List;
import com.server.dao.IRssiDao;
import com.server.entity.Rssi;
import com.server.service.IRssiService;

public class RssiServiceImpl implements IRssiService {
	private IRssiDao rssiDao;
	
	public IRssiDao getRssiDao() {
		return rssiDao;
	}

	public void setRssiDao(IRssiDao rssiDao) {
		this.rssiDao = rssiDao;
	}

	@Override
	public boolean collectRssi(Rssi rs) {		
		return rssiDao.collectRssi(rs);
	}

	@Override
	public List<Rssi> getRssiList() {
		return rssiDao.getRssiList();
	}

}
