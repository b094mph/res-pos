package com.res.dao.hibernate.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.AddressDao;
import com.res.model.Address;

@Repository("addressDao")
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Address address) {
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void update(Address address) {
		sessionFactory.getCurrentSession().update(address);
	}

	@Override
	public void delete(Address address) {
		sessionFactory.getCurrentSession().delete(address);
	}

	@Override
	public Address findByAddressId(long id) {
		return (Address) sessionFactory.getCurrentSession().get(getClass(), id);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
