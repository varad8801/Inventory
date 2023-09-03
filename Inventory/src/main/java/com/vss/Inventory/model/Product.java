package com.vss.Inventory.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String category;
	private String subCategory;
	private String productWeight;
	private String brand;
	@OneToOne(cascade = CascadeType.ALL)
	private proPricing pricing;
	@OneToOne(cascade = CascadeType.ALL)
	private proStock stock;
	@ManyToMany
	private List<Order> order;
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(String productWeight) {
		this.productWeight = productWeight;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public proPricing getPricing() {
		return pricing;
	}
	public void setPricing(proPricing pricing) {
		this.pricing = pricing;
	}
	public proStock getStock() {
		return stock;
	}
	public void setStock(proStock stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", subCategory=" + subCategory + ", productWeight=" + productWeight + ", brand=" + brand
				+ ", pricing=" + pricing + ", stock=" + stock + ", order=" + order + "]";
	}
	
}
