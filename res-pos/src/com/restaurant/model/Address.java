package com.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address", catalog="restaurant")
public class Address {

	private long addressId;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zipCode;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="addressid")
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	@Column(name="street1", unique=false, nullable=false, length=40)
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	
	@Column(name="street2", unique=false, nullable=true, length=40)
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	
	@Column(name="city", unique=false, nullable=false, length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="state", unique=false, nullable=false, length=2)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name="zipcode", unique=false, nullable=false, length=5)
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
