package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MainServiceCenterDao {

	// 메인페이지 공지사항 한개 페이징
	@Select("select count(*) from masterNotice")
	int mainSelectCount();

	// 메인페이지 공지사항 전체 페이징
	@Select("select * from masterNotice order by notice_idx desc offset #{offset} rows fetch first #{perPage} rows only")
	List<MasterNoticeDTO> mainNoticeSelect(@Param("offset")int offset, @Param("perPage")int perPage);

	// 공지사항 글 한개 읽어오기
	@Select("select * from masterNotice where notice_idx = #{notice_idx}")
	List<MasterNoticeDTO> noticeModify(int notice_idx);

}
