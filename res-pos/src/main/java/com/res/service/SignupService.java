package com.res.service;


public interface SignupService {

	public boolean isUsernameTaken(String username);
	public String hashAndSaltPassword(String password);
}
