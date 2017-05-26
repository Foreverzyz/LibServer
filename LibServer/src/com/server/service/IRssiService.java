package com.server.service;

import java.util.List;
import com.server.entity.Rssi;

public interface IRssiService {
	public boolean collectRssi(Rssi rs);
	public List<Rssi> getRssiList();
}
