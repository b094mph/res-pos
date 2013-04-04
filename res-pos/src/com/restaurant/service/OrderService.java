package com.restaurant.service;

import org.apache.log4j.Logger;

import com.restaurant.dao.jdbc.SubCategoryDAO;
import com.restaurant.model.Customer;
import com.restaurant.model.SubCategory;

public class OrderService {
	
	private static final Logger LOGGER = Logger.getLogger(OrderService.class);
	
	public SubCategoryDAO subCategoryDao;

	public void add(Customer customer){
		System.out.println("customer added successfully..." + customer.getFirstName());
	}
	
	public SubCategory getSubCategoryById(String id){
		LOGGER.info("OrderService >> getSubCategoryById " + id);
		return subCategoryDao.getSubCategoryById(id);
	}

	public void setSubCategoryDao(SubCategoryDAO subCategoryDao) {
		this.subCategoryDao = subCategoryDao;
	}

}
