package com.res.dao.hibernate;

public interface AuthoritiesDao extends BaseDao{

	public void setRoleAdmin(String username);
	public void setRoleUser(String username);
	
}
