package com.res.model;

import java.io.Serializable;
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
public class CustomerOrder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerorderid")
	private long customerOrderId;
	
	@Column(name="restaurantid", unique=false, nullable=false, length=11)
	private long restaurantId;
	
	@Column(name="agentid", unique=false, nullable=false, length=11)
	private long agentId;
	
	@Column(name="personid", unique=false, nullable=false, length=11)
	private long personId;
	
	@Column(name="creditcardid", unique=false, nullable=true, length=11)
	private long creditCardId;
	
	@Column(name="orderoption", unique=false, nullable=false, length=11)
	private String orderOption;
	
	@Column(name="ordertime", unique=true, nullable=false, length=11)
	private Date orderTime;
	
	@Column(name="subtotal", unique=false, nullable=false, length=5)
	private float subTotal;
	
	@Column(name="tax", unique=false, nullable=true, length=5)
	private float tax;
	
	@Column(name="grandtotal", unique=false, nullable=false, length=5)
	private float grandTotal;
	
	@Column(name="tip", unique=false, nullable=true, length=5)
	private float tip;
	
	@Column(name="orderstatus", unique=false, nullable=false, length=10)
	private String orderStatus;
	
	@Column(name="note", unique=false, nullable=true, length=200)
	private String note;

	public long getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public String getOrderOption() {
		return orderOption;
	}

	public void setOrderOption(String orderOption) {
		this.orderOption = orderOption;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public float getTip() {
		return tip;
	}

	public void setTip(float tip) {
		this.tip = tip;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
