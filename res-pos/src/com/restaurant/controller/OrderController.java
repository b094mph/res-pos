package com.restaurant.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.restaurant.model.Customer;
import com.restaurant.service.OrderService;

@Controller
@RequestMapping("/order.json")
@SessionAttributes("customer")
public class OrderController{
	
	private static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showOrderForm(HttpServletRequest req, ModelMap model){
		String id = req.getParameter("id");
		LOGGER.info("OrderController >>> " + id);
		model.addAttribute("item", orderService.getSubCategoryById(id));

		return "orderJson";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("customer") Customer customer, BindingResult bindingResult){
		LOGGER.info("OrderController >>> in onSubmit");
		if(bindingResult.hasErrors()){
			LOGGER.error("Error binding result from from...");
		}
		orderService.add(customer);
		return "redirect:orderSuccess.html";
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
}
