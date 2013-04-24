package com.res.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Person;

@Controller
@SessionAttributes
public class CustomerController {

	private static Logger logger = Logger.getLogger("CustomerController.class");
	
	@RequestMapping("/showCustomerForm")
	public ModelAndView showCustomerForm(){
		logger.info("in showCustomerForm() method...");
		Person customer = new Person();
		return new ModelAndView("customer", "command", customer);
	}
}
