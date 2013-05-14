package com.res.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.OrderDetail;
import com.res.service.OrderService;

@Controller
@SessionAttributes
public class OrderAjaxController {

	private static Logger logger = Logger.getLogger(OrderAjaxController.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/showOrder", method=RequestMethod.GET)
	public ModelAndView showOrderList(){
		ModelAndView mav = new ModelAndView("showOrder");
		
		logger.info("hitting showOrderList controller...");
		long customerOrderId = 1L;
//		orderService.listOrder(customerOrderId);
		return mav;
	}
	
	@RequestMapping(value="/addOrder.json", method=RequestMethod.GET)
	public String addOrder(HttpServletRequest req, HttpServletResponse res){
		
		String menuId = req.getParameter("menuId");
		logger.info("hitting addOrder controller with menuId " + menuId);
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setMenuId(Long.parseLong(menuId));
		orderDetail.setQuantity(1); //TODO: hard coded for now.
//		orderService.addOrder(orderDetail);
		
		return "redirect:/showOrder.html";
	}
}
