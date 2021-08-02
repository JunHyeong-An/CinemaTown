package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface EventDao {

	@Select("select event_idx ,eventListTitle, eventListContent, eventListFileName, start_time, end_time from cinemaEventList where sysdate >= start_time and end_time >= sysdate order by event_idx desc")
	List<CinemaEventListDTO> selectList();

	@Select("select event_idx, eventListTitle ,eventListContent, eventListFileName, start_time, end_time from cinemaEventList where sysdate > end_time order by end_time")
	List<CinemaEventListDTO> selectList2();

	@Select("select event_idx ,eventListTitle ,eventListContent, eventListFileName, start_time, end_time from cinemaEventList where event_idx = #{event_idx}")
	List<CinemaEventListDTO> selectOne(int event_idx);

}
