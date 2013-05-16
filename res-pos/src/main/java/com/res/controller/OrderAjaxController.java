package com.res.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.constant.ResConstant;
import com.res.model.Menu;
import com.res.model.OrderDetail;
import com.res.service.MenuService;
import com.res.service.OrderService;
import com.res.util.MessageLoader;
import com.res.util.Price;

@Controller
@SessionAttributes
public class OrderAjaxController {

	private static Logger logger = Logger.getLogger(OrderAjaxController.class);
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MessageLoader messages;
	
	private List<OrderDetail> orderList = new ArrayList<OrderDetail>();
	
	@RequestMapping(value="/showOrder", method=RequestMethod.GET)
	public ModelAndView showOrderList(){
		ModelAndView mav = new ModelAndView("showOrder");
		
		logger.info("hitting showOrderList controller...");
		mav.addObject("orderList", orderList);
		mav.addObject("orderListSize", orderList.size());
		
		BigDecimal subTotal = new BigDecimal(0.00);
		BigDecimal tax = new BigDecimal(0.08);
		BigDecimal grandTotal = new BigDecimal(0.00);
		
		mav.addObject("tax", tax.setScale(ResConstant.SCALE,RoundingMode.HALF_UP));
		
		if(!orderList.isEmpty()){
			for(OrderDetail orderDetail : orderList){
				subTotal = subTotal.add(orderDetail.getPrice());
			}
			
			grandTotal = subTotal.add(subTotal.multiply(tax));
		}
		mav.addObject("subTotal", Price.roundToNearestNickel(subTotal));
		mav.addObject("grandTotal", Price.roundToNearestNickel(grandTotal));
		
		return mav;
	}
	
	@RequestMapping(value="/addToOrder.json", method=RequestMethod.GET)
	public String addToOrder(HttpServletRequest req, HttpServletResponse res){
		
		String menuId = req.getParameter("menuId");
		logger.info("hitting addOrder controller with menuId " + menuId);
		Menu menu = menuService.getMenuByMenuId(Long.parseLong(menuId));
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setMenuId(menu.getMenuId());
		orderDetail.setQuantity(1); //TODO: hard coded for now.
		orderDetail.setMenu(menu);
		orderDetail.setCustomerOrderId(1L);
		
		BigDecimal price = orderDetail.getMenu().getLarge().multiply(new BigDecimal(orderDetail.getQuantity()));
		orderDetail.setPrice(price.setScale(ResConstant.SCALE));
		
		orderList.add(orderDetail);
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/deleteItem.json", method=RequestMethod.GET)
	public String deleteItem(HttpServletRequest req, HttpServletResponse res)
			throws NumberFormatException{
		String idx = req.getParameter("idx");
		try{
			int index = Integer.parseInt(idx);
			logger.info("removing orderList with " + idx);
			orderList.remove(index);
		}catch(Exception e){
			throw new NumberFormatException(messages.getMessage("is.not.a.number"));
		}
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/increaseQty.json", method=RequestMethod.GET)
	public String increaseQty(HttpServletRequest req, HttpServletResponse res)
			throws NumberFormatException{
		String idx = req.getParameter("idx");
		try{
			int index = Integer.parseInt(idx);
			logger.info("increasing qty for item");
			OrderDetail orderDetail = orderList.get(index);
			orderDetail.setQuantity(orderDetail.getQuantity() + 1);
			
			BigDecimal price = orderDetail.getMenu().getLarge().multiply(new BigDecimal(orderDetail.getQuantity()));
			orderDetail.setPrice(price.setScale(ResConstant.SCALE));
		}catch(Exception e){
			throw new NumberFormatException(messages.getMessage("is.not.a.number"));
		}
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/decreaseQty.json", method=RequestMethod.GET)
	public String decreaseQty(HttpServletRequest req, HttpServletResponse res)
			throws NumberFormatException{
		String idx = req.getParameter("idx");
		try{
			int index  = Integer.parseInt(idx);
			logger.info("decreasing qty for item");
			OrderDetail orderDetail = orderList.get(index);
			int quantity = orderDetail.getQuantity();
			
			if(quantity > 1){
				orderDetail.setQuantity(quantity - 1);
				BigDecimal price = orderDetail.getMenu().getLarge().multiply(new BigDecimal(orderDetail.getQuantity()));
				orderDetail.setPrice(price.setScale(ResConstant.SCALE));
			}else{
				logger.info("subtracting quantity of 1, therefore deleting item.");
				orderList.remove(index);
			}
		}catch(Exception e){
			throw new NumberFormatException(messages.getMessage("is.not.a.number"));
		}
			
		return "redirect:/showOrder.html";
	}

}
