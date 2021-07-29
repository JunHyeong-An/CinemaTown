package com.itbank.model;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CinemaScheduleDAO {

////////////////////////////// 예매 관련 내용 //////////////////////////
	// 예매 시
	@Update("update cinemaSchedule set seatCountRemain = seatCountRemain - #{seatCountRemain} where schedule_idx = #{schedule_idx} ")
	void seatCountRemainMinus(@Param("schedule_idx")int schedule_idx,@Param("seatCountRemain")int seatCountRemainMinus);
	
	// 예매 취소 시
	@Update("update cinemaSchedule set seatCountRemain = seatCountRemain + #{seatCountRemain} where schedule_idx = #{schedule_idx} ")
	void seatCountRemainAdd(@Param("schedule_idx")int schedule_idx,@Param("seatCountRemain")int seatCountRemainAdd);


////////////////////////////// 상영시간표 관련 내용 ////////////////////////
	
	@Select("select cinemaMovie.movieName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaSchedule.showDay = #{showDay}" + 
			"    group by cinemaMovie.movieName order by cinemaMovie.movieName")
	String[] movieNameList(String showDay);
	
	@Select("select count(cinemaSchedule.startTime) as schedule_allCount" + 
			"    from cinemaMovie " + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"    where cinemaSchedule.showDay = #{showDay} and cinemaMovie.movieName = #{movieName}" + 
			"    group by cinemaMovie.movieName, cinemahall.hallName order by cinemaMovie.movieName, cinemahall.hallName")
	int[] scheduleCountList(@Param("showDay") String showDay,@Param("movieName")String movieName);

	@Select("select cinemaHall.hallName" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = #{showDay}" + 
			"    group by cinemaHall.hallName")
	String[] hallNameList(@Param("movieName")String movieName, @Param("showDay") String showDay);

	@Select("select to_char(cinemaSchedule.startTime,'HH24:mi') as start_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = #{showDay} and cinemahall.hallName=#{hallName} order by start_time")
	String[] start_timeList(@Param("movieName")String movieName,@Param("showDay") String showDay,@Param("hallName")String hallName);

	@Select("select to_char(cinemaSchedule.endTime,'HH24:mi') as end_time" + 
			"    from cinemaSchedule" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaschedule.moviename = #{movieName} and cinemaschedule.showday = #{showDay} and cinemahall.hallName=#{hallName} order by end_time")
	String[] end_timeList(@Param("movieName")String movieName,@Param("showDay") String showDay,@Param("hallName")String hallName);
	
	@Select("select runningTime, ageLimit from cinemaMovie where movieName=#{movieName}")
	CinemaMovieDTO runningTimeAgeLimitList(String movieName);

	@Select("select cinemaschedule.seatcountremain" + 
			"    from cinemaMovie " + 
			"    join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName " + 
			"    join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaSchedule.showDay = #{showDay} and cinemaMovie.movieName=#{movieName} and cinemaHall.hallName=#{hallName} order by cinemaMovie.movieName, cinemaHall.hallName")
	int[] seatCountRemainList(@Param("showDay") String showDay,@Param("movieName")String movieName,@Param("hallName")String hallName);

	@Select("select cinemaMovie.urlName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaSchedule.showDay = #{showDay}" + 
			"    group by cinemaMovie.movieName,cinemaMovie.urlName order by cinemaMovie.movieName")
	String[] urlNameList(String showDay);

	@Select("select cinemaSchedule.schedule_idx" + 
			"		from cinemaSchedule" + 
			"		full outer join cinemaHall" + 
			"		on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"		where cinemaschedule.moviename = #{movieName} " + 
			"       and cinemaschedule.showday = #{showDay} and cinemahall.hallName = #{hallName} order by startTime")
	int[] schedule_idxList(@Param("movieName")String movieName,@Param("showDay")String showDay, @Param("hallName")String hallName);

	
	
}
