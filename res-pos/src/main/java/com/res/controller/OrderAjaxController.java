package com.res.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.constant.ResConstant;
import com.res.domain.Address;
import com.res.domain.CustomerOrder;
import com.res.domain.Menu;
import com.res.domain.ModifyTaste;
import com.res.domain.OrderDetail;
import com.res.domain.Person;
import com.res.domain.Restaurant;
import com.res.exception.ServiceException;
import com.res.service.AddressService;
import com.res.service.CustomerOrderService;
import com.res.service.CustomerService;
import com.res.service.MenuService;
import com.res.service.OrderService;
import com.res.service.RestaurantService;
import com.res.util.LogUtils;
import com.res.util.MessageLoader;
import com.res.util.Price;

@Controller
@SessionAttributes
@Scope(value="session")
public class OrderAjaxController {

	private static Logger logger = Logger.getLogger(OrderAjaxController.class);
	
	@Autowired 
	private OrderService orderService;
	
	@Autowired 
	private MenuService menuService;
	
	@Autowired 
	private RestaurantService restaurantService;
	
	@Autowired 
	private AddressService addressService;
	
	@Autowired 
	private CustomerService customerService;
	
	@Autowired 
	private MessageLoader messageLoader;
	
	@Autowired
	private CustomerOrderService customerOrderService;
	
	private List<OrderDetail> orderList = new LinkedList<OrderDetail>();
	private BigDecimal subTotal;
	private BigDecimal tax;
	private BigDecimal grandTotal;
	
	@RequestMapping(value="/showOrder", method=RequestMethod.GET)
	public ModelAndView showOrderList(HttpServletRequest request) 
			throws ServiceException{
		LogUtils.initLog(request);
		HttpSession session = request.getSession();
		Long restaurantId = (Long) session.getAttribute("restaurantId");
		
		if(restaurantId == null){
			throw new ServiceException(messageLoader.getMessage("restaurantid.not.set"));
		}
		ModelAndView mav = new ModelAndView("showOrder");

		mav.addObject("lang", session.getAttribute("lang"));
		mav.addObject("orderList", orderList);
		mav.addObject("orderListSize", orderList.size());
		mav.addObject("rowIndex", session.getAttribute("rowIndex"));
		mav.addObject("lastRow", session.getAttribute("lastRow"));
		
		Restaurant res = restaurantService.getResturantInfo(restaurantId);
		BigDecimal tax = res.getTax();	
		
		mav.addObject("salesTax", orderService.computeSalesTax(tax));
		
		if(!orderList.isEmpty()){
			BigDecimal subTotal = orderService.computeSubtotal(orderList);
			BigDecimal calcTax = orderService.computeTotalTax(subTotal, tax); 
			BigDecimal grandTotal = orderService.computeGrandTotal(subTotal, calcTax);
			
			this.setSubTotal(subTotal);
			this.setTax(calcTax);
			
			mav.addObject("subTotal", orderService.roundTotal(subTotal));
			mav.addObject("tax", calcTax);
			
			if(res.getRounding()){
				logger.info(res.getRestaurantName() + " rounds to nearest nickel.");
				grandTotal = Price.roundToNearestNickel(grandTotal);
			}else{
				logger.info(res.getRestaurantName() + " does not round to nearest nickel.");
				grandTotal = orderService.roundTotal(grandTotal);
			}
			this.setGrandTotal(grandTotal);
			mav.addObject("grandTotal", grandTotal);
		}

		return mav;
	}
	
