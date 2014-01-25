package com.res.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.res.domain.Restaurant;
import com.res.domain.User;
import com.res.service.RestaurantService;
import com.res.service.UserService;

@Controller
@SessionAttributes
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired private UserService agentService;
	@Autowired private RestaurantService restaurantService;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("login", "command", new User());
		logger.debug("Logging in...");
		setSessionLang(request, session, mav);
		return mav;
	}
	
	@RequestMapping(value= "/loginfail", method=RequestMethod.GET)
	public String loginFail(ModelMap model){
		logger.debug("Login failed...");
		model.addAttribute("error", "true");
		return "loginfail";
	}
	
	@RequestMapping(value="/signupSuccess", method=RequestMethod.GET)
	public String signupSuccess(ModelMap model){
		logger.debug("Username and password created successfully...");
		model.addAttribute("error", "false");
		return "signupSuccess";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcome(Principal principal, HttpServletRequest request){	
		HttpSession session = request.getSession();
		
		//this will clear foodCategoryId whenever leaving the order screen
		session.setAttribute("foodCategoryId", "");  
		
		ModelAndView mav = new ModelAndView("welcome");
		
		String agentName = principal.getName();
		session.setAttribute("agentName", agentName);
		MDC.clear();
		MDC.put("agentName", agentName);
		logger.info("in welcome " + agentName);

		List<Restaurant> restaurants = restaurantService.getRestaurants();
		mav.addObject("restaurants", restaurants);
		mav.addObject("numOfRes", restaurants.size());
		
		setSessionLang(request, session, mav);
		return mav;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		logger.debug("Logging out...");
		return "logout";
	}
	
	private void setSessionLang(HttpServletRequest request, HttpSession session, ModelAndView mav){
		String lang = RequestContextUtils.getLocale(request).toString();
		session.setAttribute("lang", lang);
		mav.addObject("lang", lang);
	}

}
