package com.res.dao.hibernate;

import java.util.List;

import com.res.domain.User;

public interface UserDao extends BaseDao{

	public User findUser(long id);
	public User getUserByUsername(String username);
	public List<String> getUsernames();
}
