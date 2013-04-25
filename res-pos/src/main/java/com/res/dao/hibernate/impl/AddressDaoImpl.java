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

	@Override
	public void deleteAddress(long id) {
		Address address = (Address) getCurrentSession().load(Address.class, id);
		logger.info("Attempting to delete address with id = " + id);
		try{
			getCurrentSession().delete(address);
		}catch(NullPointerException e){
			logger.info("Can not delete address with addressId = " + id);
			e.printStackTrace();
		}
	}

}
