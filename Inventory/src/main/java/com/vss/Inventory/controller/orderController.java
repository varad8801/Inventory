package com.vss.Inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vss.Inventory.model.Invoice;

import com.vss.Inventory.model.Order;
import com.vss.Inventory.model.Payment;
import com.vss.Inventory.service.orderService;

@RestController
@RequestMapping("order")
public class orderController {
	@Autowired
	orderService orderser;
	
	@GetMapping("getAll")
	public List<Order> getallorders(){
		return orderser.getallorders();
	}
	@GetMapping("getOrderDetails")
	public Optional<Order> getOrderDetails(@RequestParam int orderId) {
		return orderser.getOrderByorderId(orderId);
	}
	
	@PostMapping("createOrder")
	public String createOrder(@RequestParam int ordererId,@RequestParam String orderName,@RequestBody Payment payment,@RequestParam List<Integer>productId) {
		return orderser.createOrder(ordererId,orderName,payment,productId );
	}
	@PutMapping("updateOrder")
	public String updateOrder(@RequestBody Order order) {
		return orderser.update(order);
	}
	@DeleteMapping("deleteOrder")
	public String deleteorder(@RequestParam int orderId) {
		return orderser.deleteorder(orderId);
	}
	
}
