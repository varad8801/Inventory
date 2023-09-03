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

import com.vss.Inventory.model.Orderer;
import com.vss.Inventory.service.ordererService;

@RestController
@RequestMapping("orderer")
public class ordererController {
		@Autowired
		ordererService ordererser;
	@GetMapping("getAll")
	public List<Orderer> getallorderers(){
		return ordererser.getallorderers();
	}
	@GetMapping("getOrdererById")
	public Optional<Orderer> getordererbyId(@RequestParam int Id){
		return ordererser.getordererbyId(Id);
	}
	@PostMapping("addOrderer")
	public String addorderer(@RequestBody List<Orderer> orderer) {
		return ordererser.addorderer(orderer);
	}
	
	@PutMapping("updateOrderer")
	public String updateorderer(@RequestBody List<Orderer> orderer) {
		return ordererser.updateorderer(orderer);
	}
	@DeleteMapping("deleteAll")
	public String deleteall() {
		return ordererser.deleteallorderers();
	}
	@DeleteMapping("deleteById")
	public String deletebyid(@RequestParam List<Integer> Id) {
		return ordererser.deletebyid(Id);
	}
}
