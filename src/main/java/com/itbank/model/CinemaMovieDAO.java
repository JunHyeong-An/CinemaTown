package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface CinemaMovieDAO {

	// �삁留ㅻ━�뒪�듃(�쁺�솕�씠由꾧낵 �궇吏쒕�� 諛쏅뒗�떎.)
	@Select("select cinemaMovie.movieName,cinemaSchedule.showDay,cinemaSchedule.seatCountRemain,to_char(cinemaSchedule.startTime,'HH24:mi') as start_time, to_char(cinemaSchedule.endTime,'HH24:mi') as end_time," + 
			"    cinemaHall.hallName,cinemaHall.seatCountAll, cinemaschedule.schedule_idx" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaMovie.movieName = #{movieName}  and cinemaSchedule.showDay = #{showDay}")
	List<HashMap<String, Object>> ticketingList(@Param("movieName") String movieName, @Param("showDay") String showDay);

	// �긽�쁺�떆媛꾪몴 由ъ뒪�듃(�궇吏쒕쭔 諛쏅뒗�떎.)
	@Select("select cinemaMovie.movieName,cinemaSchedule.showDay,to_char(cinemaSchedule.startTime,'HH24:mi') as start_time," + 
			"    cinemaHall.hallName" + 
			"    from cinemaMovie" + 
			"    full outer join cinemaSchedule" + 
			"    on cinemaMovie.movieName = cinemaSchedule.movieName" + 
			"    full outer join cinemaHall" + 
			"    on cinemaSchedule.hall_idx = cinemaHall.hall_idx" + 
			"    where cinemaSchedule.showDay = '20210709'")
	List<HashMap<String, Object>> screenScheduleList();

	// �긽�쁺�씪�젙 �궡�슜 �뀒�씠釉붿뿉 �궫�엯(愿�由ъ옄�럹�씠吏�)
	@Insert("insert into cinemaSchedule(movieName, hall_idx, showDay, startTime, endTime, seatCountRemain) values(#{movieName},#{hall_idx},#{showDay},#{startTime},#{endTime},#{seatCountRemain})")
	int insertMovie(CinemaScheduleDTO dto);

	// �긽�쁺�씪�젙 �궫�엯 �떆 醫낅즺�떆媛� �꽔湲곗쐞�빐�꽌 cinemaMovie�뀒�씠釉붿뿉�꽌 �윭�떇���엫 諛쏆븘�삤�뒗 寃�(愿�由ъ옄�럹�씠吏�)
	@Select("select runningTime from cinemaMovie where movieName = #{movieName}")
	long runningTime(@Param("movieName")String movieName);

	// �긽�쁺�씪�젙 �궫�엯 �떆 �븘�슂�븳  hall_idx�� 珥� 醫뚯꽍�쓣 �긽�쁺愿� �뀒�씠釉붿뿉�꽌 諛쏆븘�삤湲� �쐞�븳 寃� 
	@Select("select * from cinemaHall where hallName=#{hallName}")
	CinemaHallDTO hallInfo(@Param("hallName") String hallName);

	// �삁留ㅽ븷 �븣 �삁留� �궡�슜 �궫�엯
	@Insert("insert into cinemaTicketing(userId, schedule_idx, hall_idx, seatNameAll, adultCount, teenagerCount) values('admin', 12, 4, #{seatNameAll}, #{adultCount}, #{teenagerCount})")
	int ticketing(CinemaTicketingDTO dto);
	
	// �삁留ㅽ븷 �븣 �빐�떦醫뚯꽍�쓣 for臾� �룎由ш린�쐞�빐 ticketing_idx�쓣 �꽔�뼱二쇨린 �쐞�빐 遺덈윭�삤湲�
	@Select("select max(ticketing_idx) from cinemaTicketing")
	int getTicketing_idx();
	
	// �삁留ㅽ븷 �븣 醫뚯꽍愿��젴 �궡�슜�쓣 �뀒�씠釉붿뿉 �궫�엯
	@Insert("insert into cinemaSeat(ticketing_idx, seatName) values(#{ticketing_idx}, #{seatName})")
	int seatInsert(@Param("ticketing_idx")int ticketing_idx, @Param("seatName")String seatName);

	// �삁留� 痍⑥냼 �떆 �떚耳� 痍⑥냼 ==> �븞�릺硫� mybatis濡� �빐�빞�븿!
	@Update("update cinemaTicketing set deleted = 'y' where ticketing_idx = #{ticketing_idx}")
	int ticketingCancel(@Param("ticketing_idx")int ticketing_idx);

	// �삁留� 痍⑥냼 �떆 醫뚯꽍 痍⑥냼  ==> �븞�릺硫� mybatis濡� �빐�빞�븿!
	@Update("update cinemaSeat set reserved = 'n' where ticketing_idx=#{ticketing_idx}")
	int seatCancel(@Param("ticketing_idx")int ticketing_idx);
	
	// �삁留� 痍⑥냼 �떆 寃곗젣 痍⑥냼  ==> �븞�릺硫� mybatis濡� �빐�빞�븿!
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
