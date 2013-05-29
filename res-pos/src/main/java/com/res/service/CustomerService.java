package com.res.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.access.annotation.Secured;

import com.res.model.Person;

public interface CustomerService {

	public void save(Person customer);
	public void update(Person customer);
	public void delete(Person customer);
	public Person findCustomer(long id);
	public List<Person> listCustomers();
	public Set<String> typeaheadPhoneNumber(long restaurantId);
	public List<String> typeaheadFirstName(long restaurantId);
	public List<String> typeaheadLastName(long restaurantId);
	public List<String> typeaheadEmail(long restaurantId);
	public List<String> typeaheadNote(long restaurantId);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteCustomer(long id);
}
