package com.res.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.CustomerDao;
import com.res.domain.Person;
import com.res.exception.ServiceException;
import com.res.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private static Logger logger = Logger.getLogger(CustomerServiceImpl.class);
	
	@Autowired private CustomerDao customerDao;

	@Override
	public void save(Person customer) {
		Long personId = customerDao.isPhoneNumUnique(customer.getPhone1());
		
		if(personId == null){
			customerDao.save(customer);
		}else{
			if(logger.isDebugEnabled()){
				logger.debug("phone number is not unique, updating.");
			}
			customer.setPersonId(personId);
			customerDao.update(customer);
		}
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
	public Set<String> typeaheadPhoneNumber(long restaurantId) {
		List<String> phone1List = customerDao.typeaheadAttribute(restaurantId, "phone1");
		List<String> phone2List = customerDao.typeaheadAttribute(restaurantId, "phone2");
		logger.info("Combining phone1List and phone2List into a HashSet.");
		phone1List.addAll(phone2List);
		return new HashSet<String>(phone1List);
	}

	@Override
	public List<String> typeaheadFirstName(long restaurantId) {
		return customerDao.typeaheadAttribute(restaurantId, "firstName");
	}

	@Override
	public List<String> typeaheadLastName(long restaurantId) {
		return customerDao.typeaheadAttribute(restaurantId, "lastName");
	}

	@Override
	public List<String> typeaheadEmail(long restaurantId) {
		return customerDao.typeaheadAttribute(restaurantId, "email");
	}

	@Override
	public List<String> typeaheadNote(long restaurantId) {
		return customerDao.typeaheadAttribute(restaurantId, "note");
	}

}
