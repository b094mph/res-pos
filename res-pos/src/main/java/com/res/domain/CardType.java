package com.res.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cardtype")
public class CardType implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cardtypeid")
	private long cardTypeId;
	
	@Column(name="cardname", unique=true, nullable=true, length=50)
	private String cardName;
	
	public long getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	
	public String getCardName() {
		return cardName;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
}
