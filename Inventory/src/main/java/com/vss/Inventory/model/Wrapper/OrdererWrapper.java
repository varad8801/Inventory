package com.vss.Inventory.model.Wrapper;

import java.util.List;

import com.vss.Inventory.model.Orderer;
import com.vss.Inventory.model.OrdererAddress;

public class OrdererWrapper {
	

	private String Name;
	private String Email;
	
	private List<OrdererAddress> oAddress;
	public OrdererWrapper( String name, String email,  List<OrdererAddress> oAddress) {
		super();
		
		Name = name;
		Email = email;
		
		this.oAddress = oAddress;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	public List<OrdererAddress> getoAddress() {
		return oAddress;
	}
	public void setoAddress(List<OrdererAddress> oAddress) {
		this.oAddress = oAddress;
	}
	@Override
	public String toString() {
		return "OrdererWrapper [  Name=" + Name + ", Email=" + Email 
				+ ", oAddress=" + oAddress + "]";
	}
	
}
