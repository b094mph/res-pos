package com.res.dao.hibernate.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.res.dao.hibernate.CustomerOrderDao;
import com.res.domain.CustomerOrder;
import com.res.domain.Menu;
import com.res.domain.OrderDetail;
import com.res.domain.Person;
import com.res.util.DateUtils;
import com.res.util.Price;

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
//		StringBuffer sb = new StringBuffer()
//			.append("FROM OrderDetail od ")
//			.append("INNER JOIN od.customerOrder co ")
//			.append("WHERE co.customerOrderId=od.customerOrder.customerOrderId ")
//			.append("AND (co.orderTime BETWEEN :startOfHour AND :endOfHour) ")
//			.append("AND co.restaurantId = :restaurantId ")
//			.append("AND co.orderNum = :orderNum");
//		
//		Query query = getCurrentSession().createQuery(sb.toString());
//		query.setLong("restaurantId", restaurantId);
//		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
//		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
//		query.setInteger("orderNum", orderNum);
//		
//		return query.list();
		
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		CustomerOrder co = new CustomerOrder();
		co.setCustomerOrderId(25);
		Person customer = new Person();
		customer.setFirstName("Bobby");
		co.setCustomer(customer);
		co.setGrandTotal(new BigDecimal(2));
		Menu menu = new Menu();
		menu.setMenuId(1);
		OrderDetail od = new OrderDetail();
		od.setOrderDetailId(79);
		od.setCustomerOrder(co);
		od.setMenu(menu);
		od.setQuantity(1);
		od.setSize("Lg");
		od.setPrice(Price.roundToNearestNickel(new BigDecimal(2)));
		
		list.add(od);
		return list;
		
//		StringBuffer sb = new StringBuffer()
//			.append("select t1.* from customerorder t0 ")
//			.append("inner join orderdetail t1 on t0.customerorderid=t1.customerorderid ")
//			.append("where (t0.ordertime between :startOfHour and :endOfHour) ")
//			.append("and t0.restaurantid= :restaurantId ")
//			.append("and t0.ordernum= :orderNum ");
//		
//		Query query = getCurrentSession().createSQLQuery(sb.toString());
//		query.setLong("restaurantId", restaurantId);
//		query.setString("startOfHour", DateUtils.addStartOfHour(requestDate));
//		query.setString("endOfHour", DateUtils.addEndOfHour(requestDate));
//		query.setInteger("orderNum", orderNum);
//		
//		return query.list();

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
	
}
