package com.itbank.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CinemaScheduleDAO {

	// 상영일정 내용 테이블에 삽입(관리자페이지)
	@Insert("insert into cinemaSchedule(movieName, hall_idx, showDay, startTime, endTime, seatCountRemain) values(#{movieName},#{hall_idx},#{showDay},#{startTime},#{endTime},#{seatCountRemain})")
	int insertMovie(CinemaScheduleDTO dto);
	
	// 예매 시
	@Update("update cinemaSchedule set seatCountRemain = seatCountRemain - #{seatCountRemain} where schedule_idx = #{schedule_idx} ")
	void seatCountRemainMinus(@Param("schedule_idx")int schedule_idx,@Param("seatCountRemain")int seatCountRemainMinus);
	
	// 예매 취소 시
	@Update("update cinemaSchedule set seatCountRemain = seatCountRemain + #{seatCountRemain} where schedule_idx = #{schedule_idx} ")
	void seatCountRemainAdd(@Param("schedule_idx")int schedule_idx,@Param("seatCountRemain")int seatCountRemainAdd);

	
}
