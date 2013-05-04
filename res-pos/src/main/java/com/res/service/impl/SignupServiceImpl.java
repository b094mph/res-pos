package com.res.service.impl;





import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.dao.hibernate.AuthoritiesDao;
import com.res.dao.hibernate.UsersDao;
import com.res.model.UserDetails;
import com.res.security.SHAHashing;
import com.res.service.SignupService;

@Service("signupService")
@Transactional
public class SignupServiceImpl implements SignupService {
	
	private static Logger logger = Logger.getLogger("SignupServiceImpl.class");

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private AuthoritiesDao authoritiesDao;
	
	@Override
	public boolean isUsernameTaken(String username) {
		UserDetails user = usersDao.getUserByUsername(username);
		
		if( user != null && StringUtils.trimToEmpty(username).equals(user.getUsername())){
			logger.info("Username " + username + " is taken.");
			return true;
		}else{
			logger.info("Username " + username +" is not taken.");
			return false;
		}
		
		
	}

	@Override
	public String createSalt() {
		String salt = SHAHashing.createSalt();
		logger.info("Salt : " + salt);
		return salt;
	}
	
	@Override
	public String createHash(String password, String salt){
		String hash = SHAHashing.createHash(salt + password);
		logger.info("Hash : " + hash);
		return hash;
	}

	@Override
	public boolean validateUser(UserDetails user) {
		String username = user.getUsername();
		if(!isUsernameTaken(username)){
			String salt = createSalt();
			String hash = createHash(user.getPassword(), salt);
			user.setSalt(salt);
			user.setPassword(hash);
			user.setEnabled(true);
			user.setCreatedBy(username);
			user.setLastUpdatedBy(username);
			usersDao.save(user);
			authoritiesDao.setRoleUser(username);
			return true;
		}else{
			return false;
		}
	}
	
}
