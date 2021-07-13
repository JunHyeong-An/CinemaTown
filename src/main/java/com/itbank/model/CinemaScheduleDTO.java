package com.itbank.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CinemaScheduleDTO {

//	SCHEDULE_IDX    NOT NULL NUMBER        
//	MOVIENAME       NOT NULL VARCHAR2(500) 
//	HALL_IDX        NOT NULL NUMBER 
//	SHOWDAY         NOT NULL VARCHAR2(20)  
//	STARTTIME       NOT NULL TIMESTAMP(6)  
//	ENDTIME         NOT NULL TIMESTAMP(6)  
//	SEATCOUNTREMAIN NOT NULL NUMBER 
	
	private int schedule_idx, hall_idx,seatCountRemain;
	private String showDay, movieName;
	@DateTimeFormat(pattern="yyyyMMddHHmm")
	private Date startTime, endTime;
	public int getSchedule_idx() {
		return schedule_idx;
	}
	public void setSchedule_idx(int schedule_idx) {
		this.schedule_idx = schedule_idx;
	}

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getHall_idx() {
		return hall_idx;
	}
	public void setHall_idx(int hall_idx) {
		this.hall_idx = hall_idx;
	}
	public int getSeatCountRemain() {
		return seatCountRemain;
	}
	public void setSeatCountRemain(int seatCountRemain) {
		this.seatCountRemain = seatCountRemain;
	}
	public String getShowDay() {
		return showDay;
	}
	public void setShowDay(String showDay) {
		this.showDay = showDay;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	
	
	
}
