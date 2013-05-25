package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.RestaurantDao;
import com.res.model.Restaurant;

@Repository("restaurantDao")
public class RestaurantDaoImpl extends BaseDaoImpl implements RestaurantDao {

	private static Logger logger = Logger.getLogger(RestaurantDaoImpl.class);
	
	@Override
	public Restaurant restaurantInfo(long restaurantId) {
		return (Restaurant) getCurrentSession().get(Restaurant.class, restaurantId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String findRestaurantName(long restaurantId) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT restaurantName FROM Restaurant WHERE restaurantId = :restaurantId");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		
		List<String> resName = query.list();
		if(!resName.isEmpty()){
			return resName.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getRestaurants() {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM Restaurant");
		
		logger.info(sb.toString());
		Query query = getCurrentSession().createQuery(sb.toString());
		
		return query.list();
	}

}
