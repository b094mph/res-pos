package com.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cardtype", catalog="restaraunt")
public class CardType {

	private long cardTypeId;
	private String cardName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cardtypeid")
	public long getCardTypeId() {
		return cardTypeId;
	}
	public void setCardTypeId(long cardTypeId) {
		this.cardTypeId = cardTypeId;
	}
	
	@Column(name="cardname", unique=true, nullable=true, length=50)
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
}
