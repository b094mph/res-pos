package com.res.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.MenuDao;
import com.res.model.FoodCategory;
import com.res.model.Menu;
import com.res.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<Long> getFoodCategoryIdsFromMenu(long restaurantId) {
		return menuDao.getFoodCategoryIdsFromMenu(restaurantId);
	}
	
	@Override
	public List<FoodCategory> getFoodCategoriesFromMenu(long restaurantId){
		return menuDao.getFoodCategoriesFromMenu(restaurantId);
	}

	@Override
	public List<Menu> getMenuByFoodCategory(long restaurantId, long foodCategoryId) {
		return menuDao.getMenuByFoodCategory(restaurantId, foodCategoryId);
	}

	@Override
	public Menu getMenuByMenuId(long menuId) {
		return menuDao.getMenuByMenuId(menuId);
	}

	@Override
	public List<Menu> getMenu(long restaurantId) {
		return menuDao.getMenu(restaurantId);
	}

	@Override
	public void updateMenu(long menuId, String menuNum, BigDecimal small,
			BigDecimal large, String lunchNum, BigDecimal lunch,
			String comboNum, BigDecimal combo, Boolean isSpicy,
			Boolean hasRice, Boolean hasSauce, Boolean hasNoodles,
			Integer numPieces, Boolean isAppetizerCombo, String lastUpdatedBy) {
		
		menuDao.updateMenu(menuId, menuNum, small, large, lunchNum, lunch, comboNum, combo, 
				isSpicy, hasRice, hasSauce, hasNoodles, numPieces, isAppetizerCombo, lastUpdatedBy);
		
	}

}
