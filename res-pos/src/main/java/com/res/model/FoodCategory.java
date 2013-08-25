package com.res.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="getFoodCategoriesFromMenu",
			query="CALL getFoodCategoriesFromMenu(:restaurantId);",
			resultClass= FoodCategory.class),
	@NamedNativeQuery(name="getExtrasCategoryFromMenu",
			query="CALL getExtrasCategoryFromMenu(:restaurantId);",
			resultClass= FoodCategory.class),
})
@Table(name="foodcategory", catalog="restaurant")
public class FoodCategory implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="foodcategoryid")
	private long foodCategoryId;
	
	@Column(name="foodcategoryname", unique=true, nullable=false, length=30)
	private String foodCategoryName;
	
	@Column(name="foodcategorycname", unique=false, nullable=true, length=10)
	private String foodCategoryCName;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="foodCategory")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Menu> menu;

	public long getFoodCategoryId() {
		return foodCategoryId;
	}

	public void setFoodCategoryId(long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}

	public String getFoodCategoryName() {
		return foodCategoryName;
	}

	public void setFoodCategoryName(String foodCategoryName) {
		this.foodCategoryName = foodCategoryName;
	}

	public String getFoodCategoryCName() {
		return foodCategoryCName;
	}

	public void setFoodCategoryCName(String foodCategoryCName) {
		this.foodCategoryCName = foodCategoryCName;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
		
}
