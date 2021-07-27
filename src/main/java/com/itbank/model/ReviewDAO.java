package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ReviewDAO {

	// 리뷰리스트 더불러오기
	@Select("select * from review where movieName=#{movieName} and rownum <=#{rowMax} order by reviewDay desc")
	List<ReviewDTO> reviewList(@Param("movieName")String movieNm, @Param("rowMax")String rowMax);

	// 리뷰 등록
	@Insert("insert into review(movieName, userId, reviewContent)values(#{movieNm},#{userId},#{reviewContent})")
	int reviewAdd(HashMap<String, String> map);

	@Select("select * from review where review_idx=#{reivew_idx}")
	List<ReviewDTO> selectOne(int review_idx);

	@Update("update review set reviewContent=#{reviewContent} where review_idx=#{review_idx}")
	int reviewModify(ReviewDTO dto);

//	@Select("select movieName from cinemaMovie")
//	String[] movieNameList();

	@Delete("delete from review where review_idx=#{review_idx}")
	int reviewDelete(int review_idx);

	@Select("select * from review where movieName=#{movieNm} order by reviewDay desc")
	List<ReviewDTO> movieReviewList(String movieNm);

	// 리뷰 한개 페이징
	@Select("select count(*) from review")
	int selectCount();

	// 리뷰 전체 페이징
	@Select("select * from review where movieName=#{movieName}")
	List<ReviewDTO> noticeSelect(@Param("offset")int offset, @Param("perPage")int perPage);


	

	

//	@Delete("delete from review where movieName=#{movieName}")
//	int reviewDelete(String movieName);


	
}
