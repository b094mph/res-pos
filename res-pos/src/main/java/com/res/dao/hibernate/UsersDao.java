package com.res.dao.hibernate;

import java.util.List;

import com.res.model.Users;

public interface UsersDao extends BaseDao{

	public Users findUser(long id);
	public Users getUserByUsername(String username);
	public List<String> getUsernames();
}
