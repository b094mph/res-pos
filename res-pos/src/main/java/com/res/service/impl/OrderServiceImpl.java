package com.res.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.constant.ResConstant;
import com.res.dao.hibernate.CustomerOrderDao;
import com.res.dao.hibernate.OrderDetailDao;
import com.res.domain.CustomerOrder;
import com.res.domain.Menu;
import com.res.domain.OrderDetail;
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
		if(size == null){
			size = ResConstant.LARGE;
		}
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

	/**
	 * Example tax of 8% computes to 8.00
	 */
	@Override
	public BigDecimal computeSalesTax(BigDecimal tax) {
		logger.info("tax = " + tax);
		return tax.multiply(new BigDecimal(100));
	}
	
	@Override
	public BigDecimal computeSubtotal(List<OrderDetail> orderList) {
		BigDecimal subTotal = BigDecimal.ZERO;
		for(OrderDetail orderDetail : orderList){
			subTotal = subTotal.add(orderDetail.getPrice());
		}
		return subTotal;
	}

	@Override
	public BigDecimal roundTotal(BigDecimal total) {
		return total.setScale(ResConstant.SCALE, RoundingMode.HALF_UP);
	}
	
	/**
	 * computes the total tax for based on the subtotal
	 */
	@Override
	public BigDecimal computeTotalTax(BigDecimal subTotal, BigDecimal tax) {
		return subTotal.multiply(tax).setScale(ResConstant.SCALE, RoundingMode.HALF_UP);
	}

	@Override
	public BigDecimal computeGrandTotal(BigDecimal subTotal, BigDecimal calcTax) {
		return subTotal.add(calcTax);
	}

}
