package com.res.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="menu", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="restaurantid"),
		@UniqueConstraint(columnNames="foodcategoryid"),
		@UniqueConstraint(columnNames="foodid")
})
public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menuid")
	private long menuId;
	
	@Column(name="restaurantid", unique=false, nullable=false, length=11)
	private long restaurantId;
	
	@Column(name="foodcategoryid", unique=false, nullable=false, length=11, 
			updatable=false, insertable=false)
	private long foodCategoryId;
	
	@Column(name="foodid", unique=false, nullable=false, length=11)
	private long foodId;
	
	@Column(name="menunum", unique=false, nullable=true, length=5)
	private String menuNum;
	
	@Column(name="small", unique=false, nullable=true, length=5)
	private Float small;
	
	@Column(name="large", unique=false, nullable=false, length=5)
	private Float large;
	
	@Column(name="lunchnum", unique=false, nullable=true, length=5)
	private String lunchNum;
	
	@Column(name="lunch", unique=false, nullable=true, length=5)
	private Float lunch;
	
	@Column(name="combonum", unique=false, nullable=true, length=5)
	private String comboNum;
	
	@Column(name="combo", unique=false, nullable=true, length=5)
	private Float combo;
	
	@Column(name="spicy", unique=false, nullable=true, length=1)
	private Boolean spicy;
	
	@Column(name="rice", unique=false, nullable=true, length=1)
	private Boolean rice;
	
	@Column(name="sauce", unique=false, nullable=true, length=1)
	private Boolean sauce;
	
	@Column(name="noodle", unique=false, nullable=true, length=1)
	private Boolean noodle;
	
	@Column(name="pieces", unique=false, nullable=true, length=2)
	private Integer pieces;
	
	@Column(name="appetizercombo", unique=false, nullable=true, length=1)
	private Boolean appetizerCombo;
	
	@Column(name="createddate", unique=false, nullable=true, length=12)
	private Time createdDate;
	
	@Column(name="createdby", unique=false, nullable=true, length=20)
	private String createdBy;
	
	@Column(name="lastupdateddate", unique=false, nullable=true, length=12)
	private Time lastUpdatedDate;
	
	@Column(name="lastupdatedby", unique=false, nullable=true, length=12)
	private String lastUpdatedBy;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="foodcategoryid", nullable=false)
	private FoodCategory foodCategory;
	
	@OneToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Food food;

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getFoodCategoryId() {
		return foodCategoryId;
	}

	public void setFoodCategoryId(long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public String getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}

	public Float getSmall() {
		return small;
	}

	public void setSmall(Float small) {
		this.small = small;
	}

	public Float getLarge() {
		return large;
	}

	public void setLarge(Float large) {
		this.large = large;
	}

	public String getLunchNum() {
		return lunchNum;
	}

	public void setLunchNum(String lunchNum) {
		this.lunchNum = lunchNum;
	}

	public Float getLunch() {
		return lunch;
	}

	public void setLunch(Float lunch) {
		this.lunch = lunch;
	}

	public String getComboNum() {
		return comboNum;
	}

	public void setComboNum(String comboNum) {
		this.comboNum = comboNum;
	}

	public Float getCombo() {
		return combo;
	}

	public void setCombo(Float combo) {
		this.combo = combo;
	}

	public Boolean getSpicy() {
		return spicy;
	}

	public void setSpicy(Boolean spicy) {
		this.spicy = spicy;
	}

	public Boolean getRice() {
		return rice;
	}

	public void setRice(Boolean rice) {
		this.rice = rice;
	}

	public Boolean getSauce() {
		return sauce;
	}

	public void setSauce(Boolean sauce) {
		this.sauce = sauce;
	}

	public Boolean getNoodle() {
		return noodle;
	}

	public void setNoodle(Boolean noodle) {
		this.noodle = noodle;
	}

	public Integer getPieces() {
		return pieces;
	}

	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}

	public Boolean getAppetizerCombo() {
		return appetizerCombo;
	}

	public void setAppetizerCombo(Boolean appetizerCombo) {
		this.appetizerCombo = appetizerCombo;
	}

	public Time getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Time createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Time getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Time lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
}
