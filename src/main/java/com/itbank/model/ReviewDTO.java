package com.itbank.model;

public class ReviewDTO {

//    review_idx      number          default review_seq.nextval primary key,
//    movieName       varchar2(50)    not null,
//    userId          varchar2(50)    not null,
//    reviewContent   varchar2(1000)  not null,
//    reviewDay       varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi')
	
//	  rowMin
//	  rowMax
	
	private int review_idx, rowMin, rowMax;
	private String movieName, userId, reviewContent, reviewDay;
	
	public int getReview_idx() {
		return review_idx;
	}
	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDay() {
		return reviewDay;
	}
	public void setReviewDay(String reviewDay) {
		this.reviewDay = reviewDay;
	}
	public int getRowMin() {
		return rowMin;
	}
	public void setRowMin(int rowMin) {
		this.rowMin = rowMin;
	}
	public int getRowMax() {
		return rowMax;
	}
	public void setRowMax(int rowMax) {
		this.rowMax = rowMax;
	}
}
