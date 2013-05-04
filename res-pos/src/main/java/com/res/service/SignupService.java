package com.res.service;

import com.res.model.Users;


public interface SignupService {

	public boolean isUsernameTaken(String username);
	public String hashAndSaltPassword(String password);
	public void saveUser(Users user);
}
