package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CinemaMovieDAO {

	// 예매리스트
	@Select("select cinemaMovie.movieName,cinemaSchedule.showDay,cinemaSchedule.seatCountRemain,to_char(cinemaSchedule.startTime,'HH24:mi') as start_time, to_char(cinemaSchedule.endTime,'HH24:mi') as end_time," + 
			"    cinemaHall.hallName,cinemaHall.seatCountAll, cinemaschedule.schedule_idx" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaMovie.movieName = #{movieName}  and cinemaSchedule.showDay = #{showDay}")
	List<HashMap<String, Object>> ticketingList(@Param("movieName") String movieName, @Param("showDay") String showDay);

	// 상영시간표 리스트(날짜만 받는다.)
	@Select("select cinemaMovie.movieName,cinemaSchedule.showDay,to_char(cinemaSchedule.startTime,'HH24:mi') as start_time," + 
			"    cinemaHall.hallName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaSchedule.showDay = '20210709'")
	List<HashMap<String, Object>> screenScheduleList();

	// 상영일정 삽입 시 종료시간 넣기위해서 cinemaMovie테이블에서 러닝타임 받아오는 것(관리자페이지)
	@Select("select runningTime from cinemaMovie where movieName = #{movieName}")
	long runningTime(@Param("movieName")String movieName);

	@Select("select * from cinemaMovie")
	List<CinemaMovieDTO> movieList();

	@Select("select urlName from cinemaMovie")
	String[] movieUrlList();
	
	
	
}
