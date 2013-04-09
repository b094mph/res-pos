package com.restaurant.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="person", catalog="restaurant", uniqueConstraints={
	@UniqueConstraint(columnNames="addressid")
})
public class Person {

	private long personId;
	private long addressId;
	private String firstName;
	private String lastName;
	private String phone1;
	private String phone2;
	private String email;
	private String note;
	private Time lastUpdatedDate;
	private String lastUpdatedBy;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="personid")
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	@Column(name="addressid", unique=false, nullable=true, length=11)
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	@Column(name="firstname", unique=false, nullable=true, length=20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="lastname", unique=false, nullable=true, length=20)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="phone1", unique=false, nullable=false, length=10)
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
	
	@Column(name="email", unique=false, nullable=true, length=10)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="note", unique=false, nullable=true, length=500)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Temporal(TemporalType.TIME)
	@Column(name="lastupdateddate", unique=false, nullable=true, length=12)
	public Time getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Time lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@Column(name="lastupdatedby", unique=false, nullable=true, length=20)
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
}
