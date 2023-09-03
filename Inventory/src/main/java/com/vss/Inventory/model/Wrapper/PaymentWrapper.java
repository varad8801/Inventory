package com.vss.Inventory.model.Wrapper;

import java.util.Date;

public class PaymentWrapper 
{

	private String paymentMode;
	private String transactionId;
	private Date paymentDate;
	public PaymentWrapper(String paymentMode, String transactionId, Date paymentDate) {
		super();
		this.paymentMode = paymentMode;
		this.transactionId = transactionId;
		this.paymentDate = paymentDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "PaymentWrapper [paymentMode=" + paymentMode + ", transactionId=" + transactionId + ", paymentDate="
				+ paymentDate + "]";
	}
	
}
