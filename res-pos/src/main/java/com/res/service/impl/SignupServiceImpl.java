package com.res.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.UsersDao;
import com.res.model.Users;
import com.res.security.SHAHashing;
import com.res.service.SignupService;

@Service("signupService")
@Transactional
public class SignupServiceImpl implements SignupService {
	
	private static Logger logger = Logger.getLogger("SignupServiceImpl.class");

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public boolean isUsernameTaken(String username) {
		Users user = usersDao.getUserByUsername(username);
		
		if( user != null && username.equals(user.getUsername())){
			logger.info("Username = " + user.getUsername());
			return true;
		}
		
		return false;
	}

	@Override
	public String hashAndSaltPassword(String password) {
		String salt = SHAHashing.createSalt();
		logger.info("Salt : " + salt);
		String hashedPassword = SHAHashing.createHash(salt + password);
		return hashedPassword;
	}
	
	

}
