package com.res.dao.hibernate.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
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
	public void updateMenu(long menuId, String menuNum, BigDecimal small,
			BigDecimal large, String lunchNum, BigDecimal lunch,
			String comboNum, BigDecimal combo, Boolean isSpicy,
			Boolean hasRice, Boolean hasSauce, Boolean hasNoodles,
			Integer numPieces, Boolean isAppetizerCombo, String lastUpdatedBy) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE Menu ");
		sb.append("SET menuNum = :menuNum, small = :small, large = :large, ");
		sb.append("lunchNum = :lunchNum, lunch = :lunch, comboNum = :comboNum, combo = :combo, ");
		sb.append("spicy = :spicy, rice = :rice, sauce = :sauce, noodle = :noodles, pieces = :pieces, appetizerCombo = :appetizerCombo, ");
		sb.append("lastUpdatedBy = :lastUpdatedBy, lastUpdatedDate = :lastUpdatedDate ");
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
		
		Timestamp timestamp = new Timestamp(new Date().getTime());
		
//		try {
//			query.setParameter("lastUpdatedDate", new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(timestamp.toString()));
//		} catch (HibernateException | ParseException e) {
//			e.printStackTrace();
//		}
		query.setParameter("menuid", menuId);
		
		int rowsAffected = query.executeUpdate();
		logger.info("rows updated = " + rowsAffected);
		
	}
	
}
