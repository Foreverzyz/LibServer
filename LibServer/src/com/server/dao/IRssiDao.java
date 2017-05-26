package com.server.dao;

import java.util.List;

import com.server.entity.Rssi;

public interface IRssiDao {
	public boolean collectRssi(Rssi rs);
	public List<Rssi> getRssiList();
}
