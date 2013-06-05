package com.res.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.res.exception.ServiceException;
import com.res.model.FoodCategory;
import com.res.model.Menu;
import com.res.service.AddressService;
import com.res.service.CustomerService;
import com.res.service.MenuService;
import com.res.service.RestaurantService;
import com.res.util.MessageLoader;

@Controller
@SessionAttributes
public class MenuController {

	private static Logger logger = Logger.getLogger(MenuController.class);
	
	@Autowired private MenuService menuService;
	@Autowired private RestaurantService restaurantService;
	@Autowired private CustomerService customerService;
	@Autowired private AddressService addressService;
	@Autowired private MessageLoader messageLoader;
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public ModelAndView showMenu(HttpServletRequest request, HttpServletResponse response) throws ServiceException{
		HttpSession session = request.getSession();
		String resId = (String) session.getAttribute("restaurantId");
		logger.info("restaurantId = " + resId);
		ModelAndView mav = null;
		
		if(resId == null){
			mav = new ModelAndView("redirect:/welcome.html");
			return mav;
		}
		mav = new ModelAndView("menu");
		
		Long restaurantId = Long.parseLong(resId);
		mav.addObject("restaurantId", restaurantId);
		
		String restaurantName = restaurantService.findRestaurantName(restaurantId);
		session.setAttribute("restaurantName", restaurantName);
		
		List<FoodCategory> foodCategories = menuService.getFoodCategoriesFromMenu(restaurantId); 
		mav.addObject("foodCategories", foodCategories);
		mav.addObject("foodCategoriesSize", foodCategories.size());
		
		String lang = RequestContextUtils.getLocale(request).toString();
		session.setAttribute("lang", lang);
		mav.addObject("lang", lang);
		
		// typeaheads
		mav.addObject("phoneNumbers", customerService.typeaheadPhoneNumber(restaurantId));
		mav.addObject("firstNames", customerService.typeaheadFirstName(restaurantId));
		mav.addObject("lastNames", customerService.typeaheadLastName(restaurantId));
		mav.addObject("emails", customerService.typeaheadEmail(restaurantId));
		mav.addObject("notes", customerService.typeaheadNote(restaurantId));
		
		mav.addObject("street1s", addressService.typeaheadStreet1(restaurantId));
		mav.addObject("street2s", addressService.typeaheadStreet2(restaurantId));
		mav.addObject("cities", addressService.typeaheadCity(restaurantId));
		mav.addObject("states", addressService.typeaheadState(restaurantId));
		mav.addObject("zipCodes", addressService.typeaheadZipcode(restaurantId));
		
		return mav;
	}
	
	@RequestMapping(value="/wholeMenu", method=RequestMethod.GET)
	public ModelAndView showMenuList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();		
		ModelAndView mav = null;

		String resId = (String) session.getAttribute("restaurantId");
		if(resId == null){
			mav = new ModelAndView("redirect:/welcome.html");
			return mav;
		}
		
		mav = new ModelAndView("wholeMenu");
		Long restaurantId = Long.parseLong(resId);
	
		List<Menu> menuList = menuService.getMenu(restaurantId);
		
		mav.addObject("menuList", menuList);
		return mav;
	}

	@RequestMapping(value="editMenu", method=RequestMethod.GET)
	public ModelAndView editMenu(HttpServletRequest request, HttpServletResponse response){
		String menuId = request.getParameter("menuId");
		logger.info("menuId = " + menuId);
		ModelAndView mav = new ModelAndView("editMenu");
		Menu menu = menuService.getMenuByMenuId(Long.parseLong(menuId));
		mav.addObject("menu", menu);
		return mav;
	}
	
	@RequestMapping(value="saveMenu", method=RequestMethod.GET)
	public String saveMenu(@ModelAttribute("menu") Menu menu, BindingResult result){
		logger.info("saving menu prices " + menu.getLunch());
		
		//TODO: fix bug
		//menuService.saveMenu(menu);
		return "redirect:/wholeMenu.html";
	}

}
