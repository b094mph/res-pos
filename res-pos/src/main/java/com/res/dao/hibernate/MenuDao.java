package com.res.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.res.model.FoodCategory;
import com.res.model.Menu;

public interface MenuDao extends BaseDao {

	public List<Long> getFoodCategoryIdsFromMenu(long restaurantId);
	public List<FoodCategory> getFoodCategoriesFromMenu(long restaurantId);
	public List<Menu> getMenuByFoodCategory(long restaurantId, long foodCategoryId);
	public Menu getMenuByMenuId(long menuId);
	public List<Menu> getMenu(long restaurantId);
	public void updateMenu(long menuId, String menuNum, BigDecimal small, 
			BigDecimal large, String lunchNum, BigDecimal lunch, String comboNum, BigDecimal combo,
			Boolean isSpicy, Boolean hasRice, Boolean hasSauce,
			Boolean hasNoodles, Integer numPieces, Boolean isAppetizerCombo, String lastUpdatedBy);
}
