package com.res.dao.hibernate;

import java.util.List;

import com.res.domain.CustomerOrder;

public interface CustomerOrderDao extends BaseDao {
	
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderType, String requestDate);
	public List<CustomerOrder> searchByOrdersDesc(long restaurantId, String requestDate);
	public List<CustomerOrder> searchByOrderNum(long restaurantId, String requestDate, int orderNum);
	public List<Integer> findLastOrderNumber(long restaurantId, String requestDate);
}
