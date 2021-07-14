package com.itbank.model;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CinemaHallDAO {

	// 상영일정 삽입 시 필요한 hall_idx와 총 좌석을 상영관 테이블에서 받아오기 위한 것
	@Select("select * from cinemaHall where hallName=#{hallName}")
	CinemaHallDTO hallInfo(@Param("hallName") String hallName);

}
