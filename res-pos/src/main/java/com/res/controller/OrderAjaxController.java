package com.res.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Menu;
import com.res.model.OrderDetail;
import com.res.service.MenuService;
import com.res.service.OrderService;
import com.res.util.MessageLoader;

@Controller
@SessionAttributes
public class OrderAjaxController {

	private static Logger logger = Logger.getLogger(OrderAjaxController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	MessageLoader messages;
	
	public List<OrderDetail> orderList = new ArrayList<OrderDetail>();
	
	@RequestMapping(value="/showOrder", method=RequestMethod.GET)
	public ModelAndView showOrderList(){
		ModelAndView mav = new ModelAndView("showOrder");
		
		logger.info("hitting showOrderList controller...");
		mav.addObject("orderList", orderList);
		mav.addObject("orderListSize", orderList.size());
		return mav;
	}
	
	@RequestMapping(value="/addToOrder.json", method=RequestMethod.GET)
	public String addOrder(HttpServletRequest req, HttpServletResponse res){
		
		String menuId = req.getParameter("menuId");
		logger.info("hitting addOrder controller with menuId " + menuId);
		Menu menu = menuService.getMenuByMenuId(Long.parseLong(menuId));
		
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setMenuId(menu.getMenuId());
		orderDetail.setQuantity(1); //TODO: hard coded for now.
		orderDetail.setMenu(menu);
		orderDetail.setCustomerOrderId(1L);
		orderDetail.setQuantity(1);
		
		orderList.add(orderDetail);
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/deleteItem.json", method=RequestMethod.GET)
	public String deleteItem(HttpServletRequest req, HttpServletResponse res)
			throws NumberFormatException{
		String idx = req.getParameter("idx");
		if(StringUtils.isNumeric(idx)){
			int index = Integer.parseInt(idx);
			logger.info("removing orderList with " + idx);
			orderList.remove(index);
		}else{
			throw new NumberFormatException(messages.getMessage("is.not.a.number"));
		}
		
		return "redirect:/showOrder.html";
	}
}
