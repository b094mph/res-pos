package com.res.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.AddressDao;
import com.res.model.Address;
import com.res.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;

	@Transactional
	public void save(Address address) {
		addressDao.save(address);
	}

	@Transactional
	public void update(Address address) {
		addressDao.update(address);

	}

	@Transactional
	public void delete(Address address) {
		addressDao.delete(address);

	}

	@Transactional
	public Address findByAddressId(long id) {
		return addressDao.findByAddressId(id);
	}

}
