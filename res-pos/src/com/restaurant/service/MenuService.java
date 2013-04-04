package com.restaurant.service;

import java.util.List;

import com.restaurant.dao.jdbc.MenuDAO;
import com.restaurant.model.Menu;

public class MenuService {

	private MenuDAO menuDao;

	public List<Menu> getWholeMenu(){
		return menuDao.getWholeMenu();
	}

	public void setMenuDao(MenuDAO menuDao) {
		this.menuDao = menuDao;
	}
	
}
