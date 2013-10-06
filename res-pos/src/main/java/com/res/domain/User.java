package com.res.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;

@Entity
@NamedQueries({
	@NamedQuery(name="getUserByUsername", query="FROM User u WHERE u.username = :username"),
	@NamedQuery(name="getUsernames", query="SELECT u.username FROM User u")
})
@Table(name="users")
@Cache(region="users", usage=CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable, org.springframework.security.core.userdetails.UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="username", unique=true, nullable=false, length=20)
	private String username;
	
	@Column(name="password", nullable=false, length=64)
	private String password;
	
	@Column(name="salt", nullable=false, length=48)
	private String salt;
	
	@Column(name="firstname", length=20)
	private String firstname;
	
	@Column(name="lastname", length=20)
	private String lastname;
	
	@Column(name="enabled", nullable=false, length=1)
	private boolean enabled;
	
	@Column(name="createddate", length=12)
	private Date createdDate;
	
	@Column(name="createdby", length=20)
	private String createdBy;
	
	@Column(name="lastupdateddate", length=12)
	private Date lastUpdatedDate;
	
	@Column(name="lastupdatedby", length=12)
	private String lastUpdatedBy;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

}
