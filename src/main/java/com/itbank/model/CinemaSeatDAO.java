package com.itbank.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface CinemaSeatDAO {
	
	// 예매할 때 좌석관련 내용을 테이블에 삽입
	@Insert("insert into cinemaSeat(ticketing_idx, seatName) values(#{ticketing_idx}, #{seatName})")
	int seatInsert(@Param("ticketing_idx") int ticketing_idx, @Param("seatName") String seatName);

	// 예매 취소 시 좌석 취소
	@Update("update cinemaSeat set reserved = 'n' where ticketing_idx=#{ticketing_idx}")
	int seatCancel(@Param("ticketing_idx")int ticketing_idx);
}
