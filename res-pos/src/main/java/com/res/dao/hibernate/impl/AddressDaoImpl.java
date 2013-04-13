package com.res.dao.hibernate.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.AddressDao;
import com.res.model.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

	private static Logger logger = Logger.getLogger(AddressDaoImpl.class);
	
	@Override
	public Address findByAddressId(long id) {
		return (Address) currentSession().get(getClass(), id);
	}

}
