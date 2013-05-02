package com.res.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView login(){
		logger.info("Logging in...");
		return new ModelAndView("login", "command", new Agent());
	}
	
	@RequestMapping(value= "/loginfail", method=RequestMethod.GET)
	public String loginFail(ModelMap model){
		logger.info("Login failed...");
		model.addAttribute("error", "true");
		return "loginfail";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcome(Principal principal){
		ModelAndView mav = new ModelAndView("welcome");
		
		String username = principal.getName();
		logger.info("in welcome " + username);
		
		mav.addObject("username", username);
		
		return mav;
	}

}
