package com.res.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.MenuDao;
import com.res.model.Menu;
import com.res.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	private static Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuDao menuDao;
	
	@Override
	public Set<Long> getFoodCategoriesFromMenu(long restaurantId) {
		List<Long> list = menuDao.getFoodCategoryIdsFromMenu(restaurantId);
		Set<Long> set = new HashSet<Long>();
		for(Long id : list){
			set.add(id);
		}
		return set;
	}

	@Override
	public List<Menu> getMenuByFoodCategory(long restaurantId, String foodCategoryName) {
		List<Menu> foodList = menuDao.getMenuByFoodCategory(restaurantId, foodCategoryName);
		return foodList;
	}

}
