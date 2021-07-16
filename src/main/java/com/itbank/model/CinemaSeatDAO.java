package com.itbank.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CinemaSeatDAO {
	
	// 예매할 때 좌석관련 내용을 테이블에 삽입
	@Insert("insert into cinemaSeat(ticketing_idx, seatName, schedule_idx) values(#{ticketing_idx}, #{seatName}, #{schedule_idx})")
	int seatInsert(@Param("ticketing_idx") int ticketing_idx, @Param("seatName") String seatName, @Param("schedule_idx")int schedule_idx);

	// 예매 취소 시 좌석 취소
	@Update("update cinemaSeat set reserved = 'n' where ticketing_idx=#{ticketing_idx}")
	int seatCancel(@Param("ticketing_idx")int ticketing_idx);
}
