package com.res.service;

import com.res.model.Address;

public interface AddressService {

	public void save(Address address);
	public void update(Address address);
	public void delete(Address address);
	public Address findByAddressId(long id);
}
