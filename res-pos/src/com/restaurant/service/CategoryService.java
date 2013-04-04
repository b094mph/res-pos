package com.restaurant.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.restaurant.dao.jdbc.CategoryDAO;
import com.restaurant.model.Category;


public class CategoryService {

	private static final Logger LOGGER = Logger.getLogger(CategoryService.class);

	private CategoryDAO categoryDao;

	public Category getCategoryById(int id) throws Exception{
		LOGGER.info("id = " + id);
		Category c = categoryDao.getCategoryById(id);
		LOGGER.info("Category name is in SERVICE: " + c.getName());
		return c;
	}
	
	public List<Category> getCategories(){
		return categoryDao.getCategories();
	}
	
	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}
	
}
