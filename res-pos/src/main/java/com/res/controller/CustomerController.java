package com.res.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Person;
import com.res.service.CustomerService;

@Controller
@SessionAttributes
public class CustomerController {

	private static Logger logger = Logger.getLogger("CustomerController.class");
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/showCustomerForm")
	public ModelAndView showCustomerForm(){
		logger.info("in showCustomerForm() method...");
		Person customer = new Person();
		return new ModelAndView("customer", "command", customer);
	}
	
	@RequestMapping(value= "addCustomer", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Person customer, BindingResult result){
		logger.info("Customer = " +  customer.getFirstName() + " " + customer.getLastName() + " " +
				customer.getPhone1() + " " + customer.getPhone2() + " " + customer.getEmail());
		customerService.save(customer);
		return "redirect:/showCustomerForm.html";
	}
	
	@RequestMapping("/listCustomers")
	public String listCustomers(Map<String, Object> map){
		logger.info("in listCustomers() method...");
		map.put("customer", new Person());
		map.put("customerList", customerService.listCustomers());
		return "redirect:/showCustomerForm.html";
	}
}
