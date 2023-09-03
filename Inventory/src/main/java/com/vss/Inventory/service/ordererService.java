package com.vss.Inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vss.Inventory.Dao.ordererDao;
import com.vss.Inventory.model.Orderer;

@Service
public class ordererService {
	@Autowired
	ordererDao ordererdao;
	
	public List<Orderer> getallorderers() {
		// TODO Auto-generated method stub
		return ordererdao.findAll();
		 
	}

	public Optional<Orderer> getordererbyId(int id) {
		// TODO Auto-generated method stub
		return ordererdao.findById(id);
	}

	public String addorderer(List<Orderer> orderer) {
		// TODO Auto-generated method stub
		ordererdao.saveAll(orderer);
		return "Added "+orderer.size();
	}

	public String updateorderer(List<Orderer> orderer) {
		// TODO Auto-generated method stub
		ordererdao.saveAll(orderer);
		return "Updated "+orderer.size();
	}

	public String deleteallorderers() {
		// TODO Auto-generated method stub
		ordererdao.deleteAll();
		return "deleted all the orderers";
	}

	public String deletebyid(List<Integer> id) {
		// TODO Auto-generated method stub
		ordererdao.deleteAllById(id);
		return null;
	}
	
	
}
