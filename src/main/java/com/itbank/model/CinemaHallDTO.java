package com.itbank.model;

public class CinemaHallDTO {
	
//	HALL_IDX     NOT NULL NUMBER       
//	HALLNAME     NOT NULL VARCHAR2(10) 
//	SEATCOUNTALL NOT NULL NUMBER
	
	private int hall_idx, seatCountAll;
	private String hallName;
	
	
	public int getHall_idx() {
		return hall_idx;
	}
	public void setHall_idx(int hall_idx) {
		this.hall_idx = hall_idx;
	}
	public int getSeatCountAll() {
		return seatCountAll;
	}
	public void setSeatCountAll(int seatCountAll) {
		this.seatCountAll = seatCountAll;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	
	
}
