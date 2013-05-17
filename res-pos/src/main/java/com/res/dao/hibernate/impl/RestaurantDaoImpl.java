package com.res.dao.hibernate.impl;

import org.apache.log4j.Logger;
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

}
