package com.restaurant.service;

import java.util.List;

import com.restaurant.dao.jdbc.SubCategoryDAO;
import com.restaurant.model.SubCategory;

public class SubCategoryService {

	private SubCategoryDAO subCategoryDao;
	
	public List<SubCategory> getSubCategoriesByCategoryId(String id){
		return subCategoryDao.getSubCategoriesByCategoryId(id);
	}

	public void setSubCategoryDao(SubCategoryDAO subCategoryDao) {
		this.subCategoryDao = subCategoryDao;
	}
}
