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
			"    cinemaHall.hallName,cinemaHall.seatCountAll, cinemaschedule.schedule_idx" + 
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

	// 상영일정 내용 테이블에 삽입(관리자페이지)
	@Insert("insert into cinemaSchedule(movieName, hall_idx, showDay, startTime, endTime, seatCountRemain) values(#{movieName},#{hall_idx},#{showDay},#{startTime},#{endTime},#{seatCountRemain})")
	int insertMovie(CinemaScheduleDTO dto);

	// 상영일정 삽입 시 종료시간 넣기위해서 cinemaMovie테이블에서 러닝타임 받아오는 것(관리자페이지)
	@Select("select runningTime from cinemaMovie where movieName = #{movieName}")
	long runningTime(@Param("movieName")String movieName);

	// 상영일정 삽입 시 필요한  hall_idx와 총 좌석을 상영관 테이블에서 받아오기 위한 것 
	@Select("select * from cinemaHall where hallName=#{hallName}")
	CinemaHallDTO hallInfo(@Param("hallName") String hallName);

	// 예매할 때 예매 내용 삽입
	@Insert("insert into cinemaTicketing(userId, schedule_idx, hall_idx, seatNameAll, adultCount, teenagerCount) values('admin', 12, 4, #{seatNameAll}, #{adultCount}, #{teenagerCount})")
	int ticketing(CinemaTicketingDTO dto);
	
	// 예매할 때 해당좌석을 for문 돌리기위해 ticketing_idx을 넣어주기 위해 불러오기
	@Select("select max(ticketing_idx) from cinemaTicketing")
	int getTicketing_idx();
	
	// 예매할 때 좌석관련 내용을 테이블에 삽입
	@Insert("insert into cinemaSeat(ticketing_idx, seatName) values(#{ticketing_idx}, #{seatName})")
	int seatInsert(@Param("ticketing_idx")int ticketing_idx, @Param("seatName")String seatName);

	// 예매 취소 시 티켓 취소 ==> 안되면 mybatis로 해야함!
	@Update("update cinemaTicketing set deleted = 'y' where ticketing_idx = #{ticketing_idx}")
	int ticketingCancel(@Param("ticketing_idx")int ticketing_idx);

	// 예매 취소 시 좌석 취소  ==> 안되면 mybatis로 해야함!
	@Update("update cinemaSeat set reserved = 'n' where ticketing_idx=#{ticketing_idx}")
	int seatCancel(@Param("ticketing_idx")int ticketing_idx);
	
	// 예매 취소 시 결제 취소  ==> 안되면 mybatis로 해야함!
	@Update("update cinemaPayment set canceled = 'y' where ticketing_idx=#{ticketing_idx}")
	@SelectKey(before = false,keyColumn = "payment_idx",keyProperty = "payment_idx",resultType = Integer.class,statement = "select last_update_idx()")
	int paymentCancel(@Param("ticketing_idx")int ticketing_idx);

	@Update("update cinemaSales set price = 0 where payment_idx = #{payment_idx}")
	void salesCancel(@Param("payment_idx")int payment_idx);

	@Update("update cinemaSchedule set seatCountRemain = seatCountRemain + #{seatCountRemain} where schedule_idx = #{schedule_idx} ")
	void seatCountRemainAdd(@Param("@Param")int schedule_idx,@Param("seatCountRemain")int seatCountRemainAdd);
	

	@Select("select * from cinemaMovie")
	List<CinemaMovieDTO> movieList();
	
	
	
}
