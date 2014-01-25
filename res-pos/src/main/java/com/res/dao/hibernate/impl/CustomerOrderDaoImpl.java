package com.res.dao.hibernate.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.CustomerOrderDao;
import com.res.domain.CustomerOrder;
import com.res.util.DateUtils;

@Repository("customerOrderDao")
public class CustomerOrderDaoImpl extends BaseDaoImpl implements CustomerOrderDao {

	public static Logger logger = Logger.getLogger(CustomerOrderDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerOrder> dailyTotalOrder(long restaurantId, String orderOption, String requestDate) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("FROM CustomerOrder co ");
		sb.append("WHERE (co.orderTime BETWEEN :startOfHour ");
		sb.append("AND :endOfHour) ");
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
	
}
