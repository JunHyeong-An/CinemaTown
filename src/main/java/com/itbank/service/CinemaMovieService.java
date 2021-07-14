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

	public List<HashMap<String, Object>> ticketingList(String movieName, String showDay) {
		
		return dao.ticketingList(movieName, showDay);
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
		// userId諛쏆븘�삤湲�(濡쒓렇�씤 �꽭�뀡媛믪쑝濡� �뱾怨좎삤湲�)
		CinemaUserDTO login = (CinemaUserDTO) session.getAttribute("login");
		dto.setUserId(login.getUserId());
		
		// schedule_idx諛쏆븘�삤湲�
//		dto.setSchedule_idx();
		
		
		// hall_idx諛쏆븘�삤湲�(Hall�뀒�씠釉붿뿉�꽌 諛쏆븘�삱吏� schedule�뀒�씠釉붿뿉�꽌 join�빐�꽌 媛��졇�삱吏� �깮媛곹빐蹂닿린)
//		dto.setHall_idx(hall_idx);
		
			
		return dao.ticketing(dto);
	}

	public int seatInsert(int ticketing_idx, String seatName) {
	
		return dao.seatInsert(ticketing_idx, seatName);
	}

	public int getTicketing_idx() {
		
		return dao.getTicketing_idx();
	}

	// �삁留� 痍⑥냼 �떆 => �삁留� 痍⑥냼, 醫뚯꽍 痍⑥냼, 寃곗젣 痍⑥냼, 留ㅼ텧 痍⑥냼
	public void ticketingCancel(int ticketing_idx) {
		dao.ticketingCancel(ticketing_idx);		// �삁留ㅽ떚耳� 痍⑥냼�떆 schedule_idx諛섑솚�븯湲�	==> mybatis�씠�슜
		int schedule_idx = 0;
		dao.seatCancel(ticketing_idx);		// �삁留� �옄由� 痍⑥냼 �떆 �빐�떦 adultCount + teenagerCount媛� 媛��졇�삤湲�	==> mybatis�씠�슜
		int seatCountRemainAdd = 0;
		dao.seatCountRemainAdd(schedule_idx, seatCountRemainAdd);// �궓�� 醫뚯꽍 �닔 �떎�떆 異붽��릺湲�
		int payment_idx = dao.paymentCancel(ticketing_idx);	// �삁留� 寃곗젣 痍⑥냼�떆 �빐�떦 payment_idx媛� 媛��졇�삤湲�	==> mybatis�씠�슜
		dao.salesCancel(payment_idx);					// 留ㅼ텧 痍⑥냼
		
		
	}

	public List<CinemaMovieDTO> movieList() {

		return dao.movieList();
	}

	// HomeController에 띄울 영화 제목 목록
	public String[] movieNameList() {
		
		return dao.movieNameList();
	}
	

	
	
	// seatCountRemain 怨꾩궛�룄 �뱾�뼱媛��빞�븿.寃곗젣�떆 -, 痍⑥냼�떆+ => update �떆�궎湲�
			// �꽩>�삁留ㅽ뀒�씠釉붽낵 議곗씤�븯湲�
	//ajax濡� 寃곗젣 痍⑥냼�� 寃곗젣�셿猷뚯떆 媛곴컖 url�쓣 �넻�빐 join�빐�꽌 �꽦�씤 �닔+ 泥��냼�뀈 �닔 媛믪쓣 援ы빐 怨꾩궛�븯湲�
	
	
	
	
	
	
}
