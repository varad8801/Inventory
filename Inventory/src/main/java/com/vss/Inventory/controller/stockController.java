package com.vss.Inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vss.Inventory.model.Product;
import com.vss.Inventory.service.stockService;

@RestController
@RequestMapping("stock")
public class stockController
{	@Autowired
	stockService stoser;
	@GetMapping("getquantity")
	public int getquantity(@RequestParam int productId ) {
		return stoser.getquantity(productId);
	}

}
