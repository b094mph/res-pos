package com.res.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		long restaurantId = 1L; //TODO: hard coded for now.
		logger.info("restaurantId = " + restaurantId);
		
		List<FoodCategory> foodCategories = menuService.getFoodCategoriesFromMenu(restaurantId);
		
		mav.addObject("restaurantId", restaurantId);
		mav.addObject("foodCategories", foodCategories);
		mav.addObject("foodCategoriesSize", foodCategories.size());
		return mav;
	}
	
	@RequestMapping("/subCategory")
	public ModelAndView showSubCategories(HttpServletRequest req, HttpServletResponse res){
		String foodCategoryId = req.getParameter("foodCategoryId");
		logger.info("hitting showSubcatregories controller " + foodCategoryId);
		ModelAndView mav = new ModelAndView("base.category");
		
		//TODO: restaurant id is hard coded for now
		mav.addObject("subCategories", menuService.getMenuByFoodCategory(1L, Long.parseLong(foodCategoryId)));
		return mav;
	}

}