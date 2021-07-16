package com.itbank.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.CinemaHallDAO;
import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDAO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaPaymentDAO;
import com.itbank.model.CinemaSalesDAO;
import com.itbank.model.CinemaScheduleDAO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.CinemaSeatDAO;
import com.itbank.model.CinemaTicketingDAO;
import com.itbank.model.CinemaTicketingDTO;
import com.itbank.model.CinemaUserDTO;

@Service
public class CinemaMovieService {
	
	@Autowired private CinemaMovieDAO movie_dao;
	@Autowired private CinemaSeatDAO seat_dao;
	@Autowired private CinemaTicketingDAO ticketing_dao;
	@Autowired private CinemaScheduleDAO schedule_dao;
	@Autowired private CinemaHallDAO hall_dao;
	@Autowired private CinemaPaymentDAO payment_dao;
	@Autowired private CinemaSalesDAO sales_dao;


	// 예매리스트
	public List<HashMap<String, Object>> ticketingList(String movieName,String showDay ) {

		return movie_dao.ticketingList(movieName, showDay);
	}



	// 예매하기, 결제하기, 매출등록 
	@Transactional
	public int ticketing(CinemaTicketingDTO dto) {

		// 예매하기
		ticketing_dao.ticketing(dto);
		int ticketing_idx = dto.getTicketing_idx();

		// 좌석 테이블에 추가
		String[] seatNameAll = dto.getSeatNameAll().split(",");
		for (String seatName : seatNameAll) {

			seat_dao.seatInsert(ticketing_idx, seatName, dto.getSchedule_idx());
		}

		// 상영일정에 남은 좌석 -하기
		int seatCountRemainMinus = dto.getAdultCount() + dto.getTeenagerCount();
		schedule_dao.seatCountRemainMinus(dto.getSchedule_idx(), seatCountRemainMinus); 
																						
		// 결제 insert하기
		int totalAmount = dto.getAdultCount() * 14000 + dto.getTeenagerCount() * 11000;
		payment_dao.payment(ticketing_idx, dto.getUserId(), totalAmount);
		// ㄴ> card테이블 보완해야함

		// 매출 insert하기
		int payment_idx = payment_dao.getPayment_idx();
		
		return sales_dao.sales(payment_idx, dto.getSchedule_idx(), totalAmount);

	}


	// 예매 취소 시 => 예매 취소, 좌석 취소, 결제 취소, 매출 취소
	@Transactional
	public void ticketingCancel(int ticketing_idx) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ticketing_dao.ticketingCancel(ticketing_idx);
		int schedule_idx = (Integer)map.get("schedule_idx");

		int seatCountRemainAdd = seat_dao.seatCancel(ticketing_idx);
		schedule_dao.seatCountRemainAdd(schedule_idx, seatCountRemainAdd);

		payment_dao.paymentCancel(ticketing_idx);
		int payment_idx = (Integer)map.get("payment_idx");// 예매 결제 취소시 해당 payment_idx값 가져오기
		
		sales_dao.salesCancel(payment_idx); // 매출 취소

	}

	public List<CinemaMovieDTO> movieList() {

		return movie_dao.movieList();
	}

	// HomeController에 띄울 영화 url 목록
	public String[] movieUrlList() {
		
		return movie_dao.movieUrlList();
	}
	
	public String[] movieNameList() {
		return movie_dao.movieNameList();
		
	}

	public String[] start_timeList(String movieName) {

		return movie_dao.start_timeList(movieName);
	}

	public String[] hallNameList(String movieName) {

		return movie_dao.hallNameList(movieName);
	}

	public int[] scheduleCountList() {
		
		return movie_dao.scheduleCountList();
	}


	public String[] movieName() {
		
		return movie_dao.movieName();
	}
	
	

	// ajax로 결제 취소와 결제완료시 각각 url을 통해 join해서 성인 수+ 청소년 수 값을 구해 계산하기
		
	
	
}
