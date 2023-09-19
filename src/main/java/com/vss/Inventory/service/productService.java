package com.vss.Inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.vss.Inventory.Dao.productDao;
import com.vss.Inventory.model.Product;

@Service
public class productService {
	@Autowired
	productDao pdao;
	public ResponseEntity<List<Product>> getallprodcts() {
		// TODO Auto-generated method stub
		List<Product> result=pdao.findAll();
		if(result.isEmpty()) {
			return  new ResponseEntity<>(result,HttpStatus.NOT_FOUND);	
		}
		return  new ResponseEntity<>(result,HttpStatus.OK);	
		
	}
	public ResponseEntity<String> addproducts(List<Product> products) {
		// TODO Auto-generated method stub
		pdao.saveAll(products);
		return new ResponseEntity<>("Added "+ products.size()+ " products",HttpStatus.OK);
	}
	public ResponseEntity<Product> findproductsbyname(String productName)  {
		// TODO Auto-generated method stub
		
		 Product result = pdao.findByproductName(productName);
		 if(result==null) 
		 {
			 	return new ResponseEntity<>( result,HttpStatus.NOT_FOUND);
			 
		 }
		 	return new ResponseEntity<>( result,HttpStatus.OK);
	}
	public String updateproducts(List<Product> products) {
		// TODO Auto-generated method stub
		pdao.saveAll(products);
		
		return "Updated "+ products.size()+ " products";
	}
	
	public ResponseEntity<String> deleteproducts(List<String> productName) {
		// TODO Auto-generated method stub
		boolean isempty=false;
		List<String> res=new ArrayList<String>();
		for(String i:productName) {
	  if(findproductsbyname(i).getBody()==null) {
		  isempty=true;
		  
	  }
	  else {
				pdao.delete( findproductsbyname(i).getBody());
				isempty=false;
	  }
			
		}
		if(isempty==true) {
			return new ResponseEntity<>("Product Not Found",HttpStatus.NOT_FOUND);
		}
	//	System.out.println(res);
		 return new ResponseEntity<>("Product Deleted",HttpStatus.OK);
		
		
		}
		
	}
	
	
	
	

