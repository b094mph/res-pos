package com.res.service;

import com.res.model.UserDetails;


public interface SignupService {

	public boolean isUsernameTaken(String username);
	public String createSalt();
	public String createHash(String password, String salt);
	public boolean validateUser(UserDetails user);
}
