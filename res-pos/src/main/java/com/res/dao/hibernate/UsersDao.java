package com.res.dao.hibernate;

import java.util.List;

import com.res.model.UserDetails;

public interface UsersDao extends BaseDao{

	public UserDetails findUser(long id);
	public UserDetails getUserByUsername(String username);
	public List<String> getUsernames();
}
