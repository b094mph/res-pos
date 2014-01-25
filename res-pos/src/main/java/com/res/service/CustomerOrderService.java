package com.res.service;

import java.math.BigDecimal;
import java.util.List;

import com.res.domain.CustomerOrder;

public interface CustomerOrderService {

	/**
	 * 
	 * @param restaurantId
	 * @param orderType
	 * @param requestDate - yyyy-MM-dd
	 * @return
	 */
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderType, String requestDate);
	public BigDecimal managementDailyTotal(List<CustomerOrder> orderList);
}
