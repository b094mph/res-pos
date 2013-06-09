package com.res.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExtrasAjaxController {

	private static Logger logger = Logger.getLogger(ExtrasAjaxController.class);
	
	@RequestMapping(value="/extrasOption.json", method=RequestMethod.GET)
	public ModelAndView showVeg(HttpServletRequest request,
			@RequestParam("extrasOption") String option){
		
		logger.info("Extra option = " + option);
		ModelAndView mav = new ModelAndView("extras");
		
		return mav;
	}
}
