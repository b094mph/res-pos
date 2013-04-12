package com.res.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Agent;

@Controller
@SessionAttributes
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login")
	public ModelAndView showLogin(){
		log.info("logging in...");
		return new ModelAndView("login", "command", new Agent());
	}
}
