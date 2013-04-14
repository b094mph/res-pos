package com.res.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="foodcategory", catalog="restaurant")
public class FoodCategory {

	private long foodCategoryId;
	private String foodCategoryName;
	private String foodCategoryCName;
	private List<Menu> menuCategoryList;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="foodcategoryid")
	public long getFoodCategoryId() {
		return foodCategoryId;
	}
	public void setFoodCategoryId(long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}
	
	@Column(name="foodcategoryname", unique=true, nullable=false, length=30)
	public String getFoodCategoryName() {
		return foodCategoryName;
	}
	public void setFoodCategoryName(String foodCategoryName) {
		this.foodCategoryName = foodCategoryName;
	}
	
	@Column(name="foodcategorycname", unique=false, nullable=true, length=10)
	public String getFoodCategoryCName() {
		return foodCategoryCName;
	}
	public void setFoodCategoryCName(String foodCategoryCName) {
		this.foodCategoryCName = foodCategoryCName;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="foodcategory")
	public List<Menu> getMenuCategoryList() {
		return menuCategoryList;
	}
	public void setMenuCategoryList(List<Menu> menuCategoryList) {
		this.menuCategoryList = menuCategoryList;
	}
	
}
