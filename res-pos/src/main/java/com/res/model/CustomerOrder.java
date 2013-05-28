package com.res.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="customerorder", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="restaurantid"),
		@UniqueConstraint(columnNames="username"),
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
	
	@Column(name="username", unique=false, nullable=false, length=11)
	private String username;
	
	@Column(name="creditcardid", unique=false, nullable=true, length=11)
	private Long creditCardId;
	
	@Column(name="orderoption", unique=false, nullable=false, length=11)
	private String orderOption;
	
	@Column(name="ordertime", unique=true, nullable=false, length=11)
	private Date orderTime;
	
	@Column(name="subtotal", unique=false, nullable=false, length=5)
	private BigDecimal subTotal;
	
	@Column(name="tax", unique=false, nullable=true, length=5)
	private BigDecimal tax;
	
	@Column(name="grandtotal", unique=false, nullable=false, length=5)
	private BigDecimal grandTotal;
	
	@Column(name="tip", unique=false, nullable=true, length=5)
	private BigDecimal tip;
	
	@Column(name="orderstatus", nullable=false, length=10)
	private String orderStatus;
	
	@Column(name="note", unique=false, nullable=true, length=200)
	private String note;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="personid")
	private Person customer;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(Long creditCardId) {
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

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	public BigDecimal getTip() {
		return tip;
	}

	public void setTip(BigDecimal tip) {
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

	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

}
