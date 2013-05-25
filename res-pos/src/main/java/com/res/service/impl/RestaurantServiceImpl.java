package com.res.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.RestaurantDao;
import com.res.model.Restaurant;
import com.res.service.RestaurantService;

@Service("restaurantService")
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

	private static Logger logger = Logger.getLogger(RestaurantServiceImpl.class);
	
	@Autowired private RestaurantDao restaurantDao;
	
	@Override
	public Restaurant getResturantInfo(long restaurantId) {
		return restaurantDao.restaurantInfo(restaurantId);
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return restaurantDao.getRestaurants();
	}

	@Override
	public String findRestaurantName(long restaurantId) {
		return restaurantDao.findRestaurantName(restaurantId);
	}

}
