package com.res.dao.hibernate.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.MenuDao;
import com.res.model.FoodCategory;
import com.res.model.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {

	private static Logger logger = Logger.getLogger(MenuDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getFoodCategoryIdsFromMenu(long restaurantId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT distinct m.foodCategory.foodCategoryId FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		sb.append("ORDER BY m.foodCategory.foodCategoryId ASC");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId",restaurantId);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FoodCategory> getFoodCategoriesFromMenu(long restaurantId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT distinct m.foodCategory FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		sb.append("ORDER BY m.foodCategory.foodCategoryId ASC");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuByFoodCategory(long restaurantId, long foodCategoryId){
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId " +
				"AND m.foodCategory.foodCategoryId = :foodCategoryId");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		query.setParameter("foodCategoryId", foodCategoryId);
		
		logger.debug("FoodList size = " + query.list().size());
		return query.list();
	}

	@Override
	public Menu getMenuByMenuId(long menuId) {
		return (Menu) getCurrentSession().get(Menu.class, menuId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenu(long restaurantId) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		
		return query.list();
	}

	@Override
	public void updateMenuPrices(long menuId, BigDecimal small,
			BigDecimal large, BigDecimal lunch, BigDecimal combo) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE Menu ");
		sb.append("SET small = :small, large = :large, lunch = :lunch, combo = :combo ");
		sb.append("WHERE menuid = :menuid");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("small", small);
		query.setParameter("large", large);
		query.setParameter("lunch", lunch);
		query.setParameter("combo", combo);
		query.setParameter("menuid", menuId);
		
		int rowsAffected = query.executeUpdate();
		logger.info("rows updated = " + rowsAffected);
	}
	
}
