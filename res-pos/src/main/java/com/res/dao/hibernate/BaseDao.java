package com.res.dao.hibernate;

import org.hibernate.Session;

public interface BaseDao {

	public Session getCurrentSession();
	public void save(Object obj);
	public void update(Object obj);
	public void saveOrUpdate(Object obj);
	public void delete(Object obj);
	public void merge(Object obj);
}
