package com.server.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.server.dao.BaseDao;
import com.server.dao.IRssiDao;
import com.server.entity.Rssi;

public class RssiDaoImpl extends BaseDao implements IRssiDao {
	
	@Override
	public boolean collectRssi(Rssi rs) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(rs);
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<Rssi> getRssiList() {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Rssi";		
		Query query = session.createQuery(hql);
		tx.commit();
		@SuppressWarnings("unchecked")
		List<Rssi> list = query.list();
		return list;
	}
}
