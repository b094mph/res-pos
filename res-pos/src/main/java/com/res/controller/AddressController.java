package com.res.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.res.model.Address;
import com.res.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/address")
    public String listAddresses(Map<String, Object> map) {
 
        map.put("address", new Address());
 
        return "address";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("address") Address address, BindingResult result){
		addressService.save(address);
		return "redirect:/index";
	}
	
	@RequestMapping("/find/{addressId}")
	public String findByAddressId(@PathVariable("addressId") Integer addressId){
		addressService.findByAddressId(addressId);
		return "redirect:/index";
	}
}
