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
	public List<Restaurant> getRestaurants() {
		Query query = getCurrentSession().getNamedQuery("restaurant");
		logger.info("@NamedQuery annotation: " + query.getQueryString());
		return query.list();
	}

}
