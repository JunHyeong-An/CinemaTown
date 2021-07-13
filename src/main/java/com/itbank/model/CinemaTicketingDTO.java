package com.itbank.model;

public class CinemaTicketingDTO {

//	TICKETING_IDX NOT NULL NUMBER       
//	USERID        NOT NULL VARCHAR2(20) 
//	SCHEDULE_IDX  NOT NULL NUMBER       
//	HALL_IDX      NOT NULL NUMBER       
//	SEATNAMEALL   NOT NULL VARCHAR2(50) 
//	ADULTCOUNT             NUMBER       
//	TEENAGERCOUNT          NUMBER       
//	DELETED	               CHAR(1)  
	
	private int ticketing_idx, schedule_idx, hall_idx, adultCount,teenagerCount;
	private String userId, seatNameAll, deleted;
	
	public int getTicketing_idx() {
		return ticketing_idx;
	}
	public void setTicketing_idx(int ticketing_idx) {
		this.ticketing_idx = ticketing_idx;
	}
	public int getSchedule_idx() {
		return schedule_idx;
	}
	public void setSchedule_idx(int schedule_idx) {
		this.schedule_idx = schedule_idx;
	}
	public int getHall_idx() {
		return hall_idx;
	}
	public void setHall_idx(int hall_idx) {
		this.hall_idx = hall_idx;
	}
	public int getAdultCount() {
		return adultCount;
	}
	public void setAdultCount(int adultCount) {
		this.adultCount = adultCount;
	}
	public int getTeenagerCount() {
		return teenagerCount;
	}
	public void setTeenagerCount(int teenagerCount) {
		this.teenagerCount = teenagerCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSeatNameAll() {
		return seatNameAll;
	}
	public void setSeatNameAll(String seatNameAll) {
		this.seatNameAll = seatNameAll;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	
	
}
