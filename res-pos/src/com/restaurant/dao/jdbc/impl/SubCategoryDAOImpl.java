package com.restaurant.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.restaurant.dao.jdbc.SubCategoryDAO;
import com.restaurant.model.Price;
import com.restaurant.model.SubCategory;

public class SubCategoryDAOImpl extends JdbcDaoSupport implements SubCategoryDAO {

	private static final Logger LOGGER = Logger.getLogger(SubCategoryDAOImpl.class);
	
	@Override
	public List<SubCategory> getSubCategoriesByCategoryId(String id) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT s.Id, s.CategoryId, s.ShortName, s.LongName, s.Description, s.Spicy " +
				"FROM SubCategory s " +
				"WHERE categoryId = ?");
		
		LOGGER.info(sb.toString());
		LOGGER.info("CategoryId >>> " + id);

		Object[] args = {new Integer(id)};
		int[] argTypes = {Types.INTEGER};
		
		SqlRowSet rs = this.getJdbcTemplate().queryForRowSet(sb.toString(), args, argTypes);
		
		List<SubCategory> subCategories = new ArrayList<SubCategory>();
		
		while(rs.next()){
			SubCategory subCategory = new SubCategory();
			subCategory.setId(rs.getInt("Id"));
			subCategory.setCategoryId(rs.getInt("CategoryId"));
			subCategory.setShortName(rs.getString("ShortName"));
			subCategory.setLongName(rs.getString("LongName"));
			subCategory.setDescription(rs.getString("Description"));
			subCategory.setSpicy(rs.getBoolean("Spicy"));

			subCategories.add(subCategory);
		}
		return subCategories;
	}
	
	@SuppressWarnings("unchecked")
	public SubCategory getSubCategoryById(String id){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT s.Id, s.CategoryId, s.ShortName, s.LongName, s.Description, s.Spicy, " +
				"s.Rice, s.Sauce, s.Noodle, s.Combo, s.Lunch, s.Pieces, p.Small, p.Large " +
				"FROM SubCategory s " +
				"INNER JOIN Price p ON p.PriceId=s.PriceId " +
				"WHERE s.Id= ?");
		
		LOGGER.info("SubCategoryDAOImpl >>> " + sb.toString());
		
		Object[] args = {new Integer(id)};
		
		return this.getJdbcTemplate().queryForObject(sb.toString(), args, new RowMapper(){
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				SubCategory subCategory = new SubCategory();
				subCategory.setId(rs.getInt("id"));
				subCategory.setCategoryId(rs.getInt("categoryId"));
				subCategory.setShortName(rs.getString("shortName"));
				subCategory.setLongName(rs.getString("longName"));
				subCategory.setDescription(rs.getString("description"));
				subCategory.setSpicy(rs.getBoolean("spicy"));
				subCategory.setRice(rs.getBoolean("rice"));
				subCategory.setSauce(rs.getBoolean("sauce"));
				subCategory.setNoodle(rs.getBoolean("noodle"));
				subCategory.setCombo(rs.getBoolean("combo"));
				subCategory.setLunch(rs.getBoolean("lunch"));
				subCategory.setPieces(rs.getInt("pieces"));
				
				Price price  = new Price();
				price.setSmall(rs.getDouble("Small"));
				price.setLarge(rs.getDouble("Large"));
				
				subCategory.setPrice(price);
				return subCategory;
			}
			
		});
	}

}
