package com.restaurant.dao.jdbc;

import java.util.List;

import com.restaurant.model.Menu;

public interface MenuDAO {

	public List<Menu> getWholeMenu();
	public List<Menu> getMenuByCategoryId(int id);
}
