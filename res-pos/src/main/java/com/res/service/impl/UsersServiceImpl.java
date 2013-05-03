package com.res.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.res.service.UsersService;

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService {

	private static Logger logger = Logger.getLogger(UsersServiceImpl.class);

}
