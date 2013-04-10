package com.res.dao.hibernate;

import com.res.model.Address;

public interface AddressDao {

	public void save(Address address);
	public void update(Address address);
	public void delete(Address address);
	public Address findByAddressId(long id);
}
