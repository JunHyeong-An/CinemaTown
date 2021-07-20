package com.itbank.model;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CinemaScheduleListDAO {

	@Select("select cinemaMovie.movieName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaSchedule.showDay = '20210716'" + 
			"    group by cinemaMovie.movieName order by cinemaMovie.movieName")
	String[] movieNameList();	// showDay 넣어주기★
	
	@Select("select count(cinemaSchedule.startTime) as schedule_allCount" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = '20210716' and cinemaMovie.movieName = #{movieName}" + 
			"    group by cinemaMovie.movieName, cinemahall.hallName order by cinemaMovie.movieName, cinemahall.hallName")
	int[] scheduleCountList(@Param("movieName")String movieName);

	@Select("select cinemaHall.hallName" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = '20210716'" + 
			"    group by cinemaHall.hallName")
	String[] hallNameList(@Param("movieName")String movieName);

	@Select("select to_char(cinemaSchedule.startTime,'HH24:mi') as start_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = '20210716' and cinemahall.hallName=#{hallName} order by start_time")
	String[] start_timeList(@Param("movieName")String movieName,@Param("hallName")String hallName);

	@Select("select to_char(cinemaSchedule.endTime,'HH24:mi') as end_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = '20210716' and cinemahall.hallName=#{hallName} order by end_time")
	String[] end_timeList(@Param("movieName")String movieName,@Param("hallName")String hallName);

	
}
