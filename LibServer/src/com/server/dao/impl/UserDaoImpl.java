package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.server.dao.BaseDao;
import com.server.dao.IUserDao;
import com.server.entity.User;

public class UserDaoImpl extends BaseDao implements IUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean validateLogin(String username, String passwd) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from User u where u.username = ? and u.password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		query.setString(1, passwd);
		tx.commit();
		List<User> list = new ArrayList<User>();
		list = query.list();
		boolean flag;
		if (list.size() != 0) {
			flag = true;
			session.close();
			return flag;
		}else {
			flag = false;
			session.close();
			return flag;
		}		
	}

	@Override
	public boolean addUser(User user) {
		return false;
	}

}
