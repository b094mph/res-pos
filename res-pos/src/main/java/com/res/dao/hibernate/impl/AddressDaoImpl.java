package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.AddressDao;
import com.res.domain.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

	private static Logger logger = Logger.getLogger(AddressDaoImpl.class);
	
	@Override
	public Address findByAddressId(long id) {
		return (Address) getCurrentSession().get(Address.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> listAddress() {
		return getCurrentSession().createQuery("FROM Address").list();
	}

	@Override
	public void deleteAddress(long id) {
		Address address = (Address) getCurrentSession().load(Address.class, id);
		try{
			logger.info("Attempting to delete address with addressId = " + id);
			super.delete(address);
		}catch(NullPointerException e){
			logger.info("Can not delete address with addressId = " + id);
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> typeaheadAttribute(long restaurantId, String attribute) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT a.");
		sb.append(attribute);
		sb.append(" FROM CustomerOrder co ");
		sb.append("INNER JOIN co.customer.address a ");
		sb.append("WHERE co.restaurantId = :restaurantId");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		
		return query.list();
	}

}
