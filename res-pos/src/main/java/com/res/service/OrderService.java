package com.res.service;

import java.util.List;

import com.res.model.CustomerOrder;
import com.res.model.OrderDetail;

public interface OrderService {

	public void addOrder(OrderDetail orderDetail);
	public List<OrderDetail> listOrder(long customerOrderId);
	public void saveOrder(CustomerOrder customerOrder, List<OrderDetail> orderList);
	
}
