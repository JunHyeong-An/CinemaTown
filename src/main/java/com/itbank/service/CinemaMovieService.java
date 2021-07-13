package com.itbank.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDAO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.CinemaTicketingDTO;

@Service
public class CinemaMovieService {

	
	@Autowired private CinemaMovieDAO dao;

	public List<HashMap<String, Object>> ticketingList() {
		
		return dao.ticketingList();
	}

	public List<HashMap<String, Object>> screenScheduleList() {
		
		return dao.screenScheduleList();
	}

	public int insertMovie(CinemaScheduleDTO dto, String hallName) {
		// seatCountRemain이 처음에는 hall_idx의 총 좌석수가 들어가야한다.
		// hall_idx 불러오는 메서드 필요
		// ㄴ>위 두 개합쳐서 cinemaScheduleDTO에 담아서 2개 각각 사용하기
		CinemaHallDTO hall_dto = dao.hallInfo(hallName);
		dto.setHall_idx(hall_dto.getHall_idx());
		dto.setSeatCountRemain(hall_dto.getSeatCountAll());
				
		Date endTime = new Date(dto.getStartTime().getTime()+dao.runningTime(dto.getMovieName())*60000);
		dto.setEndTime(endTime);
		return dao.insertMovie(dto);
	
	}

	public int ticketing(CinemaTicketingDTO dto) {
		// userId받아오기(로그인 세션값으로 들고오기)
		
		
		// schedule_idx받아오기
		
		
		// hall_idx받아오기(Hall테이블에서 받아올지 schedule테이블에서 join해서 가져올지 생각해보기)
	
			
		return dao.ticketing(dto);
	}

	public int seatInsert(int ticketing_idx, String seatName) {
	
		return dao.seatInsert(ticketing_idx, seatName);
	}

	public int getTicketing_idx() {
		
		return dao.getTicketing_idx();
	}

	public int ticketingCancel(int ticketing_idx) {
		dao.seatCancel(ticketing_idx);
		return	dao.ticketingCancel(ticketing_idx);
		
	}

	
	

	
	
	// seatCountRemain 계산도 들어가야함.결제시 -, 취소시+ => update 시키기
			// ㄴ>예매테이블과 조인하기
	//ajax로 결제 취소와 결제완료시 각각 url을 통해 join해서 성인 수+ 청소년 수 값을 구해 계산하기
	
	
	
	
	
	
}
