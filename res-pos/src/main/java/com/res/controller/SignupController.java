package com.res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

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
		
		String lang = RequestContextUtils.getLocale(request).toString();
		session.setAttribute("lang", lang);
		
		if(validateUser){
			return "redirect:signupSuccess.html";
		}else{
			return "redirect:signupFail.html";
		}
	}
	
	@RequestMapping(value="/signupFail", method=RequestMethod.GET)
	public String signupFail(ModelMap model){
		logger.info("signup failed, username is taken...");
		model.addAttribute("error", "true");
		return "signupFail";
	}
}
