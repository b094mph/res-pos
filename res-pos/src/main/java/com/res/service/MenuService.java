package com.res.service;

import java.math.BigDecimal;
import java.util.List;

import com.res.model.FoodCategory;
import com.res.model.Menu;

public interface MenuService {

	public List<Long> getFoodCategoryIdsFromMenu(long restaurantId);
	public List<FoodCategory> getFoodCategoriesFromMenu(long restaurantId);
	public List<Menu> getMenuByFoodCategory(long restaurantId, long foodCategoryId);
	public Menu getMenuByMenuId(long menuId);
	public List<Menu> getMenu(long restaurantId);
	public void updateMenuPrices(long menuId, BigDecimal small, 
			BigDecimal large, BigDecimal lunch, BigDecimal combo);
	
}
