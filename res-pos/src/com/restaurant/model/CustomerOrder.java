package com.restaurant.model;

public class CustomerOrder {

	private String id;
	private int subCategoryId;
	private int orderAmount;
	private String item;
	private double price;
	private double totalOfOrder;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public int getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalOfOrder() {
		return totalOfOrder;
	}
	public void setTotalOfOrder(double totalOfOrder) {
		this.totalOfOrder = totalOfOrder;
	}
	
}
