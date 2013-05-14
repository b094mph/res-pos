package com.res.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.OrderDetailDao;
import com.res.model.OrderDetail;
import com.res.service.OrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	private Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public void addOrder(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}

	@Override
	public List<OrderDetail> listOrder(long customerOrderId) {
		return orderDetailDao.listOrder(customerOrderId);
	}

}
