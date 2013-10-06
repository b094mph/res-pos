package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.UserDao;
import com.res.domain.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public User findUser(long id) {
		return (User) getCurrentSession().get(getClass(), id);
	}

	@Override
	public User getUserByUsername(String username) {
		Query query = getCurrentSession().getNamedQuery("getUserByUsername");
		query.setString("username", username);
		if(!query.list().isEmpty()){
			return (User) query.list().get(0);
		}else{
			logger.info("User not found.");
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getUsernames() {
		Query query = getCurrentSession().getNamedQuery("getUsernames");
		return (List<String>) query.list();
	}

}
