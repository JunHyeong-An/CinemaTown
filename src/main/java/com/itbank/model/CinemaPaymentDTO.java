package com.itbank.model;

public class CinemaPaymentDTO {
//	PAYMENT_IDX   NOT NULL NUMBER       
//	TICKETING_IDX NOT NULL NUMBER       
//	USERID        NOT NULL VARCHAR2(20) 
//	PAYMENTDAY             VARCHAR2(50) 
//	CANCELED               CHAR(1)      
//	TOTALAMOUNT   NOT NULL NUMBER  
	
	private int payment_idx, ticketing_idx, totalAmount;
	private String userId, paymentDay, canceled;
	public int getPayment_idx() {
		return payment_idx;
	}
	public void setPayment_idx(int payment_idx) {
		this.payment_idx = payment_idx;
	}
	public int getTicketing_idx() {
		return ticketing_idx;
	}
	public void setTicketing_idx(int ticketing_idx) {
		this.ticketing_idx = ticketing_idx;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getCanceled() {
		return canceled;
	}
	public void setCanceled(String canceled) {
		this.canceled = canceled;
	}
	
	
}
