package com.vss.Inventory.model;

import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class proStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int quantity;
    private int minimumQuantity;
    private int maximumQuantity;
    private int reorderPoint;
    private String supplierInfo;
    private String barcode;
    private String location;
    private Date expirationDate;
    private Date manufacturingDate;
    private String notes;
    private double weight;
    private double length;
    private double width;
    private double height;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMinimumQuantity() {
		return minimumQuantity;
	}
	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}
	public int getMaximumQuantity() {
		return maximumQuantity;
	}
	public void setMaximumQuantity(int maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}
	public int getReorderPoint() {
		return reorderPoint;
	}
	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}
	public String getSupplierInfo() {
		return supplierInfo;
	}
	public void setSupplierInfo(String supplierInfo) {
		this.supplierInfo = supplierInfo;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "proStock [quantity=" + quantity + ", minimumQuantity=" + minimumQuantity + ", maximumQuantity="
				+ maximumQuantity + ", reorderPoint=" + reorderPoint + ", supplierInfo=" + supplierInfo + ", barcode="
				+ barcode + ", location=" + location + ", expirationDate=" + expirationDate + ", manufacturingDate="
				+ manufacturingDate + ", notes=" + notes + ", weight=" + weight + ", length=" + length + ", width="
				+ width + ", height=" + height + "]";
	}
	
	
}
