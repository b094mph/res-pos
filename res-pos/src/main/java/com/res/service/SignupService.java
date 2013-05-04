package com.res.service;

import com.res.model.Users;


public interface SignupService {

	public boolean isUsernameTaken(String username);
	public String createSalt();
	public String createHash(String password, String salt);
	public boolean validateUser(Users user);
}
