package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.OrderDetailDao;
import com.res.domain.OrderDetail;

@Repository("orderDetailDao")
public class OrderDetailDaoImpl extends BaseDaoImpl implements OrderDetailDao {

	private static Logger logger = Logger.getLogger(OrderDetailDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> listOrder(long customerOrderId) {
		StringBuffer sb = new StringBuffer();
		sb.append("From OrderDetail od ");
		sb.append("WHERE od.customerOrderId = :customerOrderId");
		Query query = getCurrentSession().createQuery(sb.toString());
		logger.info(query.getQueryString());
		return query.list();
	}

}
