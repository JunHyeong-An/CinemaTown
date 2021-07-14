package com.itbank.model;

public class CinemaSalesDTO {
//	SALES_IDX   NOT NULL NUMBER        
//	PAYMENT_IDX NOT NULL NUMBER        
//	MOVIENAME   NOT NULL VARCHAR2(500) 
//	SALESDAY             VARCHAR2(50)  
//	PRICE       NOT NULL NUMBER  
	
	private int sales_idx, payment_idx, price;
	private String movieName, salesDay;
	
	public int getSales_idx() {
		return sales_idx;
	}
	public void setSales_idx(int sales_idx) {
		this.sales_idx = sales_idx;
	}
	public int getPayment_idx() {
		return payment_idx;
	}
	public void setPayment_idx(int payment_idx) {
		this.payment_idx = payment_idx;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getSalesDay() {
		return salesDay;
	}
	public void setSalesDay(String salesDay) {
		this.salesDay = salesDay;
	}
	
	
}
