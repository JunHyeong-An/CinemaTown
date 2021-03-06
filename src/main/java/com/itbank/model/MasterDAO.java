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
	
	// 마스터 분실물 게시글 페이징
	@Select("select count(*) from cinemaLost")
	int selectCount();
	
	// 마스터 분실물 게시글 전체 불러오기 와 페이징
	@Select("select * from cinemaLost order by cinemaLost_idx desc offset #{offset} rows fetch first #{perPage} rows only")
	List<ServiceCenterDTO> lostList(@Param("offset")int offset,@Param("perPage")int perPage);

	// 마스터 분실물 글 하나를 클릭해서 보는것
	@Select("select * from cinemaLost where cinemaLost_idx=#{cinemaLost_idx}")
	ServiceCenterDTO LostEach(int cinemaLost_idx);
	
	// 마스터 1:1 문의 게시글 페이징
	@Select("select count(*) from oneToOne")
	int selectCount2();
	
	// 마스터 1:1 문의 게시글 전체불러오기 (날자순으로 불러오기)
	@Select("select * from oneToOne order by otoWriteDay desc offset #{offset} rows fetch first #{perPage} rows only")
	List<OneToOneDTO> oneToOneList(@Param("offset")int offset,@Param("perPage")int perPage);

	// 마스터 1:1문의 글 하나를 클릭해서 보는것
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

	@Select("select movieName, hallName,showDay, to_char(startTime,'HH24:mi') as start_time, to_char(endTime,'HH24:mi') as end_time" + 
			" from cinemaSchedule" + 
			" join cinemaHall" + 
			" on cinemaHall.hall_idx = cinemaSchedule.hall_idx where showDay >= to_char(sysdate,'yyyyMMdd') order by showDay, movieName, hallName,startTime")
	List<HashMap<String, String>> scheduleList();

	
	








	
}
