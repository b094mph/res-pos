package com.res.dao.hibernate;

import java.util.List;

import com.res.model.Address;

public interface AddressDao extends BaseDao{

	public Address findByAddressId(long id);
	public List<Address> listAddress();
	public void deleteAddress(long id);
}
