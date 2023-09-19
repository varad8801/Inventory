package com.vss.Inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vss.Inventory.model.Product;
import com.vss.Inventory.service.productService;
@RestController
@RequestMapping("products")
public class productController 
{
	@Autowired
	productService pservice;
	@GetMapping("getallProducts")
	@ResponseBody
	public ResponseEntity<List<Product>> getallproducts() {
		return pservice.getallprodcts();
	}
	
	@PostMapping("addProducts")
	public ResponseEntity<String> addproducts(@RequestBody List<Product>products) {
		return pservice.addproducts(products);
	}
	
	@GetMapping("findProductsByName")
	public ResponseEntity<Product> findproductsbyname(@RequestParam String productName){
		return pservice.findproductsbyname(productName);
	}
	
	@PutMapping("updateProducts")
	public String updateproducts(@RequestBody List<Product>products) {
		return pservice.updateproducts(products);
	}
	
	@DeleteMapping("deleteProducts")
	public ResponseEntity<String> deleteproducts(@RequestParam List<String> productName ) {
		return pservice.deleteproducts(productName);
		//return null;
	}
	
}
