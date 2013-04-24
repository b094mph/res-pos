package com.res.dao.hibernate.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.CustomerDao;
import com.res.model.Person;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao{
	
	private static Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Override
	public Person findCustomer(long id) {
		return (Person) getCurrentSession().get(getClass(), id);
		
	}

}
