package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CinemaTicketingDAO {

	// 예매할 때 예매 내용 삽입
	int ticketing(CinemaTicketingDTO dto);
	
	// 예매 취소 시 티켓 취소
	int ticketingCancel(@Param("ticketing_idx")int ticketing_idx);

	
	List<CinemaTicketingDTO> all();

}
