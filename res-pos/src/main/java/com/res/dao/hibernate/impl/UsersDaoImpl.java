package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.UsersDao;
import com.res.model.Users;

@Repository("usersDao")
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao {
	
	private static Logger logger = Logger.getLogger(UsersDaoImpl.class);

	@Override
	public Users findUser(long id) {
		return (Users) getCurrentSession().get(getClass(), id);
	}

	@Override
	public Users getUserByUsername(String username) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Users u WHERE u.username = :username");
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setString("username", username);
		if(!query.list().isEmpty()){
			return (Users) query.list().get(0);
		}else{
			logger.info("User not found.");
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getUsernames() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT u.username FROM Users u");
		Query query = getCurrentSession().createQuery(sb.toString());
		return (List<String>) query.list();
	}

}
