package com.res.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="food", catalog="restaurant")
public class Food {

	private long foodId;
	private String foodShortName;
	private String foodLongName;
	private String cFoodName;
	private String description;
	private String cDescription;

	private Menu menu;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="foodid")
	public long getFoodId() {
		return foodId;
	}
	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}
	
	@Column(name="foodshortname", unique=true, nullable=false, length=30)
	public String getFoodShortName() {
		return foodShortName;
	}
	public void setFoodShortName(String foodShortName) {
		this.foodShortName = foodShortName;
	}
	
	@Column(name="foodlongname", unique=false, nullable=true, length=50)
	public String getFoodLongName() {
		return foodLongName;
	}
	public void setFoodLongName(String foodLongName) {
		this.foodLongName = foodLongName;
	}
	
	@Column(name="cfoodname", unique=false, nullable=true, length=10)
	public String getcFoodName() {
		return cFoodName;
	}
	public void setcFoodName(String cFoodName) {
		this.cFoodName = cFoodName;
	}
	
	@Column(name="description", unique=false, nullable=true, length=500)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="cdescription", unique=false, nullable=true, length=500)
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="food", cascade= CascadeType.ALL)
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
