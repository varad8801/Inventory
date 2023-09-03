package com.vss.Inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vss.Inventory.Dao.ordererDao;
import com.vss.Inventory.Dao.productDao;
import com.vss.Inventory.model.Invoice;
import com.vss.Inventory.model.Order;
import com.vss.Inventory.model.Orderer;
import com.vss.Inventory.model.OrdererAddress;
import com.vss.Inventory.model.Payment;
import com.vss.Inventory.model.Product;
import com.vss.Inventory.model.Wrapper.OrdererWrapper;
import com.vss.Inventory.model.Wrapper.PaymentWrapper;
import com.vss.Inventory.model.Wrapper.ProductWrapper;

@Service
public class orderService {
	
	
	java.util.Date date = new java.util.Date(); 
	@Autowired
	orderDao orderdao;
	@Autowired
	ordererDao ordererdao;
	@Autowired
	productDao productdao;
	public Optional<Order> getOrderByorderId(int orderId) {
		// TODO Auto-generated method stub
		
		return  orderdao.findById(orderId);
	}
	public String createOrderer(Order order) {
		// TODO Auto-generated method stub
		orderdao.save(order);
		return "Order Created";
	}
	public String createOrder(int ordererId, String orderName, Payment payment, List<Integer> productId) {
		// TODO Auto-generated method stub
		
		Order order=new Order();
		//Invoice invoice=new Invoice();
		
	//System.out.println(	ordererdao.findById(ordererId).get());
		order.setOrderer(ordererdao.findById(ordererId).get());
		
		
		order.setOrderDate(date);
		order.setOrderName(orderName);
		List<Product>products=productdao.findAllById(productId);
		order.setProduct(products);
		
		System.out.println(productdao.findAllById(productId));
		order.setPayment(payment);
		System.out.println(order);
		orderdao.save(order);
		return orderName+" Created";
	}
	public List<Order> getallorders() {
		// TODO Auto-generated method stub
		return orderdao.findAll();
		
	}
	public String update(Order order) {
		// TODO Auto-generated method stub
		orderdao.save(order);
		return "Updated"+order.getOrderName();
	}
	public String deleteorder(int orderId) {
		// TODO Auto-generated method stub
		Order order=orderdao.findById(orderId).get();
		orderdao.delete(order);
		return "Deleted "+order.getOrderName();
	}
	
	
	
	

	
	
	
	
}
