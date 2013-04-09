package com.restaurant.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="agentjob", catalog="restaurant", uniqueConstraints={
		@UniqueConstraint(columnNames="restaurantid"),
		@UniqueConstraint(columnNames="agentid")
})
public class AgentJob {

	private long agentJobId;
	private long restaurantId;
	private long agentId;
	private Time createdDate;
	private String createdBy;
	private Time lastUpdatedDate;
	private String lastUpdatedBy;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agentjobid")
	public long getAgentJobId() {
		return agentJobId;
	}
	public void setAgentJobId(long agentJobId) {
		this.agentJobId = agentJobId;
	}
	
	@Column(name="restaurantid", unique=false, nullable=false, length=11)
	public long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	@Column(name="agentid", unique=false, nullable=false, length=11)
	public long getAgentId() {
		return agentId;
	}
	public void setAgentId(long agentId) {
		this.agentId = agentId;
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
