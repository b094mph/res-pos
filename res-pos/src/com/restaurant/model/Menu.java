package com.restaurant.model;

public class Menu {

	private int id;
	private String name;
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
	private double small;
	private double large;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public double getSmall() {
		return small;
	}
	public void setSmall(double small) {
		this.small = small;
	}
	public double getLarge() {
		return large;
	}
	public void setLarge(double large) {
		this.large = large;
	}
	
}
