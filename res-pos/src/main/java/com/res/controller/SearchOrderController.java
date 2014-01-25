package com.res.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.res.service.CustomerOrderService;
import com.res.util.LogUtils;

@Controller
public class SearchOrderController {

	private static Logger logger = Logger.getLogger(SearchOrderController.class);
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping(value="/searchOrders", method=RequestMethod.GET)
	public ModelAndView searchOrders(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId){
			
		LogUtils.initLog(request);
		MDC.put("restaurantId", restaurantId.toString());
		logger.info("searchOrders");
		
		ModelAndView mav = new ModelAndView("searchOrders");
		mav.addObject("restaurantId", restaurantId);
		return mav;
	}
	
	@RequestMapping(value="/viewOrdersDesc.json", method=RequestMethod.GET)
	public ModelAndView searchByOrdersDesc(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId,
			@RequestParam(value="requestDate", required=true) String requestDate){
		
		LogUtils.initLog(request);
		MDC.put("restaurantId", restaurantId);
		MDC.put("requestDate", requestDate);
		
		ModelAndView mav = new ModelAndView("viewOrdersDesc");
		
		mav.addObject("orderList", customerOrderService.searchByOrdersDesc(restaurantId, requestDate));
		return mav;
	}
}
