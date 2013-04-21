package com.res.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="food", catalog="restaurant")
public class Food implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="foodid")
	private long foodId;
	
	@Column(name="foodshortname", unique=true, nullable=false, length=30)
	private String foodShortName;
	
	@Column(name="foodlongname", unique=false, nullable=true, length=50)
	private String foodLongName;
	
	@Column(name="cfoodname", unique=false, nullable=true, length=10)
	private String cFoodName;
	
	@Column(name="description", unique=false, nullable=true, length=500)
	private String description;
	
	@Column(name="cdescription", unique=false, nullable=true, length=500)
	private String cDescription;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="food")
	@Cascade({CascadeType.SAVE_UPDATE})
	private Menu menu;

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getFoodShortName() {
		return foodShortName;
	}

	public void setFoodShortName(String foodShortName) {
		this.foodShortName = foodShortName;
	}

	public String getFoodLongName() {
		return foodLongName;
	}

	public void setFoodLongName(String foodLongName) {
		this.foodLongName = foodLongName;
	}

	public String getcFoodName() {
		return cFoodName;
	}

	public void setcFoodName(String cFoodName) {
		this.cFoodName = cFoodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
		
}
