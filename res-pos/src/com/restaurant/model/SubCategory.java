package com.restaurant.model;

public class SubCategory {

	private int id;
	private int categoryId;
	private String shortName;
	private String longName;
	private String description;
	private boolean spicy;
	private boolean rice;
	private boolean sauce;
	private boolean noodle;
	private boolean combo;
	private boolean lunch;
	private int pieces;
	private Price price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isSpicy() {
		return spicy;
	}
	public void setSpicy(boolean spicy) {
		this.spicy = spicy;
	}
	public boolean isRice() {
		return rice;
	}
	public void setRice(boolean rice) {
		this.rice = rice;
	}
	public boolean isSauce() {
		return sauce;
	}
	public void setSauce(boolean sauce) {
		this.sauce = sauce;
	}
	public boolean isNoodle() {
		return noodle;
	}
	public void setNoodle(boolean noodle) {
		this.noodle = noodle;
	}
	public boolean isCombo() {
		return combo;
	}
	public void setCombo(boolean combo) {
		this.combo = combo;
	}
	public boolean isLunch() {
		return lunch;
	}
	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	
}
