package com.itbank.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class CinemaEventListDTO {
	
//	EVENT_IDX         NOT NULL NUMBER  
//	EVENTLISTTITLE    NOT NULL VARCHAR2(200)  
//	EVENTLISTCONTENT  NOT NULL VARCHAR2(2000) 
//	EVENTLISTFILENAME NOT NULL VARCHAR2(255)  
//	START_TIME        NOT NULL VARCHAR2(20)   
//	END_TIME          NOT NULL VARCHAR2(20)  

	private int event_idx;
	private String eventListTitle,eventListContent, eventListFileName, start_time, end_time;
	private MultipartFile files;
	public int getEvent_idx() {
		return event_idx;
	}
	public void setEvent_idx(int event_idx) {
		this.event_idx = event_idx;
	}
	
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	public String getEventListContent() {
		return eventListContent;
	}
	public void setEventListContent(String eventListContent) {
		this.eventListContent = eventListContent;
	}
	public String getEventListFileName() {
		return eventListFileName;
	}
	public void setEventListFileName(String eventListFileName) {
		this.eventListFileName = eventListFileName;
	}
	public String getEventListTitle() {
		return eventListTitle;
	}
	public void setEventListTitle(String eventListTitle) {
		this.eventListTitle = eventListTitle;
	}
	public MultipartFile getFiles() {
		return files;
	}
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	
	
}
