package com.res.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.exception.ServiceException;
import com.res.model.FoodCategory;
import com.res.service.MenuService;
import com.res.service.RestaurantService;
import com.res.util.MessageLoader;

@Controller
@SessionAttributes
public class MenuController {

	private static Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired private MenuService menuService;
	@Autowired private RestaurantService restaurantService;
	@Autowired private MessageLoader messageLoader;
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public ModelAndView showMenu(HttpServletRequest req, HttpServletResponse res) throws ServiceException{
		HttpSession session = req.getSession();
		
		Long restaurantId = Long.parseLong((String)session.getAttribute("restaurantId"));
		if(restaurantId == null){
			throw new ServiceException(messageLoader.getMessage("restaurantid.not.set"));
		}
		
		ModelAndView mav = new ModelAndView("menu");
		
		logger.info("restaurantId = " + restaurantId);
		
		String restaurantName = restaurantService.findRestaurantName(restaurantId);
		mav.addObject("restaurantName", restaurantName);
		
		List<FoodCategory> foodCategories = menuService.getFoodCategoriesFromMenu(restaurantId); 
		mav.addObject("restaurantId", restaurantId);
		mav.addObject("foodCategories", foodCategories);
		mav.addObject("foodCategoriesSize", foodCategories.size());
		
		return mav;
	}

}
