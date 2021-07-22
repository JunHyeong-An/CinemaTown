package com.itbank.model;

import java.util.Arrays;

public class CinemaScheduleHomeDTO {

	private String movieName;
	private String urlName;
	private int schedule_allCount;
	private String[] start_time;
	private String[] end_time;
	private String[] hallName;
	private int ageLimit;
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
	public String[] getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String[] end_time) {
		this.end_time = end_time;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	@Override
	public String toString() {
		return "movieName=" + movieName + ", urlName=" + urlName + ", schedule_allCount="
				+ schedule_allCount + ", start_time=" + Arrays.toString(start_time) + ", end_time="
				+ Arrays.toString(end_time) + ", hallName=" + Arrays.toString(hallName) + ", ageLimit=" + ageLimit;
	}

	
	
	


	
	
}
