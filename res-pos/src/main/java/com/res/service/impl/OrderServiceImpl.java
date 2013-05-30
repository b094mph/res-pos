package com.res.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.constant.ResConstant;
import com.res.dao.hibernate.CustomerOrderDao;
import com.res.dao.hibernate.OrderDetailDao;
import com.res.model.CustomerOrder;
import com.res.model.Menu;
import com.res.model.OrderDetail;
import com.res.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	private Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	@Autowired private OrderDetailDao orderDetailDao;
	@Autowired private CustomerOrderDao customerOrderDao;
	
	@Override
	@Transactional
	public void addOrder(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}

	@Override
	@Transactional
	public List<OrderDetail> listOrder(long customerOrderId) {
		return orderDetailDao.listOrder(customerOrderId);
	}

	@Override
	@Transactional
	public void saveOrder(CustomerOrder customerOrder, List<OrderDetail> orderList) {
		logger.info("Saving customer order.");
		customerOrderDao.save(customerOrder);
		for(OrderDetail orderDetail : orderList){
			orderDetailDao.save(orderDetail);
		}
	}

	@Override
	public BigDecimal calculatePrice(OrderDetail orderDetail) {
		BigDecimal price = null;
		String size = orderDetail.getSize();
		Menu menu = orderDetail.getMenu();
		
		if(ResConstant.LARGE.equals(size)){
			price = menu.getLarge().multiply(new BigDecimal(orderDetail.getQuantity()));
		}else if(ResConstant.SMALL.equals(size)){
			price = menu.getSmall().multiply(new BigDecimal(orderDetail.getQuantity()));
		}else if(ResConstant.COMBO.equals(size)){
			price = menu.getCombo().multiply(new BigDecimal(orderDetail.getQuantity()));
		}else if(ResConstant.LUNCH.equals(size)){
			price = menu.getLunch().multiply(new BigDecimal(orderDetail.getQuantity()));
		}
		
		return price.setScale(ResConstant.SCALE);
	}
}
