package com.res.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.slf4j.MDC;
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
	
	private static Logger logger = Logger.getLogger(ManagementController.class);

	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping(value="/management", method=RequestMethod.GET)
	public ModelAndView viewManagement(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId){
		
		MDC.clear();
		MDC.put("restaurantId", restaurantId.toString());
		logger.info("viewManagement");
		
		ModelAndView mav = new ModelAndView("management");
		mav.addObject("restaurantId", restaurantId);
		return mav;
	}
	
	@RequestMapping(value="/viewTotalOrder.json", method=RequestMethod.GET)
	public ModelAndView viewTotalOrderByDelivery(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId,
			@RequestParam(value="orderType", required=true) String orderType,
			@RequestParam(value="requestDate", required=true) String requestDate){
		
		MDC.clear();
		MDC.put("restaurantId", restaurantId.toString());
		MDC.put("orderType", orderType);
		MDC.put("requestDate", requestDate);
		
		ModelAndView mav = new ModelAndView("viewTotalOrder");
		List<CustomerOrder> orderList = customerOrderService.dailyTotalOrder(restaurantId, orderType, requestDate);
	
		logger.info("orderList size = " + orderList.size());
		mav.addObject("orderList", orderList );
		mav.addObject("total", customerOrderService.managementDailyTotal(orderList));
		
		return mav;
	}
}
