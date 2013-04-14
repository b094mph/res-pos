package com.res.dao.hibernate;

import java.util.List;

import com.res.model.Menu;

public interface MenuDao extends BaseDao {

	public List<Menu> menuByRestaurantId(long restaurantId);
	public List<Menu> getMenuByFoodCategory(long restaurantId, String foodCategoryName);
}
