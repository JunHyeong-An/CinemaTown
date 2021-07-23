package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class MasterNoticeDTO {

//	NOTICE_IDX     NOT NULL NUMBER         
//	NOTICETITLE    NOT NULL VARCHAR2(100)  
//	NOTICECONTENT  NOT NULL VARCHAR2(1000) 
//	NOTICEFILENAME          VARCHAR2(255)  
//	NOTICEDATE              VARCHAR2(50)   
//	DELETED                 CHAR(1)   
	
	private int notice_idx;
	private String noticeTitle, noticeContent, noticeFileName, noticeDate; 
	private MultipartFile files;
	private char deleted;
	public int getNotice_idx() {
		return notice_idx;
	}
	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public MultipartFile getFiles() {
		return files;
	}
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	
	
}
