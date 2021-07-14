package com.itbank.model;

public class CinemaUserDTO {

//	USERID     NOT NULL VARCHAR2(20)   
//	USERPW     NOT NULL VARCHAR2(150)  
//	USERNAME   NOT NULL VARCHAR2(20)   
//	USERBIRTH  NOT NULL VARCHAR2(20)   
//	USEREMAIL  NOT NULL VARCHAR2(100)  
//	USERADDR   NOT NULL VARCHAR2(1000) 
//	USERPH     NOT NULL VARCHAR2(20)   
//	USERAGE    NOT NULL NUMBER         
//	USERGENDER NOT NULL VARCHAR2(10)   
//	USERGRADE           NUMBER    

	
	private int userGrade, userAge; 
	private String userId, userPw, userName, userBirth, userEmail, userAddr, userPh, userGender;
	

	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserPh() {
		return userPh;
	}
	public void setUserPh(String userPh) {
		this.userPh = userPh;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	
	
}
