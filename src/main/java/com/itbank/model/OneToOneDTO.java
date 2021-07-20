package com.itbank.model;

public class OneToOneDTO {

//	 oneToOne_idx        number          default oneToOne_seq.nextval primary key,
//	 otoKind             varchar2(20)    not null,
//	 otoTitle            varchar2(300)   not null,
//	 otoContent          varchar2(1000)  not null,
//	 otoWriteDay         varchar2(50)    default to_char(sysdate,'yyyy-MM-dd HH24:mi'),
//	 userId              varchar2(20)    not null,

	private int oneToOne_idx;
	private String otoKind,otoTitle,otoContent,otoWriteDay,userId;
	public int getOneToOne_idx() {
		return oneToOne_idx;
	}
	public void setOneToOne_idx(int oneToOne_idx) {
		this.oneToOne_idx = oneToOne_idx;
	}
	public String getOtoKind() {
		return otoKind;
	}
	public void setOtoKind(String otoKind) {
		this.otoKind = otoKind;
	}
	public String getOtoTitle() {
		return otoTitle;
	}
	public void setOtoTitle(String otoTitle) {
		this.otoTitle = otoTitle;
	}
	public String getOtoContent() {
		return otoContent;
	}
	public void setOtoContent(String otoContent) {
		this.otoContent = otoContent;
	}
	public String getOtoWriteDay() {
		return otoWriteDay;
	}
	public void setOtoWriteDay(String otoWriteDay) {
		this.otoWriteDay = otoWriteDay;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
