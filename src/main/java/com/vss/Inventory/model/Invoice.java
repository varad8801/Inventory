package com.vss.Inventory.model;

import java.util.Date;
import java.util.List;

import com.vss.Inventory.model.Wrapper.OrdererWrapper;
import com.vss.Inventory.model.Wrapper.PaymentWrapper;
import com.vss.Inventory.model.Wrapper.ProductWrapper;


public class Invoice {
	
	private int Id; 
	private String invoiceNumber;
	private String orderName;
	private List<ProductWrapper> productDetails;
	private Date orderDate;
	
	private OrdererWrapper ordererDetails;
	
	private PaymentWrapper payment;
	public Invoice(int id, String invoiceNumber, String orderName, List<ProductWrapper> productDetails, Date orderDate,
			OrdererWrapper ordererDetails, PaymentWrapper payment) {
		super();
		Id = id;
		this.invoiceNumber = invoiceNumber;
		this.orderName = orderName;
		this.productDetails = productDetails;
		this.orderDate = orderDate;
		this.ordererDetails = ordererDetails;
		
		this.payment = payment;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public List<ProductWrapper> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductWrapper> productDetails) {
		this.productDetails = productDetails;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public OrdererWrapper getOrdererDetails() {
		return ordererDetails;
	}
	public void setOrdererDetails(OrdererWrapper ordererDetails) {
		this.ordererDetails = ordererDetails;
	}
	
	public PaymentWrapper getPayment() {
		return payment;
	}
	public void setPayment(PaymentWrapper payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Invoice [Id=" + Id + ", invoiceNumber=" + invoiceNumber + ", orderName=" + orderName
				+ ", productDetails=" + productDetails + ", orderDate=" + orderDate + ", ordererDetails="
				+ ordererDetails +  ", payment=" + payment + "]";
	}
	
}
	