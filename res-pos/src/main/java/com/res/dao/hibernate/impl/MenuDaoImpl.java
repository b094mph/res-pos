package com.res.dao.hibernate.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.MenuDao;
import com.res.model.FoodCategory;
import com.res.model.Menu;
import com.res.model.ModifyTaste;
import com.res.util.MessageLoader;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {

	private static Logger logger = Logger.getLogger(MenuDaoImpl.class);
	
	@Autowired private MessageLoader messageLoader;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getFoodCategoryIdsFromMenu(long restaurantId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT m.foodCategory.foodCategoryId FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		sb.append("AND m.foodCategory.foodCategoryName NOT LIKE 'Extra%' ");
		sb.append("ORDER BY m.foodCategory.foodCategoryId ASC");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId",restaurantId);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FoodCategory> getFoodCategoriesFromMenu(long restaurantId){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT m.foodCategory FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		sb.append("AND m.foodCategory.foodCategoryName NOT LIKE 'Extra%' ");
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
	public void updateMenu(long menuId, String menuNum, BigDecimal small,
			BigDecimal large, String lunchNum, BigDecimal lunch,
			String comboNum, BigDecimal combo, Boolean isSpicy,
			Boolean hasRice, Boolean hasSauce, Boolean hasNoodles,
			Integer numPieces, Boolean isAppetizerCombo, String lastUpdatedBy) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE Menu SET ");
		sb.append("menuNum = :menuNum, ");
		sb.append("small = :small, ");
		sb.append("large = :large, ");
		sb.append("lunchNum = :lunchNum, ");
		sb.append("lunch = :lunch, ");
		sb.append("comboNum = :comboNum, ");
		sb.append("combo = :combo, ");
		sb.append("spicy = :spicy, ");
		sb.append("rice = :rice, ");
		sb.append("sauce = :sauce, ");
		sb.append("noodle = :noodles, ");
		sb.append("pieces = :pieces, ");
		sb.append("appetizerCombo = :appetizerCombo, ");
		sb.append("lastUpdatedBy = :lastUpdatedBy, ");
		sb.append("lastUpdatedDate = :lastUpdatedDate ");
		sb.append("WHERE menuid = :menuid");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("menuNum", menuNum);
		query.setParameter("small", small);
		query.setParameter("large", large);
		query.setParameter("lunchNum", lunchNum);
		query.setParameter("lunch", lunch);
		query.setParameter("comboNum", comboNum);
		query.setParameter("combo", combo);
		query.setParameter("spicy", isSpicy);
		query.setParameter("rice", hasRice);
		query.setParameter("sauce", hasSauce);
		query.setParameter("noodles", hasNoodles);
		query.setParameter("pieces", numPieces);
		query.setParameter("appetizerCombo", isAppetizerCombo);
		query.setParameter("lastUpdatedBy", lastUpdatedBy);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			query.setParameter("lastUpdatedDate", df.parse(df.format(new Date())));
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (ParseException pe){
			logger.error(messageLoader.getMessage("parse.exception.date"));
			pe.printStackTrace();
		}
		query.setParameter("menuid", menuId);
		
		int rowsAffected = query.executeUpdate();
		logger.info("rows updated = " + rowsAffected);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getSubcategories(long restaurantId, String size) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Menu m ");
		sb.append("WHERE ");
		sb.append("m.restaurantId = :restaurantId ");
		sb.append("AND ");
		sb.append("m.").append(size);
		sb.append(" != 0.00");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FoodCategory> getExtrasCategoryFromMenu(long restaurantId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT m.foodCategory FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		sb.append("AND m.foodCategory.foodCategoryName LIKE 'Extra%' ");
		sb.append("ORDER BY m.foodCategory.foodCategoryId ASC");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getMenuByExtrasCategory(long restaurantId, long foodCategoryId) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Menu m ");
		sb.append("WHERE m.restaurantId = :restaurantId ");
		sb.append("AND m.foodCategory.foodCategoryId = :foodCategoryId ");
		sb.append("AND m.foodCategory.foodCategoryName LIKE 'Extra%'");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		query.setParameter("foodCategoryId", foodCategoryId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ModifyTaste> getModifiers(long restaurantId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT m.modifyTaste FROM RestaurantModifyTaste m ");
		sb.append("WHERE m.restaurant.restaurantId = :restaurantId");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setParameter("restaurantId", restaurantId);
		
		return query.list();
	}
	
}
