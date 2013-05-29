package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.CustomerDao;
import com.res.model.Person;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDaoImpl implements CustomerDao{
	
	private static Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@Override
	public Person findCustomer(long id) {
		return (Person) getCurrentSession().get(getClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listCustomers() {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Person");
		return getCurrentSession().createQuery(sb.toString()).list();
	}

	@Override
	public void deleteCustomer(long id) {
		Person customer = (Person) getCurrentSession().load(Person.class, id);
		try{
			logger.info("Attempting to delete customer with personId = " + id);
			super.delete(customer);
		}catch(NullPointerException e){
			logger.info("Can not delete customer with personId = " + id);
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> typeaheadAttribute(long restaurantId, String attribute) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT ");
		sb.append(attribute);
		sb.append(" FROM CustomerOrder co ");
		sb.append("INNER JOIN co.customer p ");
		sb.append("WHERE co.restaurantId = :restaurantId");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		
		return query.list();
	}

}
