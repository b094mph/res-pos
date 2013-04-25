package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.AddressDao;
import com.res.model.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

	private static Logger logger = Logger.getLogger(AddressDaoImpl.class);
	
	@Override
	public Address findByAddressId(long id) {
		return (Address) getCurrentSession().get(getClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> listAddress() {
		return getCurrentSession().createQuery("FROM Address").list();
	}

}
