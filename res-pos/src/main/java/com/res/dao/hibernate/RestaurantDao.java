package com.res.dao.hibernate;

import com.res.model.Restaurant;

public interface RestaurantDao extends BaseDao {

	public Restaurant restaurantInfo(long restaurantId); 
}