	@RequestMapping(value="/addToOrder.json", method=RequestMethod.GET)
	public String addToOrder(HttpServletRequest request, 
			@RequestParam("menuId") long menuId,
			@RequestParam(value="foodLegend", defaultValue="") String foodLegend,
			@RequestParam(value="modifyTasteId", defaultValue="0") long modifyTasteId,
			@RequestParam(value="rowIndex", defaultValue="0") int rowIndex,
			@RequestParam(value="lastRow", defaultValue="true") boolean lastRow){
		
		LogUtils.initLog(request);
		HttpSession session = request.getSession();
		session.setAttribute("lastRow", lastRow);
		session.setAttribute("rowIndex", rowIndex);
		
		logger.info("hitting addOrder controller with menuId " + menuId);
		Menu menu = menuService.getMenuByMenuId(menuId);
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setQuantity(1);
		orderDetail.setMenu(menu);
		
		BigDecimal price = null;
		
		String foodCategory = menu.getFoodCategory().getFoodCategoryName().toLowerCase();
		
		// determines if lunch is the only size or combo is the only size, otherwise, set to large
		if(foodLegend.toLowerCase().startsWith("comb") || foodCategory.startsWith("comb")){
			orderDetail.setSize(ResConstant.COMBO);
			price = menu.getCombo().multiply(new BigDecimal(orderDetail.getQuantity()));
		}else if(foodLegend.toLowerCase().startsWith("lunch") || foodCategory.startsWith("lunch")){
			orderDetail.setSize(ResConstant.LUNCH);
			price = menu.getLunch().multiply(new BigDecimal(orderDetail.getQuantity()));
		}else{ // default is Large
			orderDetail.setSize(ResConstant.LARGE);
			price = menu.getLarge().multiply(new BigDecimal(orderDetail.getQuantity()));
		}
		
		ModifyTaste modifyTaste = null;
		if(modifyTasteId != 0){
			modifyTaste = menuService.getTasteModifier(modifyTasteId);
			orderDetail.setModifyTaste(modifyTaste);
		}
		
		if(modifyTaste == null || ResConstant.ADD.equalsIgnoreCase(modifyTaste.getModifyTasteName())){
			orderDetail.setPrice(price.setScale(ResConstant.SCALE));
		}else{ //ignore price for taste modifiers (NO, LESS, WITH, ONLY, WANT )
			orderDetail.setPrice(BigDecimal.ZERO.setScale(ResConstant.SCALE));
		}
		
		if(lastRow){
			orderList.add(orderDetail);
		}else{
			orderList.add(rowIndex+1, orderDetail);
		}
			
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/changeSize.json", method=RequestMethod.GET)
	public String changeSize(HttpServletRequest request, 
			@RequestParam(value="rowIndex", defaultValue="0") int rowIndex,
			@RequestParam("size") String size){
		LogUtils.initLog(request);
		HttpSession session = request.getSession();
		
		OrderDetail orderDetail = orderList.get(rowIndex);
		session.setAttribute("rowIndex", rowIndex);
		session.setAttribute("lastRow", false);
		
		if(ResConstant.SMALL.equals(size)){
			orderDetail.setSize(ResConstant.SMALL);
		}else if(ResConstant.LARGE.equals(size)){
			orderDetail.setSize(ResConstant.LARGE);
		}else if(ResConstant.COMBO.equals(size)){
			orderDetail.setSize(ResConstant.COMBO);
		}else if(ResConstant.LUNCH.equals(size)){
			orderDetail.setSize(ResConstant.LUNCH);
		}
		
		BigDecimal price = orderService.calculatePrice(orderDetail);
		orderDetail.setPrice(price);
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/deleteItem.json", method=RequestMethod.GET)
	public String deleteItem(HttpServletRequest request, @RequestParam("rowIndex") int rowIndex)
			throws NumberFormatException{
		LogUtils.initLog(request);
		try{
			logger.info("removing orderList with " + rowIndex);
			orderList.remove(rowIndex);
		}catch(Exception e){
			throw new NumberFormatException(messageLoader.getMessage("is.not.a.number"));
		}
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/increaseQty.json", method=RequestMethod.GET)
	public String increaseQty(HttpServletRequest request, 
			@RequestParam(value="rowIndex", defaultValue="0") int rowIndex)
			throws NumberFormatException{
		LogUtils.initLog(request);
		HttpSession session = request.getSession();

		try{
			logger.info("increasing qty for item");
			
			OrderDetail orderDetail = orderList.get(rowIndex);
			orderDetail.setQuantity(orderDetail.getQuantity() + 1);
			
			BigDecimal price = orderService.calculatePrice(orderDetail);
			orderDetail.setPrice(price);
			
			session.setAttribute("rowIndex", rowIndex);
			session.setAttribute("lastRow", false);
		}catch(Exception e){
			throw new NumberFormatException(messageLoader.getMessage("is.not.a.number"));
		}
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/decreaseQty.json", method=RequestMethod.GET)
	public String decreaseQty(HttpServletRequest request, 
			@RequestParam(value="rowIndex", defaultValue="0") int rowIndex)
			throws NumberFormatException{
		LogUtils.initLog(request);
		HttpSession session = request.getSession();
		
		try{
			logger.info("decreasing qty for item");
			OrderDetail orderDetail = orderList.get(rowIndex);
			int quantity = orderDetail.getQuantity();
			
			if(quantity > 1){
				orderDetail.setQuantity(quantity - 1);

				BigDecimal price = orderService.calculatePrice(orderDetail);
				orderDetail.setPrice(price);
				
				session.setAttribute("rowIndex", rowIndex);
				session.setAttribute("lastRow", false);
			}else{
				logger.info("subtracting quantity of 1, therefore deleting item.");
				orderList.remove(rowIndex);
			}
		}catch(Exception e){
			throw new NumberFormatException(messageLoader.getMessage("is.not.a.number"));
		}
		
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/newOrder.json", method=RequestMethod.GET)
	public String newOrder(HttpServletRequest request){
		LogUtils.initLog(request);
		logger.info("clearing the order and customer information...");
		orderList.clear();
		return "redirect:/showOrder.html";
	}
	
	@RequestMapping(value="/voidOrder.json", method=RequestMethod.GET)
	public String voidOrder(HttpServletRequest request){
		LogUtils.initLog(request);
		logger.info("deleting order...");
		orderList.clear();
		return "welcome";
	}
	
	@RequestMapping(value="/saveOrder.json", method=RequestMethod.GET)
	public String saveOrder(HttpServletRequest request) 
			throws ServiceException{
		LogUtils.initLog(request);
		HttpSession session = request.getSession();
		String agentName = (String)session.getAttribute("agentName");
		Long restaurantId = (Long) session.getAttribute("restaurantId");
		
		String orderType = StringUtils.trimToNull(request.getParameter("orderType"));
		if(orderType == null){
			throw new ServiceException(messageLoader.getMessage("orderType.is.null"));
		}
		
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setRestaurantId(restaurantId);
		
		//TODO: if address or person info already exists in database, use that id and dont save into database.
		if(ResConstant.PICK_UP.equals(orderType) || ResConstant.DELIVERY.equals(orderType)){
			Person customer = new Person();
			customer.setFirstName(StringUtils.trimToNull(request.getParameter("customer[firstName]")));
			customer.setLastName(StringUtils.trimToNull(request.getParameter("customer[lastName]")));
			customer.setPhone1(StringUtils.trimToNull(request.getParameter("customer[phone1]")));
			customer.setPhone2(StringUtils.trimToNull(request.getParameter("customer[phone2]")));
			customer.setExt(StringUtils.trimToNull(request.getParameter("customer[ext]")));
			customer.setEmail(StringUtils.trimToNull(request.getParameter("customer[email]")));
			customer.setNote(StringUtils.trimToNull(request.getParameter("customer[note]")));
			customer.setLastUpdatedBy(agentName);
			
			if(ResConstant.DELIVERY.equals(orderType)){
				Address address = new Address();
				address.setStreet1(StringUtils.trimToNull(request.getParameter("address[street1]")));
				address.setStreet2(StringUtils.trimToNull(request.getParameter("address[street2]")));
				address.setCity(StringUtils.trimToNull(request.getParameter("address[city]")));
				address.setState(StringUtils.trimToNull(request.getParameter("address[state]")));
				address.setZipCode(StringUtils.trimToNull(request.getParameter("address[zipCode]")));
				addressService.save(address);
				customer.setAddress(address);
			}
			
			customerService.save(customer);
			customerOrder.setCustomer(customer);
		}

		customerOrder.setUsername(agentName);
		customerOrder.setOrderOption(orderType);
		customerOrder.setOrderTime(new Date());
		customerOrder.setSubTotal(this.getSubTotal());
		customerOrder.setTax(this.getTax());
		customerOrder.setGrandTotal(this.getGrandTotal());
		customerOrder.setOrderStatus(ResConstant.PENDING);
		customerOrder.setOrderNum(customerOrderService.findLastOrderNumber(restaurantId, new LocalDate().toString()));
		
		for(OrderDetail orderDetail : orderList){
			orderDetail.setCustomerOrder(customerOrder);
		}
		
		orderService.saveOrder(customerOrder, orderList);
		orderList.clear();
		
		return "welcome";
	}
	
	@RequestMapping(value="/editOrder", method=RequestMethod.GET)
	public ModelAndView editOrder(HttpServletRequest request,
			@RequestParam(value="restaurantId", required=true) Long restaurantId,
			@RequestParam(value="requestDate", required=true) String requestDate,
			@RequestParam(value="orderNum", required=true) Integer orderNum){
		LogUtils.initLog(request);
		ModelAndView mav = new ModelAndView("menu");
		List<OrderDetail> odList = customerOrderService.editOrderDetails(restaurantId, requestDate, orderNum);
		for(OrderDetail od : odList){
			this.orderList.add(od);
		}
		
		logger.debug("Editing order # " + this.orderList.get(0).getCustomerOrder().getOrderNum());
		mav.addObject("orderDetailsList", this.orderList);
		return mav;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

}
