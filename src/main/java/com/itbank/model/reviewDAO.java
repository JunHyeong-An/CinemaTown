package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface reviewDAO {

	@Select("select * from review where movieName=#{movieName} and rownum >=#{rowMin} and row <=#{rowMax} order by reviewDay desc")
	List<reviewDTO> reviewList(@Param("movieName")String movieName1);

	@Insert("insert into review(movieName, userId, reviewContent)values(#{movieName},#{userId},#{reviewContent})")
	int reviewAdd(reviewDTO dto);

	@Select("select * from review where review_idx=#{reivew_idx}")
	List<reviewDTO> selectOne(int review_idx);

	@Update("update review set reviewContent=#{reviewContent} where review_idx=#{review_idx}")
	int reviewModify(reviewDTO dto);

	@Select("select movieName from cinemaMovie")
	String[] movieNameList();

	@Delete("delete from review where review_idx=#{review_idx}")
	int reviewDelete(int review_idx);

//	@Delete("delete from review where movieName=#{movieName}")
//	int reviewDelete(String movieName);


	
}
