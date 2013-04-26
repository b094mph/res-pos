package com.res.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.FoodCategory;
import com.res.service.MenuService;

@Controller
@SessionAttributes
public class MenuController {

	private static Logger logger = Logger.getLogger("MenuController.class");
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/menu")
	public ModelAndView showMenu(){
		ModelAndView mav = new ModelAndView("menu");
		
		long restaurantId = 1L;
		logger.info("restaurantId = " + restaurantId);
		
		List<FoodCategory> foodCategories = menuService.getFoodCategoriesFromMenu(restaurantId);
		
		mav.addObject("restaurantId", restaurantId);
		mav.addObject("foodCategories", foodCategories);
		return mav;
	}

}
