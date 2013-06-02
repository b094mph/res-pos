package com.res.controller;

import java.util.ArrayList;
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

import com.res.exception.EmptyCollectionException;
import com.res.model.Menu;
import com.res.service.MenuService;
import com.res.util.MessageLoader;

@Controller
@SessionAttributes
public class SubMenuAjaxController {
	
	public static Logger logger = Logger.getLogger(SubMenuAjaxController.class);
	
	@Autowired private MenuService menuService;
	@Autowired private MessageLoader messageLoader;

	@RequestMapping(value="/subMenu.json", method=RequestMethod.GET)
	public ModelAndView showSubCategories(HttpServletRequest request, HttpServletResponse response) 
			throws EmptyCollectionException{
		HttpSession session = request.getSession();
		Long restaurantId = Long.parseLong((String) session.getAttribute("restaurantId"));
		
		ModelAndView mav = new ModelAndView("subMenu");
		String foodCategoryId = request.getParameter("foodCategoryId");
		logger.info("hitting showSubcategories controller " + foodCategoryId);
		List<Menu> subCategories = menuService.getMenuByFoodCategory(restaurantId, Long.parseLong(foodCategoryId));
		mav.addObject("subCategories", subCategories);
		
		if(!subCategories.isEmpty()){
			mav.addObject("foodCategoryName", subCategories.get(0).getFoodCategory().getFoodCategoryName());
			mav.addObject("foodCategoryCName", subCategories.get(0).getFoodCategory().getFoodCategoryCName());
			
			List<Long> menuIDs = new ArrayList<Long>();
			for(Menu foodItem : subCategories){
				menuIDs.add(foodItem.getMenuId());
			}
			mav.addObject("menuIDs", menuIDs);
		}else{
			logger.error("subCategories is empty.");
			throw new EmptyCollectionException(messageLoader.getMessage("arraylist.empty"));
		}
		
		mav.addObject("lang", session.getAttribute("lang"));
		
		return mav;
	}

}
