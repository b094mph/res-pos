package com.res.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurantmodifytaste")
public class RestaurantModifyTaste implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restaurantmodifytasteid")
	private long restaurantModifyTasteId;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="restaurantid", nullable=false)
	private Restaurant restaurant;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="modifytasteid", nullable=false)
	private ModifyTaste modifyTaste;

	public long getRestaurantModifyTasteId() {
		return restaurantModifyTasteId;
	}

	public void setRestaurantModifyTasteId(long restaurantModifyTasteId) {
		this.restaurantModifyTasteId = restaurantModifyTasteId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public ModifyTaste getModifyTaste() {
		return modifyTaste;
	}

	public void setModifyTaste(ModifyTaste modifyTaste) {
		this.modifyTaste = modifyTaste;
	}
	
}
