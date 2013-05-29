package com.res.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.CustomerDao;
import com.res.model.Person;
import com.res.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	@Autowired private CustomerDao customerDao;

	@Override
	public void save(Person customer) {
		customerDao.save(customer);
	}

	@Override
	public void update(Person customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Person customer) {
		customerDao.delete(customer);
	}

	@Override
	public Person findCustomer(long id) {
		return customerDao.findCustomer(id);
	}

	@Override
	public List<Person> listCustomers() {
		return customerDao.listCustomers();
	}

	@Override
	public void deleteCustomer(long id) {
		customerDao.deleteCustomer(id);
	}

	@Override
	public List<String> findPhoneNumbers(long restaurantId) {
		return customerDao.findPhoneNumbers(restaurantId);
	}

}
