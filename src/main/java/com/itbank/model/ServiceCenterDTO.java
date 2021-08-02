package com.itbank.model;

public class ServiceCenterDTO {

//	CINEMALOST_IDX     NOT NULL NUMBER         
//	CINEMALOSTDATETIME NOT NULL VARCHAR2(300)  
//	CINEMALOSTKIND     NOT NULL VARCHAR2(300)  
//	CINEMALOSTCONTENT  NOT NULL VARCHAR2(1000) 
//	CINEMALOSTNAME     NOT NULL VARCHAR2(20)   
//	CINEMALOSTBIRTH    NOT NULL VARCHAR2(6)    
//	CINEMALOSTPH       NOT NULL VARCHAR2(13)   
//	CINEMALOSTTODAY             VARCHAR2(50)
	
	private int cinemaLost_idx;
	private String cinemaLostDateTime, cinemaLostKind, cinemaLostContent, cinemaLostName, cinemaLostBirth, cinemaLostPH, cinemaLostToDay, cinemaLostHall;
	
	
	
	public int getCinemaLost_idx() {
		return cinemaLost_idx;
	}
	public void setCinemaLost_idx(int cinemaLost_idx) {
		this.cinemaLost_idx = cinemaLost_idx;
	}
	public String getCinemaLostDateTime() {
		return cinemaLostDateTime;
	}
	public void setCinemaLostDateTime(String cinemaLostDateTime) {
		this.cinemaLostDateTime = cinemaLostDateTime;
	}
	public String getCinemaLostKind() {
		return cinemaLostKind;
	}
	public void setCinemaLostKind(String cinemaLostKind) {
		this.cinemaLostKind = cinemaLostKind;
	}
	public String getCinemaLostContent() {
		return cinemaLostContent;
	}
	public void setCinemaLostContent(String cinemaLostContent) {
		this.cinemaLostContent = cinemaLostContent;
	}
	public String getCinemaLostName() {
		return cinemaLostName;
	}
	public void setCinemaLostName(String cinemaLostName) {
		this.cinemaLostName = cinemaLostName;
	}
	public String getCinemaLostBirth() {
		return cinemaLostBirth;
	}
	public void setCinemaLostBirth(String cinemaLostBirth) {
		this.cinemaLostBirth = cinemaLostBirth;
	}
	public String getCinemaLostPH() {
		return cinemaLostPH;
	}
	public void setCinemaLostPH(String cinemaLostPH) {
		this.cinemaLostPH = cinemaLostPH;
	}
	public String getCinemaLostToDay() {
		return cinemaLostToDay;
	}
	public void setCinemaLostToDay(String cinemaLostToDay) {
		this.cinemaLostToDay = cinemaLostToDay;
	}
	public String getCinemaLostHall() {
		return cinemaLostHall;
	}
	public void setCinemaLostHall(String cinemaLostHall) {
		this.cinemaLostHall = cinemaLostHall;
	}
	
	
}
