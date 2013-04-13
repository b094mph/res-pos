package com.res.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.AddressDao;
import com.res.model.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

	@Override
	public Address findByAddressId(long id) {
		return (Address) currentSession().get(getClass(), id);
	}

}
