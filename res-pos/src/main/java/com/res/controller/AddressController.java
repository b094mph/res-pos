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

import com.res.exception.ServiceException;
import com.res.model.Address;
import com.res.service.AddressService;

@Controller
@SessionAttributes
public class AddressController {
	
	private static Logger logger = Logger.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/addressForm")
    public ModelAndView addressForm() {
		ModelAndView mav = new ModelAndView("address");
		mav.addObject("command", new Address());
		mav.addObject("addressList", addressService.listAddress());
        return mav;
    }
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.GET)
	public String addAddress(@ModelAttribute("address") Address address, BindingResult result) 
			throws ServiceException{
		logger.info("Address = " + address.getStreet1() + " " +  address.getStreet2() +
				" " + address.getCity() + " " + address.getState() + " " + address.getZipCode());
		addressService.save(address);
		return "redirect:/addressForm.html";
	}
	
	@RequestMapping("/deleteAddress/{addressId}")
	public String deleteAddress(@PathVariable("addressId") long id){
		addressService.deleteAddress(id);
		return "redirect:/addressForm.html";
	}
	
//	@RequestMapping("/find/{addressId}")
//	public String findByAddressId(@PathVariable("addressId") Integer addressId){
//		addressService.findByAddressId(addressId);
//		return "redirect:/addressForm.html";
//	}
}
