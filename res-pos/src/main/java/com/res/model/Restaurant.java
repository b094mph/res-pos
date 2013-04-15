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

	private long restaurantId;
	private long addressId;
	private long personId;
	private String restaurantName;
	private String location;
	private String phone1;
	private String phone2;
	private String faxNumber;
	private float deliveryCost;
	private float tax;
	private boolean rounding;
	private String monToThursOpen;
	private String monToThursClose;
	private String friOpen;
	private String friClose;
	private String satOpen;
	private String satClose;
	private String sunOpen;
	private String sunClose;
	private Time createdDate;
	private String createdBy;
	private Time lastUpdatedDate;
	private String lastUpdatedBy;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restaurantid")
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	@Column(name="addressid", unique=true, nullable=false, length=11)
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	@Column(name="personid", unique=true, nullable=false, length=11)
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	@Column(name="restaurantname", unique=false, nullable=false, length=100)
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	@Column(name="location", unique=false, nullable=true, length=100)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name="phone1", unique=true, nullable=false, length=10)
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	@Column(name="phone2", unique=false, nullable=true, length=10)
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	@Column(name="faxnumber", unique=false, nullable=true, length=10)
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	
	@Column(name="deliverycost", unique=false, nullable=true, length=5)
	public float getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(float deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	@Column(name="tax", unique=false, nullable=true, length=5)
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
		this.tax = tax;
	}
	
	@Column(name="rounding", unique=false, nullable=true, length=1)
	public boolean isRounding() {
		return rounding;
	}
	public void setRounding(boolean rounding) {
		this.rounding = rounding;
	}
	
	@Column(name="montothursopen", unique=false, nullable=false, length=8)
	public String getMonToThursOpen() {
		return monToThursOpen;
	}
	public void setMonToThursOpen(String monToThursOpen) {
		this.monToThursOpen = monToThursOpen;
	}
	@Column(name="montothursclose", unique=false, nullable=false, length=8)
	public String getMonToThursClose() {
		return monToThursClose;
	}
	public void setMonToThursClose(String monToThursClose) {
		this.monToThursClose = monToThursClose;
	}
	
	@Column(name="friopen", unique=false, nullable=false, length=8)
	public String getFriOpen() {
		return friOpen;
	}
	public void setFriOpen(String friOpen) {
		this.friOpen = friOpen;
	}
	
	@Column(name="friclose", unique=false, nullable=false, length=8)
	public String getFriClose() {
		return friClose;
	}
	public void setFriClose(String friClose) {
		this.friClose = friClose;
	}
	
	@Column(name="satopen", unique=false, nullable=false, length=8)
	public String getSatOpen() {
		return satOpen;
	}
	public void setSatOpen(String satOpen) {
		this.satOpen = satOpen;
	}
	
	@Column(name="satclose", unique=false, nullable=false, length=8)
	public String getSatClose() {
		return satClose;
	}
	public void setSatClose(String satClose) {
		this.satClose = satClose;
	}
	
	@Column(name="sunopen", unique=false, nullable=false, length=8)
	public String getSunOpen() {
		return sunOpen;
	}
	public void setSunOpen(String sunOpen) {
		this.sunOpen = sunOpen;
	}
	
	@Column(name="sunclose", unique=false, nullable=false, length=8)
	public String getSunClose() {
		return sunClose;
	}
	public void setSunClose(String sunClose) {
		this.sunClose = sunClose;
	}
	
	@Column(name="createddate", unique=false, nullable=true, length=12)
	public Time getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Time createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="createdby", unique=false, nullable=true, length=20)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="lastupdateddate", unique=false, nullable=true, length=12)
	public Time getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Time lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@Column(name="lastupdatedby", unique=false, nullable=true, length=12)
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
}
