package com.res.service;

import java.util.List;

import com.res.model.Person;

public interface CustomerService {

	public void save(Person customer);
	public void update(Person customer);
	public void delete(Person customer);
	public Person findCustomer(long id);
	public List<Person> listCustomers();
	public void deleteCustomer(long id);
}
