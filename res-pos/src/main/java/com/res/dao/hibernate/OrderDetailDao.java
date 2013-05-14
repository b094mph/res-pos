package com.res.dao.hibernate;

import java.util.List;

import com.res.model.OrderDetail;

public interface OrderDetailDao extends BaseDao {

	List<OrderDetail> listOrder(long customerOrderId);

}
