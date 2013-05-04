package com.res.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.res.model.Users;

@Controller
public class SignupController {

	private static Logger logger = Logger.getLogger("SignupController.class");
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("users") Users user, BindingResult result){
		
		
		
		return "redirect:/welcome.html";
	}
}
