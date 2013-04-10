package com.res.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="creditcard", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="personid"),
		@UniqueConstraint(columnNames="addressid"),
		@UniqueConstraint(columnNames="cardtypeid")
})
public class CreditCard {

	private long creditCardId;
	private long personId;
	private long addressId;
	private long cardTypeId;
	private String creditCardNumber;
	private String creditCardName;
	private Date expiration;
	private String ccv;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="creditcardid")
	public long getCreditCardId() {
		return creditCardId;
	}
	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}
	
	@Column(name="personid", unique=false, nullable=false, length=11)
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
	
	@Column(name="cardtypeid", unique=false, nullable=true, length=11)
	public long getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	
	@Column(name="creditcardnumber", unique=false, nullable=false, length=19)
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	
	@Column(name="creditcardname", unique=false, nullable=false, length=50)
	public String getCreditCardName() {
		return creditCardName;
	}
	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}
	
	@Column(name="expiration", unique=false, nullable=false, length=6)
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	
	@Column(name="ccv", unique=false, nullable=false, length=3)
	public String getCcv() {
		return ccv;
	}
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

}
