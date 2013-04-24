package com.res.service;

import com.res.model.Person;

public interface CustomerService {

	public void save(Person customer);
	public void update(Person customer);
	public void delete(Person customer);
	public Person findCustomer(long id);
}
