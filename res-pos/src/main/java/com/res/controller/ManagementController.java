package com.res.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.res.domain.CustomerOrder;
import com.res.service.CustomerOrderService;

@Controller
public class ManagementController {

	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping(value="/management", method=RequestMethod.GET)
	public ModelAndView viewManagement(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId){
		
		ModelAndView mav = new ModelAndView("management");
		mav.addObject("restaurantId", restaurantId);
		return mav;
	}
	
	@RequestMapping(value="/viewTotalOrder.json", method=RequestMethod.GET)
	public ModelAndView viewTotalOrderByDelivery(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId,
			@RequestParam(value="orderType", required=true) String orderType,
			@RequestParam(value="requestDate", required=true) String requestDate){
		
		ModelAndView mav = new ModelAndView("viewTotalOrder");
		List<CustomerOrder> orderList = customerOrderService.dailyTotalOrder(restaurantId, orderType, requestDate);
	
		mav.addObject("orderList", orderList );
		mav.addObject("total", customerOrderService.managementDailyTotal(orderList));
		
		return mav;
	}
}
