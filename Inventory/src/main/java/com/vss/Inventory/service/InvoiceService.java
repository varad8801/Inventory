package com.vss.Inventory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vss.Inventory.Dao.ordererDao;
import com.vss.Inventory.Dao.productDao;
import com.vss.Inventory.model.Invoice;
import com.vss.Inventory.model.Order;
import com.vss.Inventory.model.Orderer;
import com.vss.Inventory.model.Payment;
import com.vss.Inventory.model.Product;
import com.vss.Inventory.model.Wrapper.OrdererWrapper;
import com.vss.Inventory.model.Wrapper.PaymentWrapper;
import com.vss.Inventory.model.Wrapper.ProductWrapper;

@Service
public class InvoiceService {
	java.util.Date date = new java.util.Date(); 
	@Autowired
	orderDao orderdao;
	@Autowired
	ordererDao ordererdao;
	@Autowired
	productDao productdao;
	
	public Invoice generateInvoice(int orderId) {
		// TODO Auto-generated method stub
		String generatedinvoicenumber = RandomStringUtils.randomAlphanumeric(8);

	    
	Optional<Order> order = orderdao.findById(orderId);
	//Order order.get() = order.get();
	List<Product> product=order.get().getProduct();
	List<ProductWrapper>productwrapperfromDb=new ArrayList<ProductWrapper>();
	for(Product p:product) {
		ProductWrapper productwrapper=new ProductWrapper(p.getProductId(), p.getProductName(), p.getCategory(), p.getSubCategory(), p.getProductWeight(), p.getBrand(), p.getPricing().getUnitPrice());
		productwrapperfromDb.add(productwrapper);

	}
	
	Orderer orderer=order.get().getOrderer();
	OrdererWrapper ordererwrapperfromDb=new OrdererWrapper(orderer.getName(), orderer.getEmail(), orderer.getoAddress());
	Payment payment=order.get().getPayment();
	PaymentWrapper payementwrapper=new PaymentWrapper(payment.getPaymentMode(), payment.getTransactionId(), payment.getPaymentDate());
	Invoice invoice=new Invoice(orderId, generatedinvoicenumber, order.get().getOrderName(),productwrapperfromDb, order.get().getOrderDate(), ordererwrapperfromDb,  payementwrapper);
		
		return invoice;
	}
}
