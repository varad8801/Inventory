package com.vss.Inventory.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdererAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Orderer orderers;
	private String addressL1;
	private String addressL2;
	private String city;
	private String state;
	private String pincode;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Orderer getOrderers() {
		return orderers;
	}
	public void setOrderers(Orderer orderers) {
		this.orderers = orderers;
	}
	public String getAddressL1() {
		return addressL1;
	}
	public void setAddressL1(String addressL1) {
		this.addressL1 = addressL1;
	}
	public String getAddressL2() {
		return addressL2;
	}
	public void setAddressL2(String addressL2) {
		this.addressL2 = addressL2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "OrdererAddress [Id=" + Id + ", orderers=" + orderers + ", addressL1=" + addressL1 + ", addressL2="
				+ addressL2 + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}
	
	}
