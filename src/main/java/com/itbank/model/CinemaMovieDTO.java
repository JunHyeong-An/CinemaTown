package com.itbank.model;

public class CinemaMovieDTO {

//	MOVIENAME   NOT NULL VARCHAR2(500) 
//	AGELIMIT    NOT NULL NUMBER        
//	RUNNINGTIME NOT NULL NUMBER        
//	DELETED              CHAR(1)   
	
	private int ageLimit;
	private String movieName, deleted, urlName;
	private long runningTime;
	
	public int getAgeLimit() {
		return ageLimit;
	}
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public long getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(long runningTime) {
		this.runningTime = runningTime;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	

	
	
	
}
