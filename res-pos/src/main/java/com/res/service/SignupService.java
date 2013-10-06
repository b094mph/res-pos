package com.res.service;

import com.res.domain.User;


public interface SignupService {

	public boolean isUsernameTaken(String username);
	public String createSalt();
	public String createHash(String password, String salt);
	public boolean validateUser(User user);
}
