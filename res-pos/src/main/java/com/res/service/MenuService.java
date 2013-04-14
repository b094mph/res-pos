package com.res.service;

import java.util.List;
import java.util.Set;

import com.res.model.FoodCategory;
import com.res.model.Menu;

public interface MenuService {

	public Set<FoodCategory> getFoodCategoriesFromMenu(long restaurantId);
	public List<Menu> getMenuByFoodCategory(long restaurantId, String foodCategoryName);
}
