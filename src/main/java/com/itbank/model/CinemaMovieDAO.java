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
			"    cinemaHall.hallName,cinemaHall.seatCountAll, cinemaschedule.schedule_idx, cinemaMovie.urlName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaMovie.movieName = #{movieName}  and cinemaSchedule.showDay = #{showDay} order by start_time")
	List<HashMap<String, Object>> ticketingList(@Param("movieName") String movieName, @Param("showDay") String showDay);

	// 상영일정 삽입 시 종료시간 넣기위해서 cinemaMovie테이블에서 러닝타임 받아오는 것(관리자페이지)
	@Select("select runningTime from cinemaMovie where movieName = #{movieName}")
	long runningTime(@Param("movieName")String movieName);

	// 예매1에서 영화정보 사용할려고
	@Select("select * from cinemaMovie")
	List<CinemaMovieDTO> movieList();

	// HomeController에 영화 포스터 띄우기위해 urlName 받아옴
	@Select("select urlName from cinemaMovie")
	String[] movieUrlList();

	// 1. HomeController에 간이 상영시간표에 '영화이름들' 가져오기 위해서
	@Select("select cinemaMovie.movieName" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = to_char(sysdate,'yyyyMMdd') " + 
			"    group by cinemaMovie.movieName")
	String[] movieNameList();

	// 2. HomeController에 간이 상영시간표에 '시작시간들' 가져오기 위해서
	@Select("select to_char(cinemaSchedule.startTime,'HH24:mi') as start_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = to_char(sysdate,'yyyyMMdd') order by to_char(cinemaSchedule.startTime,'HH24:mi')")
	String[] start_timeList(@Param("movieName") String movieName);

	// 3. HomeController에 간이 상영시간표에 '상영관들' 가져오기 위해서
	@Select("select cinemaHall.hallName" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = to_char(sysdate,'yyyyMMdd') order by to_char(cinemaSchedule.startTime,'HH24:mi')")
	String[] hallNameList(@Param("movieName") String movieName);

	// 4. HomeController에 간이 상영시간표에 for문돌리기 위해 '해당 영화의 상영개수' 가져오기 위해서
	@Select("select count(cinemaSchedule.startTime) as schedule_allCount" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = to_char(sysdate,'yyyyMMdd') " + 
			"    group by cinemaMovie.movieName")
	int[] scheduleCountList();

	@Select("select movieName from cinemaMovie")
	String[] movieName();
	
	
}
