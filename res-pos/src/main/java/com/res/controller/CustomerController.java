package com.res.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.domain.Person;
import com.res.service.CustomerService;

@Controller
@SessionAttributes
public class CustomerController {

	private static Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customerForm")
	public ModelAndView customerForm(){
		logger.debug("in showCustomerForm() method...");
		ModelAndView mav = new ModelAndView("customer");
		
		Person customer = new Person();
		mav.addObject("command", customer);
		mav.addObject("customerList", customerService.listCustomers());
		
		return mav;
	}
	
	@RequestMapping(value= "addCustomer", method=RequestMethod.GET)
	public String addCustomer(@ModelAttribute("customer") Person customer, BindingResult result){
		logger.debug("Customer = " +  customer.getFirstName() + " " + customer.getLastName() + " " +
				customer.getPhone1() + " " + customer.getPhone2() + " " + customer.getEmail());
		customerService.saveOrUpdate(customer);
		return "redirect:/customerForm.html";
	}
	
	@RequestMapping(value="deleteCustomer/{customerId}", method=RequestMethod.GET)
	public String deleteCustomer(@PathVariable("customerId") long id){
		customerService.deleteCustomer(id);
		return "redirect:/customerForm.html";
	}
}
