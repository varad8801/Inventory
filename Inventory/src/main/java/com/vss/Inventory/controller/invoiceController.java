package com.vss.Inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vss.Inventory.model.Invoice;
import com.vss.Inventory.service.InvoiceService;

@RestController
@RequestMapping("invoice")
public class invoiceController {
	@Autowired
	InvoiceService invoiceser;
	@GetMapping("generateInvoice")
	public Invoice generateInvoice(@RequestParam int orderId) {
		return invoiceser.generateInvoice(orderId);
	}
}
