package com.res.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="creditcard", uniqueConstraints={
		@UniqueConstraint(columnNames="personid"),
		@UniqueConstraint(columnNames="addressid"),
		@UniqueConstraint(columnNames="cardtypeid")
})
public class CreditCard implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="creditcardid")
	private long creditCardId;
	
	@Column(name="personid", unique=false, nullable=false, length=11)
	private long personId;
	
	@Column(name="addressid", unique=false, nullable=true, length=11)
	private Long addressId;
	
	@Column(name="cardtypeid", unique=false, nullable=true, length=11)
	private Long cardTypeId;
	
	@Column(name="creditcardending", unique=false, nullable=false, length=4)
	private String creditCardEnding;
	
	@Column(name="creditcardnum", unique=false, nullable=false, length=19)
	private String creditCardNum;
	
	@Column(name="creditcardname", unique=false, nullable=false, length=50)
	private String creditCardName;
	
	@Column(name="expiration", unique=false, nullable=false, length=6)
	private Date expiration;
	
	@Column(name="ccv", unique=false, nullable=false, length=3)
	private String ccv;

	public long getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(long creditCardId) {
		this.creditCardId = creditCardId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(Long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public String getCreditCardEnding() {
		return creditCardEnding;
	}

	public void setCreditCardEnding(String creditCardEnding) {
		this.creditCardEnding = creditCardEnding;
	}

	public String getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public String getCreditCardName() {
		return creditCardName;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}
	
}
