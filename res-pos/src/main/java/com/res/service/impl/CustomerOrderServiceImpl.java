package com.res.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.CustomerOrderDao;
import com.res.domain.CustomerOrder;
import com.res.domain.OrderDetail;
import com.res.service.CustomerOrderService;
import com.res.util.DateUtils;

@Service("customerOrderService")
public class CustomerOrderServiceImpl implements CustomerOrderService {
	
	private static Logger logger = Logger.getLogger(CustomerOrderServiceImpl.class);

	@Autowired
	private CustomerOrderDao customerOrderDao;
	
	@Override
	@Transactional
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderType, String requestDate) {
		return customerOrderDao.dailyTotalOrder(restaurantId, orderType, requestDate);
	}

	@Override
	public BigDecimal managementDailyTotal(List<CustomerOrder> orderList) {
		BigDecimal total = new BigDecimal(0);
		for(CustomerOrder order : orderList){
			total = total.add(order.getGrandTotal());
		}
		return total;
	}

	@Override
	@Transactional
	public List<CustomerOrder> searchByOrdersDesc(long restaurantId, String requestDate) {
		return customerOrderDao.searchByOrdersDesc(restaurantId, requestDate);
	}

	@Override
	@Transactional
	public List<OrderDetail> editOrderDetails(long restaurantId, String requestDate, int orderNum) {
		return customerOrderDao.searchOrderDetails(restaurantId, requestDate, orderNum); 
	}

	@Override
	@Transactional
	public Integer findLastOrderNumber(long restaurantId, String requestDate) {
		List<Integer> list = customerOrderDao.findLastOrderNumber(restaurantId, requestDate);
		
		if(list.isEmpty()){
			return 1; //order number starts at 1 at the beginning of the day
		}
		return list.get(0)+1;
	}

	@Override
	public boolean isExistingOrder(long restaurantId, String requestDate, int orderNum) {
		List<Integer> orderNumList = customerOrderDao.allOrderNumList(restaurantId, requestDate);
		
		boolean isExistingOrder = false;
		for(Integer num : orderNumList){
			if(num == orderNum){
				isExistingOrder = true;
				break;
			}
		}
		return isExistingOrder;
	}

	@Override
	public void saveOrUpdate(CustomerOrder customerOrder) {
		String requestDate = DateUtils.dateFormat(customerOrder.getOrderTime());
		Long customerOrderId = customerOrderDao.existingCustomerOrderId(customerOrder.getRestaurantId(), requestDate, customerOrder.getOrderNum());
		
		if(customerOrderId != null){
			if(logger.isDebugEnabled()){
				logger.debug("existing customer order, updating.");
			}
			customerOrder.setCustomerOrderId(customerOrderId);
			customerOrderDao.update(customerOrder);
		}else{
			
			customerOrderDao.save(customerOrder);
		}
		
	}

}
