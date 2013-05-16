package com.res.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="orderdetail", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="customerorderid"),
		@UniqueConstraint(columnNames="menuid")
})
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderdetailid")
	private long orderDetailId;
	
	@Column(name="customerorderid", unique=false, nullable=false, length=11)
	private long customerOrderId;
	
	@Column(name="menuid", unique=false, nullable=false, length=11,
			insertable=false, updatable=false)
	private long menuId;
	
	@Column(name="quantity", unique=false, nullable=false, length=2)
	private int quantity;
	
	@Column(name="size", unique=false, nullable=false, length=5)
	private String size;
	
	@Column(name="price", unique=false, nullable=false, length=5)
	private BigDecimal price;
	
	@Column(name="note", unique=false, nullable=true, length=200)
	private String note;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="menuid", nullable=false)
	private Menu menu;

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public long getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
		
}
