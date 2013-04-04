package com.restaurant.dao.jdbc;

import java.sql.SQLException;
import java.util.List;

import com.restaurant.model.Category;

public interface CategoryDAO {

	public Category getCategoryById(int id) throws SQLException;
	public List<Category> getCategories();
}
