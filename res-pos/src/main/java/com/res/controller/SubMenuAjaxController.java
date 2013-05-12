package com.res.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Menu;
import com.res.service.MenuService;

@Controller
@SessionAttributes
public class SubMenuAjaxController {
	
	public static Logger logger = Logger.getLogger(SubMenuAjaxController.class);
	
	@Autowired
	private MenuService menuService;

	@RequestMapping(value="/subMenu.json", method=RequestMethod.GET)
	public ModelAndView showSubCategories(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mav = new ModelAndView("subMenu");
		String foodCategoryId = req.getParameter("foodCategoryId");
		logger.info("hitting showSubcatregories controller " + foodCategoryId);
		List<Menu> subCategories = menuService.getMenuByFoodCategory(1L, Long.parseLong(foodCategoryId));
		mav.addObject("subCategories", subCategories);
		
		List<Long> foodIDs = new ArrayList<Long>();
		for(Menu foodItem : subCategories){
			foodIDs.add(foodItem.getFoodId());
		}
		mav.addObject("foodIDs", foodIDs);
		return mav;
	}
	
//	@RequestMapping(value="/subMenu.json", method=RequestMethod.GET)
//	public @ResponseBody String showSubCategories(HttpServletRequest req, HttpServletResponse res){
//		String foodCategoryId = req.getParameter("foodCategoryId");
//		logger.info("hitting showSubcatregories controller " + foodCategoryId);
//		List<Menu> subMenuList = menuService.getMenuByFoodCategory(1L, Long.parseLong(foodCategoryId));
//		return foodCategoryId;
//	}

}
