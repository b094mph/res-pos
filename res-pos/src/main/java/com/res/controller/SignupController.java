package com.res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
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

	private static Logger logger = Logger.getLogger(SignupController.class);
	
	@Autowired
	private SignupService signupService;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, BindingResult result, 
			HttpServletRequest request){
		HttpSession session = request.getSession();
		Boolean validateUser = signupService.validateUser(user);
		logger.info("User valid = " + validateUser);
		
		String lang = request.getParameter("lang");
		if(StringUtils.isNotBlank(lang)){
			session.setAttribute("lang", lang);
		}
		if(validateUser){
			return "welcome";
		}else{
			return "loginfail";
		}
	}
}
