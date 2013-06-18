package com.res.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="restaurantmodifytaste")
public class RestaurantModifyTaste implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId private RestaurantModifyTasteId id;
}
