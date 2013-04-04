package com.restaurant.dao.jdbc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.restaurant.dao.jdbc.MenuDAO;
import com.restaurant.model.Menu;

public class MenuDAOImpl extends JdbcDaoSupport implements MenuDAO {

	private static final Logger LOGGER = Logger.getLogger(MenuDAOImpl.class);
	
	@Override
	public List<Menu> getWholeMenu() {
		
		List<Menu> menuList = new ArrayList<Menu>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select s.id, c.name, s.shortName, s.longName, s.description, s.spicy, s.rice, s.sauce, ");
		sb.append("s.noodle, s.combo, s.lunch, s.pieces, p.small, p.large ");
		sb.append("from SubCateory s ");
		sb.append("inner join Category c on c.id=s.categoryId ");
		sb.append("inner join Price p on p.priceId=s.priceId");
		
		LOGGER.info("From MenuDAOImpl - "+ sb);
		
		SqlRowSet rs = this.getJdbcTemplate().queryForRowSet(sb.toString());
		
		//TODO: may need to use StringUtils.trimToEmpty, BooleanUtils, etc
		while(rs.next()){
			Menu menu = new Menu();
			menu.setId(rs.getInt("id"));
			menu.setName(StringUtils.trimToEmpty(rs.getString("name")));
			menu.setShortName(StringUtils.trimToEmpty(rs.getString("shortName")));
			menu.setLongName(StringUtils.trimToEmpty(rs.getString("longName")));
			menu.setDescription(StringUtils.trimToEmpty(rs.getString("description")));
			menu.setSpicy(rs.getBoolean("spicy"));
			menu.setRice(rs.getBoolean("rice"));
			menu.setSauce(rs.getBoolean("sauce"));
			menu.setNoodle(rs.getBoolean("noodle"));
			menu.setCombo(rs.getBoolean("combo"));
			menu.setLunch(rs.getBoolean("lunch"));
			menu.setPieces(rs.getInt("pieces"));
			menu.setSmall(rs.getDouble("small"));
			menu.setLarge(rs.getDouble("large"));
			menuList.add(menu);
		}
		
		return menuList;
	}

	@Override
	public List<Menu> getMenuByCategoryId(int id) {
		List<Menu> menuList = new ArrayList<Menu>();
		
		StringBuffer sb = new StringBuffer();
		sb.append("select s.id, c.name, s.shortName, s.longName, s.description, s.spicy, s.rice, s.sauce, ");
		sb.append("s.noodle, s.combo, s.lunch, s.pieces, p.small, p.large ");
		sb.append("from SubCategory s ");
		sb.append("inner join Category c on c.id=s.categoryId ");
		sb.append("inner join Price p on p.priceId=s.priceId ");
		
		LOGGER.info("From MenuDAOImpl - "+ sb + "where c.id="+id);
		
		sb.append("where c.id = ?");
		
		Object[] args = {id};
		
		SqlRowSet rs = this.getJdbcTemplate().queryForRowSet(sb.toString(), args);
		
		//TODO: may need to use StringUtils.trimToEmpty, BooleanUtils, etc
		while(rs.next()){
			Menu menu = new Menu();
			menu.setId(rs.getInt("id"));
			menu.setName(StringUtils.trimToEmpty(rs.getString("name")));
			menu.setShortName(StringUtils.trimToEmpty(rs.getString("shortName")));
			menu.setLongName(StringUtils.trimToEmpty(rs.getString("longName")));
			menu.setDescription(StringUtils.trimToEmpty(rs.getString("description")));
			menu.setSpicy(rs.getBoolean("spicy"));
			menu.setRice(rs.getBoolean("rice"));
			menu.setSauce(rs.getBoolean("sauce"));
			menu.setNoodle(rs.getBoolean("noodle"));
			menu.setCombo(rs.getBoolean("combo"));
			menu.setLunch(rs.getBoolean("lunch"));
			menu.setPieces(rs.getInt("pieces"));
			menu.setSmall(rs.getDouble("small"));
			menu.setLarge(rs.getDouble("large"));
			menuList.add(menu);
		}
		
		return menuList;
	}

}
