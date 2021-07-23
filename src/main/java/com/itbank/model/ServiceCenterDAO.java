package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ServiceCenterDAO {

	@Insert("insert into cinemaLost(cinemaLostDateTime, cinemaLostKind,cinemaLostContent,cinemaLostName,cinemaLostBirth,cinemaLostPH) values (#{cinemaLostDateTime},#{cinemaLostKind},#{cinemaLostContent},#{cinemaLostName},#{cinemaLostBirth},#{cinemaLostPH})")
	int addlostList(ServiceCenterDTO dto);

	@Insert("insert into oneToOne(otoKind,otoTitle,otoContent,userId) values(#{otoKind},#{otoTitle},#{otoContent},#{userId})")
	int addOneToOneList(OneToOneDTO dto);

	// 게시글 페이징
	@Select("select count(*) from masterNotice")
	int selectCount();

	// 공지사항 게시글 전체 불러오기 페이징
	@Select("select * from masterNotice order by notice_idx desc offset #{offset} rows fetch first #{perPage} rows only")
	List<MasterNoticeDTO> noticeSelect(@Param("offset")int offset, @Param("perPage")int perPage);

	// 공지사항 집어넣기
	@Insert("insert into masterNotice (noticeTitle, noticeContent, noticeFileName) values (#{noticeTitle}, #{noticeContent}, #{noticeFileName})")
	int noticeWrite (MasterNoticeDTO dto);

	// 공지사항 리스트 한개 불러오기
	@Select("select * from masterNotice where notice_idx = #{notice_idx}")
	List<MasterNoticeDTO> noticeReandOne(int notice_idx);

	// 공지사항 글 수정할 글 불러오기
	@Select("select * from masterNotice where notice_idx = #{notice_idx}")
	List<MasterNoticeDTO> noticeModify(int notice_idx);

	// 공지사항 글 수정하기
	@Update("update masterNotice set noticeTitle = #{noticeTitle}, noticeContent = #{noticeContent}, noticeFileName = #{noticeFileName}  where notice_idx = #{notice_idx}")
	int noticeModifyOne(MasterNoticeDTO dto);

	// 공지사항 글 삭제
	@Delete("delete from masterNotice where notice_idx = #{notice_idx}")
	int noticeDelete(int notice_idx);
	
	
}
