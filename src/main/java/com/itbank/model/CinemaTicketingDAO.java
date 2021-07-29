package com.itbank.model;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CinemaTicketingDAO {

	// 예매할 때 예매 내용 삽입
	int ticketing(CinemaTicketingDTO dto);
	
	// 예매 취소 시 티켓 취소
	@Update("update cinemaTicketing set deleted = 'y' where ticketing_idx = #{ticketing_idx}")
	int ticketingCancel(int ticketing_idx);


	@Select("select SCHEDULE_IDX from cinemaTicketing where ticketing_idx = #{ticketing_idx}")
	int getSchedule_idx(int ticketing_idx);

}
