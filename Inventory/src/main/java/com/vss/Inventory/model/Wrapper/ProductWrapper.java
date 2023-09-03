package com.vss.Inventory.model.Wrapper;

public class ProductWrapper 
{	
	private int productId;
	private String productName;
	private String category;
	private String subCategory;
	private String productWeight;
	private String brand;
	private double unitPrice;
	public ProductWrapper(int productId, String productName, String category, String subCategory, String productWeight,
			String brand, double unitPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.subCategory = subCategory;
		this.productWeight = productWeight;
		this.brand = brand;
		this.unitPrice = unitPrice;
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
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "ProductWrapper [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", subCategory=" + subCategory + ", productWeight=" + productWeight + ", brand=" + brand
				+ ", unitPrice=" + unitPrice + "]";
	}
	


}
