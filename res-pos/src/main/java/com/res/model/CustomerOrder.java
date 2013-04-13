package com.res.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="customerorder", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="restaurantid"),
		@UniqueConstraint(columnNames="agentid"),
		@UniqueConstraint(columnNames="personid"),
		@UniqueConstraint(columnNames="creditcardid")
})
public class CustomerOrder {

	private long customerOrderId;
	private long restaurantId;
	private long agentId;
	private long personId;
	private long creditCardId;
	private String orderOption;
	private Date orderTime;
	private float subTotal;
	private float tax;
	private float grandTotal;
	private float tip;
	private String orderStatus;
	private String note;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerorderid")
	public long getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	
	@Column(name="restaurantid", unique=false, nullable=false, length=11)
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	@Column(name="agentid", unique=false, nullable=false, length=11)
	public long getAgentId() {
		return agentId;
	}
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}
	
	@Column(name="personid", unique=false, nullable=false, length=11)
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	@Column(name="creditcardid", unique=false, nullable=true, length=11)
	public long getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}
	
	@Column(name="orderoption", unique=false, nullable=false, length=11)
	public String getOrderOption() {
		return orderOption;
	}
	public void setOrderOption(String orderOption) {
		this.orderOption = orderOption;
	}
	
	@Column(name="ordertime", unique=true, nullable=false, length=11)
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	
	@Column(name="subtotal", unique=false, nullable=false, length=5)
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	@Column(name="tax", unique=false, nullable=true, length=5)
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	
	@Column(name="grandtotal", unique=false, nullable=false, length=5)
	public float getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	@Column(name="tip", unique=false, nullable=true, length=5)
	public float getTip() {
		return tip;
	}
	public void setTip(float tip) {
		this.tip = tip;
	}
	
	@Column(name="orderstatus", unique=false, nullable=false, length=10)
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Column(name="note", unique=false, nullable=true, length=200)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
