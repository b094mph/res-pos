package com.res.dao.hibernate;

import java.util.List;

import com.res.domain.OrderDetail;

public interface OrderDetailDao extends BaseDao {

	List<OrderDetail> listOrder(long customerOrderId);

}
