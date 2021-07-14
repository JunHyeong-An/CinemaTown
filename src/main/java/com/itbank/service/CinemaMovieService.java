package com.itbank.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	// 상영시간표 리스트
	public List<HashMap<String, Object>> screenScheduleList() {

		return movie_dao.screenScheduleList();
	}

	// 영화 스케줄 삽입 => 관리자 페이지 내용이므로 url설정 체크해보기★, 트랜잭션 추가하기★
	public int insertMovie(CinemaScheduleDTO dto, String hallName) {

		CinemaHallDTO hall_dto = hall_dao.hallInfo(hallName);
		dto.setHall_idx(hall_dto.getHall_idx());
		dto.setSeatCountRemain(hall_dto.getSeatCountAll());

		Date endTime = new Date(dto.getStartTime().getTime() + movie_dao.runningTime(dto.getMovieName()) * 60000);
		dto.setEndTime(endTime);
		return schedule_dao.insertMovie(dto);

	}

	// 예매하기, 결제하기, 매출등록 ==> 트랜잭션 추가하기★

	public int ticketing(CinemaTicketingDTO dto) {

		// 예매하기
		ticketing_dao.ticketing(dto);
		int ticketing_idx = dto.getTicketing_idx();

		// 좌석 테이블에 추가
		String[] seatNameAll = dto.getSeatNameAll().split(",");
		for (String seatName : seatNameAll) {

			seat_dao.seatInsert(ticketing_idx, seatName);
		}

		// 상영일정에 남은 좌석 -하기
		int seatCountRemainMinus = dto.getAdultCount() + dto.getTeenagerCount();
		schedule_dao.seatCountRemainMinus(dto.getSchedule_idx(), seatCountRemainMinus); // 예매 자리 취소 시 해당 adultCount +
																						// teenagerCount값 가져오기 ==>
																						

		// 결제 insert하기
		int totalAmount = dto.getAdultCount() * 14000 + dto.getTeenagerCount() * 11000;
		payment_dao.payment(ticketing_idx, dto.getUserId(), totalAmount);
		// ㄴ> card테이블 보완해야함

		// 매출 insert하기
		int payment_idx = payment_dao.getPayment_idx();
		
		return sales_dao.sales(payment_idx, dto.getSchedule_idx(), totalAmount);

	}


	// 예매 취소 시 => 예매 취소, 좌석 취소, 결제 취소, 매출 취소 ==> 트랜잭션 추가하기★
	public void ticketingCancel(int ticketing_idx) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		ticketing_dao.ticketingCancel(ticketing_idx);
		int schedule_idx = (Integer)map.get("schedule_idx");
		System.out.println(schedule_idx);

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
	

	
	
	// seatCountRemain 怨꾩궛�룄 �뱾�뼱媛��빞�븿.寃곗젣�떆 -, 痍⑥냼�떆+ => update �떆�궎湲�
			// �꽩>�삁留ㅽ뀒�씠釉붽낵 議곗씤�븯湲�
	//ajax濡� 寃곗젣 痍⑥냼�� 寃곗젣�셿猷뚯떆 媛곴컖 url�쓣 �넻�빐 join�빐�꽌 �꽦�씤 �닔+ 泥��냼�뀈 �닔 媛믪쓣 援ы빐 怨꾩궛�븯湲�
	
	
	
	
	
	
}
