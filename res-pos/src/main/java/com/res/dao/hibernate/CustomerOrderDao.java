package com.res.dao.hibernate;

import java.util.List;

import com.res.domain.CustomerOrder;
import com.res.domain.OrderDetail;

public interface CustomerOrderDao extends BaseDao {
	
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderType, String requestDate);
	public List<CustomerOrder> searchByOrdersDesc(long restaurantId, String requestDate);
	public List<CustomerOrder> searchCustomerOrderDetails(long restaurantId, String requestDate, int orderNum);
	public List<OrderDetail> searchOrderDetails(long restaurantId, String requestDate, int orderNum);
	public List<Integer> findLastOrderNumber(long restaurantId, String requestDate);
	public List<Integer> allOrderNumList(long restaurantId, String requestDate);
}
