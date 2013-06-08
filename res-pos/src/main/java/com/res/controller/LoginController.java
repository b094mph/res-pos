package com.res.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.res.model.Restaurant;
import com.res.model.User;
import com.res.service.RestaurantService;
import com.res.service.UserService;

@Controller
@SessionAttributes
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired private UserService agentService;
	@Autowired private RestaurantService restaurantService;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView login(){
		logger.info("Logging in...");
		return new ModelAndView("login", "command", new User());
	}
	
	@RequestMapping(value= "/loginfail", method=RequestMethod.GET)
	public String loginFail(ModelMap model){
		logger.info("Login failed...");
		model.addAttribute("error", "true");
		return "loginfail";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView welcome(Principal principal, HttpServletRequest request){	
		HttpSession session = request.getSession();
		
		//this will clear foodCategoryId whenever leaving the order screen
		session.setAttribute("foodCategoryId", "");  
		
		ModelAndView mav = new ModelAndView("welcome");
		
		String agentName = principal.getName();
		session.setAttribute("agentName", agentName);
		logger.info("in welcome " + agentName);

		List<Restaurant> restaurants = restaurantService.getRestaurants();
		mav.addObject("restaurants", restaurants);
		mav.addObject("numOfRes", restaurants.size());

		String lang = RequestContextUtils.getLocale(request).toString();
		session.setAttribute("lang", lang);
		mav.addObject("lang", lang);
		
		return mav;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(){
		logger.info("Logging out...");
		return "logout";
	}

}
