package com.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderSuccessController {
	
	@RequestMapping("/orderSuccess.html")
	public String redirect(){
		return "orderSuccess";
	}
	
}
