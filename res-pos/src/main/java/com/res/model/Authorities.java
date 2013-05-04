package com.res.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId AuthoritiesId id;

	@Column(name="createddate", length=12)
	private Time createdDate;
	
	@Column(name="createdby", length=20)
	private String createdBy;
	
	@Column(name="lastupdateddate", length=12)
	private Time lastUpdatedDate;
	
	@Column(name="lastupdatedby", length=12)
	private String lastUpdatedBy;

	public AuthoritiesId getId() {
		return id;
	}

	public void setId(AuthoritiesId id) {
		this.id = id;
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
