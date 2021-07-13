package com.itbank.model;

public class CinemaSeatDTO {
	
//	SEAT_IDX      NOT NULL NUMBER       
//	TICKETING_IDX NOT NULL NUMBER       
//	SEATNAME      NOT NULL VARCHAR2(20) 
//	RESERVED               CHAR(1)  
	
	private int seat_idx, ticketing_idx;
	private String seatName, reserved;
	
	public int getSeat_idx() {
		return seat_idx;
	}
	public void setSeat_idx(int seat_idx) {
		this.seat_idx = seat_idx;
	}
	public int getTicketing_idx() {
		return ticketing_idx;
	}
	public void setTicketing_idx(int ticketing_idx) {
		this.ticketing_idx = ticketing_idx;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	
	
	
	
	
}
