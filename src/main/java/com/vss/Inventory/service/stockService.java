package com.vss.Inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vss.Inventory.Dao.productDao;
import com.vss.Inventory.Dao.stockDao;
import com.vss.Inventory.model.Product;

@Service
public class stockService {
	@Autowired	
	stockDao stodao;
	@Autowired
	productDao prodao;
	
	public int getquantity(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> product = prodao.findById(productId);
	System.out.println(product.get().getStock().getQuantity());
		return	product.get().getStock().getQuantity();
		
		
	}
	
	
}
