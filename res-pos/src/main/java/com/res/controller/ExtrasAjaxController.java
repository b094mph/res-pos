package com.res.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.exception.ServiceException;
import com.res.model.FoodCategory;
import com.res.model.Menu;
import com.res.model.ModifyTaste;
import com.res.service.MenuService;
import com.res.util.MessageLoader;

@Controller
@SessionAttributes
public class ExtrasAjaxController {

	private static Logger logger = Logger.getLogger(ExtrasAjaxController.class);
	
	@Autowired MenuService menuService;
	@Autowired MessageLoader messageLoader;
	
	@RequestMapping(value="/showExtras.json", method=RequestMethod.GET)
	public ModelAndView showExtras(HttpServletRequest request,
			@RequestParam(value="rowIndex", defaultValue="0") int rowIndex) throws ServiceException{
		HttpSession session = request.getSession();
		session.setAttribute("rowIndex", rowIndex);

		Long restaurantId = (Long) session.getAttribute("restaurantId");
		
		if(restaurantId == null){
			throw new ServiceException(messageLoader.getMessage("restaurantid.not.set"));
		}
		
		ModelAndView mav = new ModelAndView("showExtras");
		
		List<FoodCategory> extrasCategories = menuService.getExtrasCategoryFromMenu(restaurantId);
		logger.info("Number of Extras categories: " +  extrasCategories.size());
		List<ModifyTaste> tasteModifiers = menuService.getTasteModifiers(restaurantId);
		
		for(FoodCategory extrasCategory : extrasCategories){
			String foodCategoryName = extrasCategory.getFoodCategoryName().replace("Extra ", "");
			extrasCategory.setFoodCategoryName(foodCategoryName);
		}
		mav.addObject("extrasCategories", extrasCategories);
		mav.addObject("tasteModifiers", tasteModifiers);
		mav.addObject("lang", session.getAttribute("lang"));
		
		return mav;
	}
	
	@RequestMapping(value="/extrasSubCategory.json", method=RequestMethod.GET)
	public ModelAndView extrasSubCategory(HttpServletRequest request,
			@RequestParam("extrasCategoryId") long extrasCategoryId) throws ServiceException{
		HttpSession session = request.getSession();
		
		ModelAndView mav = new ModelAndView("extras");
		logger.info("ExtraCategoryId = " + extrasCategoryId);
		
		Long restaurantId = (Long)session.getAttribute("restaurantId");
		if(restaurantId == null){
			throw new ServiceException(messageLoader.getMessage("restaurantid.not.set"));
		}
		
		List<Menu> extrasSubCategories = menuService.getMenuByExtrasCategory(restaurantId, extrasCategoryId);
		mav.addObject("extrasSubCategories", extrasSubCategories);
		mav.addObject("lang", session.getAttribute("lang"));
		mav.addObject("rowIndex", session.getAttribute("rowIndex"));
		
		return mav;
	}
}
