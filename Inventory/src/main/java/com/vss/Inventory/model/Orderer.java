package com.vss.Inventory.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orderer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private String Email;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrdererAddress> oAddress;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Order> Orders;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public List<Order> getOrders() {
		return Orders;
	}
	public void setOrders(List<Order> orders) {
		Orders = orders;
	}
	@Override
	public String toString() {
		return "Orderer [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", oAddress=" + oAddress + ", Orders="
				+ Orders + "]";
	}
	
}
