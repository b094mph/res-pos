package com.res.service;

import java.util.List;

import com.res.model.FoodCategory;
import com.res.model.Menu;

public interface MenuService {

	public List<Long> getFoodCategoryIdsFromMenu(long restaurantId);
	public List<FoodCategory> getFoodCategoriesFromMenu(long restaurantId);
	public List<Menu> getMenuByFoodCategory(long restaurantId, long foodCategoryId);
	public Menu getMenuByMenuId(long menuId);
}
