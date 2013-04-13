package com.res.dao.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.res.dao.hibernate.BaseDao;

public class BaseDaoImpl implements BaseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Object obj) {
		this.getCurrentSession().save(obj);
	}

	@Override
	public void update(Object obj) {
		this.getCurrentSession().update(obj);
	}

	@Override
	public void saveOrUpdate(Object obj) {
		this.getCurrentSession().saveOrUpdate(obj);
	}

	@Override
	public void delete(Object obj) {
		this.getCurrentSession().delete(obj);
	}

	@Override
	public void merge(Object obj) {
		this.getCurrentSession().merge(obj);
	}

}
