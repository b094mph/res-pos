package com.restaurant.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.restaurant.dao.jdbc.CategoryDAO;
import com.restaurant.model.Category;

public class CategoryDAOImpl extends JdbcDaoSupport implements CategoryDAO{

	private static final Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
	
	@Override
	public Category getCategoryById(int id) throws SQLException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM Category WHERE id = ?");
		
		LOGGER.info(sb);
		
		Object[] args = {id};
		
		return (Category) this.getJdbcTemplate().queryForObject(sb.toString(), args, new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
				return category;
			}
			
		});
	}

	@Override
	public List<Category> getCategories() {
		
		List<Category> categoryList = new ArrayList<Category>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM Category");
		
		LOGGER.info(sb);
		
		SqlRowSet rowSet = this.getJdbcTemplate().queryForRowSet(sb.toString());
		
		while(rowSet.next()){
			Category category = new Category();
			category.setId(rowSet.getInt("id"));
			category.setName(rowSet.getString("name"));
			
			categoryList.add(category);
		}
		
		return categoryList;
	}

}
