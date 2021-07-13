package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CinemaMovieDAO {

	// 예매리스트(영화이름과 날짜를 받는다.)
	@Select("select cinemaMovie.movieName,cinemaSchedule.showDay,cinemaSchedule.seatCountRemain,to_char(cinemaSchedule.startTime,'HH24:mi') as start_time, to_char(cinemaSchedule.endTime,'HH24:mi') as end_time," + 
			"    cinemaHall.hallName,cinemaHall.seatCountAll" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaMovie.movieName = '발신제한'  and cinemaSchedule.showDay = '20210709'")
	List<HashMap<String, Object>> ticketingList();

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

	@Insert("insert into cinemaSchedule(movieName, hall_idx, showDay, startTime, endTime, seatCountRemain) values(#{movieName},#{hall_idx},#{showDay},#{startTime},#{endTime},#{seatCountRemain})")
	int insertMovie(CinemaScheduleDTO dto);

	@Select("select runningTime from cinemaMovie where movieName = #{movieName}")
	long runningTime(@Param("movieName")String movieName);

	@Select("select * from cinemaHall where hallName=#{hallName}")
	CinemaHallDTO hallInfo(@Param("hallName") String hallName);

	@Insert("insert into cinemaTicketing(userId, schedule_idx, hall_idx, seatNameAll, adultCount, teenagerCount) values('admin', 12, 4, #{seatNameAll}, #{adultCount}, #{teenagerCount})")
	int ticketing(CinemaTicketingDTO dto);
	
	@Select("select max(ticketing_idx) from cinemaTicketing")
	int getTicketing_idx();
	
	
	@Insert("insert into cinemaSeat(ticketing_idx, seatName) values(#{ticketing_idx}, #{seatName})")
	int seatInsert(@Param("ticketing_idx")int ticketing_idx, @Param("seatName")String seatName);

	@Update("update cinemaTicketing set deleted = 'y' where ticketing_idx = #{ticketing_idx}")
	int ticketingCancel(@Param("ticketing_idx")int ticketing_idx);

	@Update("update cinemaSeat set reserved = 'n' where ticketing_idx=#{ticketing_idx}")
	int seatCancel(@Param("ticketing_idx")int ticketing_idx);

	@Select("select * from cinemaMovie")
	List<CinemaMovieDTO> movieList();
	

	
	
	
	
}
