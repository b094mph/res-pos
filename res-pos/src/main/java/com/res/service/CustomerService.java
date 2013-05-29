package com.res.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.res.model.Person;

public interface CustomerService {

	public void save(Person customer);
	public void update(Person customer);
	public void delete(Person customer);
	public Person findCustomer(long id);
	public List<Person> listCustomers();
	public List<String> findPhoneNumbers(long restaurantId);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteCustomer(long id);
}
