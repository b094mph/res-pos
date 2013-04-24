package com.res.dao.hibernate;

import com.res.model.Person;

public interface CustomerDao extends BaseDao {

	public Person findCustomer(long id);
}
