package com.itbank.model;

import java.util.Arrays;

public class CinemaScheduleHomeDTO {

	private String movieName;
	private String[] start_time;
	private String[] hallName;
	private int schedule_allCount;
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String[] getStart_time() {
		return start_time;
	}
	public void setStart_time(String[] start_time) {
		this.start_time = start_time;
	}
	public String[] getHallName() {
		return hallName;
	}
	public void setHallName(String[] hallName) {
		this.hallName = hallName;
	}
	public int getSchedule_allCount() {
		return schedule_allCount;
	}
	public void setSchedule_allCount(int schedule_allCount) {
		this.schedule_allCount = schedule_allCount;
	}
	@Override
	public String toString() {
		return "movieName=" + movieName + ", start_time=" + Arrays.toString(start_time)
				+ ", hallName=" + Arrays.toString(hallName) + ", schedule_allCount=" + schedule_allCount;
	}
	
	


	
	
}
