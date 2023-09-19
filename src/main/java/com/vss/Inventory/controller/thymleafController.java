package com.vss.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vss.Inventory.service.productService;

@Controller
public class thymleafController {
	@Autowired
	productService proser;
	@GetMapping("/showproducts")
	public String getproducts(Model model) {
		model.addAttribute("products",proser.getallprodcts() );
		return "showproducts";
	}
	@GetMapping("/ProductsDetails")
	public String ProductDetails() {
		return "productdetails";
	}
	
	@GetMapping("/showorders")
	public String getOrders() {
		return "showorders";
	}
}
