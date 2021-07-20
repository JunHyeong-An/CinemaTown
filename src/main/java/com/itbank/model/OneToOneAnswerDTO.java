package com.itbank.model;

public class OneToOneAnswerDTO {
	
//	  oneToOneAnswer_idx	number			default oneToOneAnswer_seq.nextval primary key,
//    oneToOne_idx			number			not null,
//    answerContent			varchar2(1000)	not null,
//    answerDay				varchar2(50)	default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
	
	private int oneToOneAnswer, oneToOne_idx;
	private String answerContent, answerDay;
	
	
	public int getOneToOneAnswer() {
		return oneToOneAnswer;
	}
	public void setOneToOneAnswer(int oneToOneAnswer) {
		this.oneToOneAnswer = oneToOneAnswer;
	}
	public int getOneToOne_idx() {
		return oneToOne_idx;
	}
	public void setOneToOne_idx(int oneToOne_idx) {
		this.oneToOne_idx = oneToOne_idx;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerDay() {
		return answerDay;
	}
	public void setAnswerDay(String answerDay) {
		this.answerDay = answerDay;
	}

}
