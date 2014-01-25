package com.res.dao.hibernate;

import java.util.List;

import com.res.domain.CustomerOrder;

public interface CustomerOrderDao extends BaseDao {
	
	/**
	 * 
	 * @param restaurantId
	 * @param orderType
	 * @param requestDate - yyyy-MM-dd
	 * @return
	 */
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderType, String requestDate);

}
