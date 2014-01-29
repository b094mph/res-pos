package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.CustomerOrderDao;
import com.res.domain.CustomerOrder;
import com.res.domain.OrderDetail;
import com.res.util.DateUtils;

@Repository("customerOrderDao")
public class CustomerOrderDaoImpl extends BaseDaoImpl implements CustomerOrderDao {

	public static Logger logger = Logger.getLogger(CustomerOrderDaoImpl.class);

	/**
	 * 
	 * @param restaurantId
	 * @param orderOption
	 * @param requestDate - yyyy-MM-dd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderOption, String requestDate) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("FROM CustomerOrder co ");
		sb.append("WHERE (co.orderTime BETWEEN :startOfHour AND :endOfHour) ");
		sb.append("AND co.restaurantId = :restaurantId ");
		
		if(StringUtils.isNotBlank(orderOption)){
			sb.append("AND co.orderOption = :orderOption");
		}
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		
		if(StringUtils.isNotBlank(orderOption)){
			query.setString("orderOption", orderOption);
		}
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> searchByOrdersDesc(long restaurantId, String requestDate) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM CustomerOrder co ");
		sb.append("WHERE (co.orderTime BETWEEN :startOfHour AND :endOfHour) ");
		sb.append("AND co.restaurantId = :restaurantId ");
		sb.append("ORDER BY co.orderNum DESC");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> searchCustomerOrderDetails(long restaurantId, String requestDate, int orderNum) {
		StringBuffer sb = new StringBuffer();
		sb.append("FROM CustomerOrder co ");
		sb.append("WHERE (co.orderTime BETWEEN :startOfHour AND :endOfHour) ");
		sb.append("AND co.restaurantId = :restaurantId ");
		sb.append("WHERE co.orderNum = :orderNum");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		query.setInteger("orderNum", orderNum);
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> searchOrderDetails(long restaurantId, String requestDate, int orderNum) {
		StringBuffer sb = new StringBuffer()
			.append("FROM OrderDetail od ")
			.append("WHERE (od.customerOrder.orderTime BETWEEN :startOfHour AND :endOfHour) ")
			.append("AND od.customerOrder.restaurantId = :restaurantId ")
			.append("AND od.customerOrder.orderNum = :orderNum");
	
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		query.setInteger("orderNum", orderNum);

		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> findLastOrderNumber(long restaurantId, String requestDate) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT co.orderNum ");
		sb.append("FROM CustomerOrder co "); 
		sb.append("WHERE (co.orderTime BETWEEN :startOfHour AND :endOfHour) ");
		sb.append("AND co.restaurantId = :restaurantId ");
		sb.append("ORDER BY co.orderNum DESC ");
		sb.append("LIMIT 1 ");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> allOrderNumList(long restaurantId, String requestDate){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT co.orderNum ");
		sb.append("FROM CustomerOrder co "); 
		sb.append("WHERE (co.orderTime BETWEEN :startOfHour AND :endOfHour) ");
		sb.append("AND co.restaurantId = :restaurantId ");
		sb.append("ORDER BY co.orderNum DESC ");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		
		return query.list();
	}

	@Override
	public Long existingCustomerOrderId(long restaurantId, String requestDate, int orderNum) {
		StringBuffer sb = new StringBuffer()
			.append("SELECT co.customerOrderId ")
			.append("FROM CustomerOrder co ")
			.append("WHERE (co.orderTime BETWEEN :startOfHour AND :endOfHour) ")
			.append("AND co.restaurantId = :restaurantId ")
			.append("AND co.orderNum = :orderNum ");
		
		Query query = getCurrentSession().createQuery(sb.toString());
		query.setLong("restaurantId", restaurantId);
		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
		query.setInteger("orderNum", orderNum);
		
		if(query.list().isEmpty()){
			return null;
		}
		
		return (Long) query.list().get(0);
	}
	
}
