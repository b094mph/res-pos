package com.res.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RestaurantModifyTasteId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="restaurantid", nullable=false, length=11)
	private long restaurantId;
	
	@Column(name="modifytasteid", nullable=false, length=11)
	private long modifyTasteId;
	
	public RestaurantModifyTasteId(long restaurantId, long modifyTasteId){
		this.restaurantId = restaurantId;
		this.modifyTasteId = modifyTasteId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getModifyTasteId() {
		return modifyTasteId;
	}

	public void setModifyTasteId(long modifyTasteId) {
		this.modifyTasteId = modifyTasteId;
	}
	
}
