package com.res.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="orderdetail", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="customerorderid"),
		@UniqueConstraint(columnNames="menuid")
})
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	private long orderDetailId;
	private long customerOrderId;
	private long menuId;
	private int quantity;
	private String note;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderdetailid")
	public long getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	
	@Column(name="customerorderid", unique=false, nullable=false, length=11)
	public long getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	
	@Column(name="menuid", unique=false, nullable=false, length=11)
	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	
	@Column(name="quantity", unique=false, nullable=false, length=2)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Column(name="note", unique=false, nullable=true, length=200)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
