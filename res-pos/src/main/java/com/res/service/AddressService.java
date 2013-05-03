package com.res.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.res.model.Address;

public interface AddressService {

	public void save(Address address);
	public void update(Address address);
	public void delete(Address address);
	public Address findByAddressId(long id);
	public List<Address> listAddress();
	
	@Secured({"ROLE_ADMIN"})
	public void deleteAddress(long id);
}
