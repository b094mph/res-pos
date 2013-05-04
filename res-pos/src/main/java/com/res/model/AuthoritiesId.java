package com.res.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AuthoritiesId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="username", nullable=false, length=50)
	private String username;

	@Column(name="authority", nullable=false, length=50)
	private String authority;
	
	public AuthoritiesId(String username, String authority){
		this.username = username;
		this.authority = authority;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
