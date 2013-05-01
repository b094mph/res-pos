package com.res.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Agent;
import com.res.service.AgentService;

@Controller
@SessionAttributes
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private AgentService agentService;
	
	@RequestMapping(value = "/login")
	public ModelAndView showLoginHome(){
		logger.info("Logging in...");
		return new ModelAndView("login", "command", new Agent());
	}

}
