package com.res.dao.hibernate.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.res.constant.RoleConstant;
import com.res.dao.hibernate.AuthoritiesDao;
import com.res.domain.Authorities;
import com.res.domain.AuthoritiesId;

@Repository("authoritiesDao")
public class AuthoritiesDaoImpl extends BaseDaoImpl implements AuthoritiesDao{
	
	private static Logger logger = Logger.getLogger(AuthoritiesDaoImpl.class);

	@Override
	public void setRoleAdmin(String username) {
		logger.info("Setting " + username + " with " + RoleConstant.ROLE_ADMIN);
		setRole(username, RoleConstant.ROLE_ADMIN);
	}

	@Override
	public void setRoleUser(String username) {
		logger.info("Setting " + username + " with " + RoleConstant.ROLE_USER);
		setRole(username, RoleConstant.ROLE_USER);
	}

	private void setRole(String username, String role){
		AuthoritiesId authorityId = new AuthoritiesId(username, role);
		Authorities authority = new Authorities();
		authority.setId(authorityId);
		authority.setCreatedBy(username);
		save(authority);
	}
}
