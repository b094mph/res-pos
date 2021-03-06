package com.res.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.res.domain.Address;
import com.res.exception.ServiceException;

public interface AddressService {

	public void saveOrUpdate(Address address) throws ServiceException;
	public void update(Address address);
	public void delete(Address address);
	public Address findByAddressId(long id);
	public List<Address> listAddress();
	public List<String> typeaheadStreet1(long restaurantId);
	public List<String> typeaheadStreet2(long restaurantId);
	public List<String> typeaheadCity(long restaurantId);
	public List<String> typeaheadState(long restaurantId);
	public List<String> typeaheadZipcode(long restaurantId);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteAddress(long id);
}
