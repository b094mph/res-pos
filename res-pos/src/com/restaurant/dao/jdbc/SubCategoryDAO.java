package com.restaurant.dao.jdbc;

import java.util.List;

import com.restaurant.model.SubCategory;

public interface SubCategoryDAO {

	public List<SubCategory> getSubCategoriesByCategoryId(String id);
	public SubCategory getSubCategoryById(String id);

}
