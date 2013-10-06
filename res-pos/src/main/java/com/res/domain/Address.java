package com.res.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "address")
@Cache(region = "addresses", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressid")
	private long addressId;

	@Column(name = "street1", unique = false, nullable = false, length = 40)
	private String street1;

	@Column(name = "street2", unique = false, nullable = true, length = 40)
	private String street2;

	@Column(name = "city", unique = false, nullable = false, length = 20)
	private String city;

	@Column(name = "state", unique = false, nullable = false, length = 2)
	private String state;

	@Column(name = "zipcode", unique = false, nullable = false, length = 5)
	private String zipCode;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "address")
	@Cascade({CascadeType.SAVE_UPDATE})
	private List<Person> persons;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
