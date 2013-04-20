package com.res.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.MenuDao;
import com.res.model.FoodCategory;
import com.res.model.Menu;
import com.res.service.MenuService;

@Service("MenuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public Set<FoodCategory> getFoodCategoriesFromMenu(long restaurantId) {
		List<Menu> menuList = menuDao.menuByRestaurantId(restaurantId);
		Set<FoodCategory> foodCategorySet = new HashSet<FoodCategory>();
		for(Menu menu : menuList){
			foodCategorySet.add(menu.getFoodCategory());
		}
		logger.debug("FoodCategory size = " + foodCategorySet.size());
		return foodCategorySet;
	}

	@Override
	public List<Menu> getMenuByFoodCategory(long restaurantId, String foodCategoryName) {
		List<Menu> foodList = menuDao.getMenuByFoodCategory(restaurantId, foodCategoryName);
		return foodList;
	}

}
