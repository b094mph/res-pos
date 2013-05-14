package com.res.dao.hibernate.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.OrderDetailDao;
import com.res.model.OrderDetail;

@Repository("orderDetailDao")
public class OrderDetailDaoImpl extends BaseDaoImpl implements OrderDetailDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> listOrder(long customerOrderId) {
		StringBuffer sb = new StringBuffer();
		sb.append("From OrderDetail od ");
		sb.append("WHERE od.customerOrderId = :customerOrderId");
		Query query = getCurrentSession().createQuery(sb.toString());
		
		return query.list();
	}


}
