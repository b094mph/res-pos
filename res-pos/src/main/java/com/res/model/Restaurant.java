package com.res.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="restaurant", catalog="restaurant", uniqueConstraints={
	@UniqueConstraint(columnNames="addressid"),
	@UniqueConstraint(columnNames="personid")
})
public class Restaurant implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restaurantid")
	private long restaurantId;
	
	@Column(name="addressid", unique=true, nullable=false, length=11)
	private long addressId;
	
	@Column(name="personid", unique=true, nullable=false, length=11)
	private long personId;
	
	@Column(name="restaurantname", unique=false, nullable=false, length=100)
	private String restaurantName;
	
	@Column(name="location", unique=false, nullable=true, length=100)
	private String location;
	
	@Column(name="phone1", unique=true, nullable=false, length=10)
	private String phone1;
	
	@Column(name="phone2", unique=false, nullable=true, length=10)
	private String phone2;
	
	@Column(name="faxnumber", unique=false, nullable=true, length=10)
	private String faxNumber;
	
	@Column(name="deliverycost", unique=false, nullable=true, length=5)
	private float deliveryCost;
	
	@Column(name="tax", unique=false, nullable=true, length=5)
	private float tax;
	
	@Column(name="rounding", unique=false, nullable=true, length=1)
	private boolean rounding;
	
	@Column(name="montothursopen", unique=false, nullable=false, length=8)
	private String monToThursOpen;
	
	@Column(name="montothursclose", unique=false, nullable=false, length=8)
	private String monToThursClose;
	
	@Column(name="friopen", unique=false, nullable=false, length=8)
	private String friOpen;
	
	@Column(name="friclose", unique=false, nullable=false, length=8)
	private String friClose;
	
	@Column(name="satopen", unique=false, nullable=false, length=8)
	private String satOpen;
	
	@Column(name="satclose", unique=false, nullable=false, length=8)
	private String satClose;
	
	@Column(name="sunopen", unique=false, nullable=false, length=8)
	private String sunOpen;
	
	@Column(name="sunclose", unique=false, nullable=false, length=8)
	private String sunClose;
	
	@Column(name="createddate", unique=false, nullable=true, length=12)
	private Time createdDate;
	
	@Column(name="createdby", unique=false, nullable=true, length=20)
	private String createdBy;
	
	@Column(name="lastupdateddate", unique=false, nullable=true, length=12)
	private Time lastUpdatedDate;
	
	@Column(name="lastupdatedby", unique=false, nullable=true, length=12)
	private String lastUpdatedBy;

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public float getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(float deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public boolean isRounding() {
		return rounding;
	}

	public void setRounding(boolean rounding) {
		this.rounding = rounding;
	}

	public String getMonToThursOpen() {
		return monToThursOpen;
	}

	public void setMonToThursOpen(String monToThursOpen) {
		this.monToThursOpen = monToThursOpen;
	}

	public String getMonToThursClose() {
		return monToThursClose;
	}

	public void setMonToThursClose(String monToThursClose) {
		this.monToThursClose = monToThursClose;
	}

	public String getFriOpen() {
		return friOpen;
	}

	public void setFriOpen(String friOpen) {
		this.friOpen = friOpen;
	}

	public String getFriClose() {
		return friClose;
	}

	public void setFriClose(String friClose) {
		this.friClose = friClose;
	}

	public String getSatOpen() {
		return satOpen;
	}

	public void setSatOpen(String satOpen) {
		this.satOpen = satOpen;
	}

	public String getSatClose() {
		return satClose;
	}

	public void setSatClose(String satClose) {
		this.satClose = satClose;
	}

	public String getSunOpen() {
		return sunOpen;
	}

	public void setSunOpen(String sunOpen) {
		this.sunOpen = sunOpen;
	}

	public String getSunClose() {
		return sunClose;
	}

	public void setSunClose(String sunClose) {
		this.sunClose = sunClose;
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
	
}
