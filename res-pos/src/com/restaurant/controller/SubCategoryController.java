package com.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.restaurant.model.SubCategory;
import com.restaurant.service.SubCategoryService;

public class SubCategoryController extends AbstractController {

	private static final Logger LOGGER = Logger.getLogger(SubCategoryController.class);
	
	private SubCategoryService subCategoryService;
	private String viewName;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		String categoryId = req.getParameter("categoryId");
		LOGGER.info("id retrieved is: " + categoryId);
		ModelAndView mav = new ModelAndView(getViewName());
		List<SubCategory> subCategories = subCategoryService.getSubCategoriesByCategoryId(categoryId);
		mav.addObject("subCategories", subCategories);
		mav.addObject("subCategoriesSize", subCategories.size());
		return mav;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public void setSubCategoryService(SubCategoryService subCategoryService) {
		this.subCategoryService = subCategoryService;
	}

}
