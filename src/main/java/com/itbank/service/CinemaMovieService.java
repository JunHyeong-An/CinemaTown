package com.itbank.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.CinemaMovieDAO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaPaymentDAO;
import com.itbank.model.CinemaSalesDAO;
import com.itbank.model.CinemaScheduleDAO;
import com.itbank.model.CinemaSeatDAO;
import com.itbank.model.CinemaTicketingDAO;
import com.itbank.model.CinemaTicketingDTO;
import com.itbank.model.ReviewDAO;
import com.itbank.model.ReviewDTO;

@Service
public class CinemaMovieService {
	
	@Autowired private CinemaMovieDAO movie_dao;
	@Autowired private CinemaSeatDAO seat_dao;
	@Autowired private CinemaTicketingDAO ticketing_dao;
	@Autowired private CinemaScheduleDAO schedule_dao;
	@Autowired private CinemaPaymentDAO payment_dao;
	@Autowired private CinemaSalesDAO sales_dao;
	@Autowired private ReviewDAO review_dao;

//////////////////// CinemaMovieController ////////////////////////////////
	// 예매 사이트 들어가면 왼쪽에 영화 리스트 목록 불러오기
	public List<CinemaMovieDTO> movieList() {

		return movie_dao.movieList();
	}

	// 예매 사이트에서 선택된 영화와 날짜에 따른 상영일정 보여주기
	public List<HashMap<String, Object>> ticketingList(String movieName,String showDay ) {

		return movie_dao.ticketingList(movieName, showDay);
	}

	// 예매된 좌석 비활성화
	public String[] reservedSeats(int schedule_idx) {

		return seat_dao.reservedSeats(schedule_idx);
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
		ticketing_dao.ticketingCancel(ticketing_idx);
		int schedule_idx = ticketing_dao.getSchedule_idx(ticketing_idx);
		System.out.println(schedule_idx);
		int seatCountRemainAdd = seat_dao.seatCancel(ticketing_idx);
		schedule_dao.seatCountRemainAdd(schedule_idx, seatCountRemainAdd);

		payment_dao.paymentCancel(ticketing_idx);
		int payment_idx = payment_dao.getPayment_idxCancel(ticketing_idx);// 예매 결제 취소시 해당 payment_idx값 가져오기
		
		sales_dao.salesCancel(payment_idx); // 매출 취소

	}

	
////////////////////////// HomeController ///////////////////////////////	
	// HomeController 간이 상영시간표에 보여 줄 오늘 '영화이름들'
	public String[] movieNameList() {
		return movie_dao.movieNameList();
		
	}

	// HomeController 간이 상영시간표에 보여 줄 오늘 'URl'
	public String[] urlNameList() {
		
		return movie_dao.urlNameList();
	}

	// HomeController 간이 상영시간표에 보여 줄 오늘 '연령등급'
	public int[] ageLimitList() {
	
		return movie_dao.ageLimitList();
	}
	
	// HomeController 간이 상영시간표에 보여 줄 오늘 '시작시간들'
	public String[] start_timeList(String movieName) {

		return movie_dao.start_timeList(movieName);
	}

	public String[] end_timeList(String movieName) {
		
		return movie_dao.end_timeList(movieName);
	}
	
	// HomeController 간이 상영시간표에 보여 줄 오늘 '상영관들'
	public String[] hallNameList(String movieName) {

		return movie_dao.hallNameList(movieName);
	}

	// HomeController 간이 상영시간표에 보낼 schedule_idx
	public int[] Schedule_idxList(String movieName) {
	
		return movie_dao.Schedule_idxList(movieName);
	}
	
	// HomeController 간이 상영시간표에 for문돌리기 위해 가져 올 '해당 영화의 상영개수'
	public int[] scheduleCountList() {
		
		return movie_dao.scheduleCountList();
	}

	// home페이지에 포스터 보여주기 위해 불러 올 영화 code리스트
	public String[] movieCodeList() {
		
		return movie_dao.movieCodeList();
	}

	// 영화 리뷰 등록 하는 것
	public int reviewAdd(HashMap<String, String> map) {
		return review_dao.reviewAdd(map);
	}

	public List<ReviewDTO> reviewList(String movieNm, String rowMax) {
		return review_dao.reviewList(movieNm,rowMax);
	}

	public List<CinemaEventListDTO> listEvent() {
		return movie_dao.mainEvent();
	}

	public List<CinemaEventListDTO> selectEvent(int event_idx) {
		return movie_dao.selectEvent(event_idx);
	}
	
	public String teaserUrl(String movieName) {
		return movie_dao.teaserUrl(movieName);
	}






		
	
	
}
