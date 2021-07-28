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

	@Select("select movieName from cinemaMovie")
	String[] movieNameList();

	@Delete("delete from review where review_idx=#{review_idx}")
	int reviewDelete(int review_idx);

	// 마스터 리뷰 페이징
	@Select("select * from review where movieName=#{movieName} and rownum <=#{rowMax} order by reviewDay desc")
	List<ReviewDTO> reviewList2(@Param("movieName")String movieName, @Param("rowMax")String rowMax);


	

	

//	@Delete("delete from review where movieName=#{movieName}")
//	int reviewDelete(String movieName);


	
}
