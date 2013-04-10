package com.res.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.res.model.Address;
import com.res.service.AddressService;

@Controller
@SessionAttributes
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/address")
    public ModelAndView listAddresses() {
		System.out.println("in listAddress...");
        return new ModelAndView("address", "command", new Address());
    }
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("address") Address address, BindingResult result){
		System.out.println("Street1 = " + address.getStreet1());
		System.out.println("City = " + address.getCity());
		System.out.println("State = " + address.getState());
		addressService.save(address);
		return "redirect:/address.html";
	}
	
//	@RequestMapping("/find/{addressId}")
//	public String findByAddressId(@PathVariable("addressId") Integer addressId){
//		addressService.findByAddressId(addressId);
//		return "redirect:/index";
//	}
}
