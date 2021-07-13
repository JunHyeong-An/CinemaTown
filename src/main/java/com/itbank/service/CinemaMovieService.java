package com.itbank.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDAO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.CinemaTicketingDTO;
import com.itbank.model.CinemaUserDTO;

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

		CinemaHallDTO hall_dto = dao.hallInfo(hallName);
		dto.setHall_idx(hall_dto.getHall_idx());
		dto.setSeatCountRemain(hall_dto.getSeatCountAll());
				
		Date endTime = new Date(dto.getStartTime().getTime()+dao.runningTime(dto.getMovieName())*60000);
		dto.setEndTime(endTime);
		return dao.insertMovie(dto);
	
	}

	public int ticketing(CinemaTicketingDTO dto, int schedule_idx, HttpSession session) {
		// userId받아오기(로그인 세션값으로 들고오기)
		CinemaUserDTO login = (CinemaUserDTO) session.getAttribute("login");
		dto.setUserId(login.getUserId());
		
		// schedule_idx받아오기
//		dto.setSchedule_idx();
		
		
		// hall_idx받아오기(Hall테이블에서 받아올지 schedule테이블에서 join해서 가져올지 생각해보기)
//		dto.setHall_idx(hall_idx);
		
			
		return dao.ticketing(dto);
	}

	public int seatInsert(int ticketing_idx, String seatName) {
	
		return dao.seatInsert(ticketing_idx, seatName);
	}

	public int getTicketing_idx() {
		
		return dao.getTicketing_idx();
	}

	// 예매 취소 시 => 예매 취소, 좌석 취소, 결제 취소, 매출 취소
	public void ticketingCancel(int ticketing_idx) {
		dao.ticketingCancel(ticketing_idx);		// 예매티켓 취소시 schedule_idx반환하기	==> mybatis이용
		int schedule_idx = 0;
		dao.seatCancel(ticketing_idx);		// 예매 자리 취소 시 해당 adultCount + teenagerCount값 가져오기	==> mybatis이용
		int seatCountRemainAdd = 0;
		dao.seatCountRemainAdd(schedule_idx, seatCountRemainAdd);// 남은 좌석 수 다시 추가되기
		int payment_idx = dao.paymentCancel(ticketing_idx);	// 예매 결제 취소시 해당 payment_idx값 가져오기	==> mybatis이용
		dao.salesCancel(payment_idx);					// 매출 취소
		
		
	}

	public List<CinemaMovieDTO> movieList() {

		return dao.movieList();
	}
	

	
	
	// seatCountRemain 계산도 들어가야함.결제시 -, 취소시+ => update 시키기
			// ㄴ>예매테이블과 조인하기
	//ajax로 결제 취소와 결제완료시 각각 url을 통해 join해서 성인 수+ 청소년 수 값을 구해 계산하기
	
	
	
	
	
	
}
