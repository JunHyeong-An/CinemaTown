package com.itbank.model;

import java.util.Arrays;

public class CinemaScheduleListDTO {


	private String[] start_time;
	private String[] end_time;
	private String hallName;
	private int schedule_allCount;
	private int[] seatCountRemain;
	private int[] schedule_idx;

	public String[] getStart_time() {
		return start_time;
	}
	public void setStart_time(String[] start_time) {
		this.start_time = start_time;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public int getSchedule_allCount() {
		return schedule_allCount;
	}
	public void setSchedule_allCount(int schedule_allCount) {
		this.schedule_allCount = schedule_allCount;
	}
	
	public String[] getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String[] end_time) {
		this.end_time = end_time;
	}
	public int[] getSeatCountRemain() {
		return seatCountRemain;
	}
	public void setSeatCountRemain(int[] seatCountRemain) {
		this.seatCountRemain = seatCountRemain;
	}
	public int[] getSchedule_idx() {
		return schedule_idx;
	}
	public void setSchedule_idx(int[] schedule_idx) {
		this.schedule_idx = schedule_idx;
	}
	
	@Override
	public String toString() {
		return "start_time=" + Arrays.toString(start_time) + ", end_time="
				+ Arrays.toString(end_time) + ", hallName=" + hallName + ", schedule_allCount=" + schedule_allCount
				+ ", seatCountRemain=" + Arrays.toString(seatCountRemain) + ", schedule_idx="
				+ Arrays.toString(schedule_idx);
	}
	



	
	
	


	
	
}
