package com.res.dao.hibernate;

import java.util.List;

import com.res.model.Restaurant;

public interface RestaurantDao extends BaseDao {

	public Restaurant restaurantInfo(long restaurantId);
	public String findRestaurantName(long restaurantId);
	public List<Restaurant> getRestaurants();
}
