package com.res.service;

import java.math.BigDecimal;
import java.util.List;

import com.res.domain.CustomerOrder;
import com.res.domain.OrderDetail;

public interface OrderService {

	public void addOrder(OrderDetail orderDetail);
	public List<OrderDetail> listOrder(long customerOrderId);
	public void saveOrder(CustomerOrder customerOrder, List<OrderDetail> orderList);
	public BigDecimal calculatePrice(OrderDetail orderDetail);
	public BigDecimal computeSalesTax(BigDecimal decimalTax);
	public BigDecimal computeSubtotal(List<OrderDetail> orderList);
	public BigDecimal roundTotal(BigDecimal total);
	public BigDecimal computeTotalTax(BigDecimal subTotal, BigDecimal tax);
	public BigDecimal computeGrandTotal(BigDecimal subTotal, BigDecimal calcTax);
}
