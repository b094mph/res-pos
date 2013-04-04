package com.restaurant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.restaurant.service.MenuService;

public class MenuController extends AbstractController{

	private MenuService menuService;
	private String viewName;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView(getViewName());
		mav.addObject("menuList", menuService.getWholeMenu());
		return mav;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
}
