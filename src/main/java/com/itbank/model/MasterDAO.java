package com.itbank.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MasterDAO {

	@Select("select sum(price) as sum, cinemaMovie.movieName, cinemaMovie.urlName " + 
			"    from cinemasales " + 
			"    join cinemaMovie" + 
			"    on cinemaMovie.movieName = cinemaSales.movieName" + 
			"    GROUP BY cinemaMovie.movieName, cinemaMovie.urlName")
	List<HashMap<String, Object>> movieSales();

	@Select("select salesday, sum(price) as sum  " + 
			"    from cinemasales  " + 
			"    group by salesday")
	List<HashMap<String, Object>> monthSales();
	
	@Select("select * from cinemaLost")
	List<ServiceCenterDTO> lostList();

	@Select("select * from oneToOne order by otoWriteDay desc")
	List<OneToOneDTO> oneToOneList();

	@Select("select * from oneToOne where oneToOne_idx=#{oneToOne_idx}")
	OneToOneDTO EachOneToOne(int oneToOne_idx);

	@Insert("insert into oneToOneAnswer(oneToOne_idx,answerContent) values(#{oneToOne_idx},#{answerContent})")
	int oneToOneAnswer(OneToOneAnswerDTO dto);

	@Select("select * from oneToOneAnswer")
	List<OneToOneAnswerDTO> replyList();

	@Update("update oneToOneAnswer set answerContent = '#{answerContent}' where oneToOneAnswer_idx = '#{oneToOneAnswer_idx}'")
	int oneToOneAnswerModify(OneToOneAnswerDTO dto);
	
	@Select("select * from cinemaMovie where deleted='n' order by movieName desc")
	List<CinemaMovieDTO> movieList();
	
	@Insert("insert into cinemaMovie (movieName, ageLimit, runningTime, urlName, movieCode) values (#{movieName}, #{ageLimit}, #{runningTime}, #{urlName}, #{movieCode})")
	int insert(CinemaMovieDTO dto);

	
	@Select("select * from cinemaHall order by hall_idx")
	List<CinemaHallDTO> hallList();
	
	@Select("select count(*) " + 
			"from cinemaSchedule " + 
			"full outer join cinemaHall " + 
			"on cinemaSchedule.hall_idx = cinemaHall.hall_idx " + 
			"where cinemaHall.hallName=#{hallName} and to_char(startTime,'yyyymmddHH24mi') < #{scheduleTime} and #{scheduleTime} < to_char(endTime,'yyyymmddHH24mi')")
	int scheduleCheck(HashMap<String, String> map);
	
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

	@Delete("update cinemaMovie set deleted='y' where movieName = #{movieName}")
	void deleteMovie(String movieName);

	@Delete("delete from cinemaEventList where event_idx = #{event_idx}")
	int eventDelete(int event_idx);




	
}
