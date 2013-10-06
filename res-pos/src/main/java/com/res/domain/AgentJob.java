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
@Table(name="agentjob", uniqueConstraints={
		@UniqueConstraint(columnNames="restaurantid"),
		@UniqueConstraint(columnNames="agentid")
})
public class AgentJob implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="agentjobid")
	private long agentJobId;
	
	@Column(name="restaurantid", unique=false, nullable=false, length=11)
	private long restaurantId;
	
	@Column(name="agentid", unique=false, nullable=false, length=11)
	private long agentId;
	
	@Column(name="createddate", unique=false, nullable=true, length=12)
	private Date createdDate;
	
	@Column(name="createdby", unique=false, nullable=true, length=20)
	private String createdBy;
	
	@Column(name="lastupdateddate", unique=false, nullable=true, length=12)
	private Date lastUpdatedDate;
	
	@Column(name="lastupdatedby", unique=false, nullable=true, length=12)
	private String lastUpdatedBy;

	public long getAgentJobId() {
		return agentJobId;
	}

	public void setAgentJobId(long agentJobId) {
		this.agentJobId = agentJobId;
	}

	public long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}
