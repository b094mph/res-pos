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

@Entity
@Table(name="agent", catalog="restaurant")
public class Agent {

	private long agentId;
	private String userName;
	private String firstName;
	private String lastName;
	private String agentPassword;
	private Time createdDate;
	private String createdBy;
	private Time lastUpdatedDate;
	private String lastUpdatedBy;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agentid")
	public long getAgentId() {
		return agentId;
	}
	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}
	
	@Column(name="username", unique=true, nullable=false, length=20)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="firstname", unique=false, nullable=false, length=20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="lastname", unique=false, nullable=false, length=20)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="agentpassword", unique=false, nullable=false, length=30)
	public String getAgentPassword() {
		return agentPassword;
	}
	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
	}

	@Temporal(TemporalType.TIME)
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
	
	@Temporal(TemporalType.TIME)
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
