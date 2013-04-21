package com.res.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="agent", catalog="restaurant")
@Cache(region="agents", usage=CacheConcurrencyStrategy.READ_WRITE)
public class Agent implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agentid")
	private long agentId;
	
	@Column(name="username", unique=true, nullable=false, length=20)
	private String userName;
	
	@Column(name="firstname", unique=false, nullable=false, length=20)
	private String firstName;
	
	@Column(name="lastname", unique=false, nullable=false, length=20)
	private String lastName;
	
	@Column(name="agentpassword", unique=false, nullable=false, length=30)
	private String agentPassword;
	
	@Column(name="createddate", unique=false, nullable=true, length=12)
	private Time createdDate;
	
	@Column(name="createdby", unique=false, nullable=true, length=20)
	private String createdBy;
	
	@Column(name="lastupdateddate", unique=false, nullable=true, length=12)
	private Time lastUpdatedDate;
	
	@Column(name="lastupdatedby", unique=false, nullable=true, length=12)
	private String lastUpdatedBy;

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAgentPassword() {
		return agentPassword;
	}

	public void setAgentPassword(String agentPassword) {
		this.agentPassword = agentPassword;
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
