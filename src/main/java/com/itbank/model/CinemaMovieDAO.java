package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CinemaMovieDAO {

////////////////////CinemaMovieController ////////////////////////////////	
	// 예매 사이트 들어가면 왼쪽에 영화 리스트 목록 불러오기
	@Select("select * from cinemaMovie")
	List<CinemaMovieDTO> movieList();
	
	// 예매 사이트에서 선택된 영화와 날짜에 따른 상영일정 보여주기
	@Select("select cinemaMovie.movieName,cinemaMovie.ageLimit,cinemaMovie.urlName,cinemaSchedule.showDay,cinemaSchedule.seatCountRemain,to_char(cinemaSchedule.startTime,'HH24:mi') as start_time, to_char(cinemaSchedule.endTime,'HH24:mi') as end_time," + 
			"    cinemaHall.hallName,cinemaHall.seatCountAll, cinemaschedule.schedule_idx, cinemaMovie.urlName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaMovie.movieName = #{movieName}  and cinemaSchedule.showDay = #{showDay} order by start_time")
	List<HashMap<String, Object>> ticketingList(@Param("movieName") String movieName, @Param("showDay") String showDay);

//////////////////////////HomeController ///////////////////////////////		
	// HomeController 간이 상영시간표에 보여 줄 오늘 '영화이름들'
	@Select("select cinemaMovie.movieName" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = to_char(sysdate,'yyyyMMdd') " + 
			"    group by cinemaMovie.movieName")
	String[] movieNameList();

	@Select("select cinemaMovie.urlName" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = to_char(sysdate,'yyyyMMdd') " + 
			"    group by cinemaMovie.movieName, cinemaMovie.urlName")
	String[] urlNameList();

	@Select("select cinemaMovie.ageLimit" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = to_char(sysdate,'yyyyMMdd') " + 
			"    group by cinemaMovie.movieName, cinemaMovie.ageLimit")
	int[] ageLimitList();
	
	// HomeController 간이 상영시간표에 보여 줄 오늘 '시작시간들'
	@Select("select to_char(cinemaSchedule.startTime,'HH24:mi') as start_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = to_char(sysdate,'yyyyMMdd') order by to_char(cinemaSchedule.startTime,'HH24:mi')")
	String[] start_timeList(@Param("movieName") String movieName);

	// HomeController 간이 상영시간표에 보여 줄 오늘 '종료시간들'
	@Select("select to_char(cinemaSchedule.endTime,'HH24:mi') as end_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = to_char(sysdate,'yyyyMMdd') order by to_char(cinemaSchedule.startTime,'HH24:mi')")
	String[] end_timeList(@Param("movieName")String movieName);
	
	// HomeController 간이 상영시간표에 보여 줄 오늘 '상영관들'
	@Select("select cinemaHall.hallName" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = to_char(sysdate,'yyyyMMdd') order by to_char(cinemaSchedule.startTime,'HH24:mi')")
	String[] hallNameList(@Param("movieName") String movieName);

	// HomeController 간이 상영시간표에 보내 줄 각 상영마다 상영일정_idx
	@Select("select cinemaSchedule.schedule_idx" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = to_char(sysdate,'yyyyMMdd') order by to_char(cinemaSchedule.startTime,'HH24:mi')")
	int[] Schedule_idxList(@Param("movieName")String movieName);

	// HomeController 간이 상영시간표에 for문돌리기 위해 가져 올 '해당 영화의 상영개수'
	@Select("select count(cinemaSchedule.startTime) as schedule_allCount" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = to_char(sysdate,'yyyyMMdd') " + 
			"    group by cinemaMovie.movieName")
	int[] scheduleCountList();

	// home페이지에 포스터 보여주기 위해 불러 올 영화 code리스트
	@Select("select movieCode from cinemaMovie")
	String[] movieCodeList();






	
}
