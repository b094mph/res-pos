package com.res.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.res.model.User;
import com.res.service.SignupService;

@Controller
public class SignupController {

	private static Logger logger = Logger.getLogger("SignupController.class");
	
	@Autowired
	private SignupService signupService;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, BindingResult result){
		Boolean validateUser = signupService.validateUser(user);
		logger.info("User valid = " + validateUser);
		if(validateUser){
			return "welcome";
		}else{
			return "loginfail";
		}
	}
}
