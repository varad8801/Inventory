package com.vss.Inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vss.Inventory.Dao.productDao;
import com.vss.Inventory.model.Product;

@Service
public class productService {
	@Autowired
	productDao pdao;
	public List<Product> getallprodcts() {
		// TODO Auto-generated method stub
		return pdao.findAll();	
		
	}
	public String addproducts(List<Product> products) {
		// TODO Auto-generated method stub
		pdao.saveAll(products);
		return "Added "+ products.size()+ " products";
	}
	public Product findproductsbyname(String productName) {
		// TODO Auto-generated method stub
		
		 
		 	return pdao.findByproductName(productName);
	}
	public String updateproducts(List<Product> products) {
		// TODO Auto-generated method stub
		pdao.saveAll(products);
		
		return "Updated "+ products.size()+ " products";
	}
	
	public String deleteproducts(List<String> productName) {
		// TODO Auto-generated method stub
		boolean isempty=false;
		List<String> res=new ArrayList<String>();
		for(String i:productName) {
			if(findproductsbyname(i)==null) {
				isempty=true;
				res.add(i+" Notfound");
			}
			else
			{
				pdao.delete(findproductsbyname(i));
				isempty=false;
				res.add(i+" Deleted");
			}
		}
		
	//	System.out.println(res);
		return res.toString();
		
		
		}
		
	}
	
	
	
	

