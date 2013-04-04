package com.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.restaurant.model.Category;
import com.restaurant.service.CategoryService;

public class CategoryController extends AbstractController{

	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

	private CategoryService categoryService;
	private String viewName;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		LOGGER.info("In CategoryController...view name: " + getViewName());
		ModelAndView mav = new ModelAndView(getViewName());

		List<Category> categories = categoryService.getCategories();
		mav.addObject("categories", categories);
		mav.addObject("categoriesSize", categories.size());

		return mav;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	
}
