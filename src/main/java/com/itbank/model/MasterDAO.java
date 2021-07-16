package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MasterDAO {

	@Select("select * from cinemaLost")
	List<serviceCenterDTO> lostList();

	@Select("select * from cinemaMovie order by movieName desc")
	List<CinemaMovieDTO> movieList();
	
	@Insert("insert into cinemaMovie (movieName, ageLimit, runningTime, urlName) values (#{movieName}, #{ageLimit}, #{runningTime}, #{urlName})")
	int insert(CinemaMovieDTO dto);

	@Select("select * from cinemaHall order by hall_idx")
	List<CinemaHallDTO> hallList();
	
	@Insert("insert into cinemaSchedule(movieName, hall_idx, showDay, startTime, endTime, seatCountRemain) values(#{movieName},#{hall_idx},#{showDay},#{startTime},#{endTime},#{seatCountRemain})")
	int insertMovie(CinemaScheduleDTO dto);

	@Select("select * from cinemaHall where hallName=#{hallName}")
	CinemaHallDTO hallInfo(@Param("hallName") String hallName);

	@Select("select runningTime from cinemaMovie where movieName = #{movieName}")
	long runningTime(@Param("movieName")String movieName);
	
	@Insert("insert into cinemaEventList(eventListTitle ,eventListContent, eventListFileName, start_time, end_time) values (#{eventListTitle}, #{eventListContent}, #{eventListFileName}, #{start_time}, #{end_time})")
	int insertEvent(CinemaEventListDTO dto);

	@Select("select event_idx ,eventListTitle, eventListContent, eventListFileName, start_time, end_time from cinemaEventList where sysdate >= start_time and end_time >= sysdate order by end_time")
	List<CinemaEventListDTO> selectList();

	@Select("select event_idx, eventListTitle ,eventListContent, eventListFileName, start_time, end_time from cinemaEventList where sysdate > end_time order by end_time")
	List<CinemaEventListDTO> selectList2();

	@Select("select event_idx ,eventListTitle ,eventListContent, eventListFileName, start_time, end_time from cinemaEventList where event_idx = #{event_idx}")
	List<CinemaEventListDTO> selectOne(int event_idx);

	@Select("select event_idx ,eventListTitle, eventListContent from cinemaEventList where event_idx = #{event_idx}")
	List<CinemaEventListDTO> selectOneList(int event_idx);

	@Update("update cinemaEventList set eventListTitle=#{eventListTitle}, eventListContent = #{eventListContent}, eventListFileName = #{eventListFileName}, start_time = #{start_time} , end_time = #{end_time} where event_idx = #{event_idx}")
	int modify(CinemaEventListDTO dto);
}
