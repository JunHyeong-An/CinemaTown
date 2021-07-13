package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.CinemaTicketingDTO;
import com.itbank.service.CinemaMovieService;


@Controller
@RequestMapping("/cinemaMovie")
public class CinemaMovieController {

	@Autowired private CinemaMovieService cms;
	
	@GetMapping("/ticketing")	///ticketing/{movieName}/{showDay}/
	public String ticketing(Model model) {	//@pathValue 사용해서 넣어주기
		List<CinemaMovieDTO> movieList	=	cms.movieList();   
		model.addAttribute("movieList", movieList);
		
		return "cinemaMovie/ticketing";
	}
	
	@PostMapping(value="/ticketing/{movieName}/{showDay}/", produces="application/json;charset=utf-8")
	@ResponseBody
	public List<HashMap<String, Object>> ticketing(){
		return cms.ticketingList();
	} 

	@GetMapping("/schedule")	///ticketing/{movieName}/{showDay}/
	public String schedule(Model model) {	//@pathValue 사용해서 넣어주기
		List<HashMap<String, Object>> screenScheduleList = cms.screenScheduleList();
		model.addAttribute("screenScheduleList", screenScheduleList);
		return "cinemaMovie/schedule";
	}
	
	
	@GetMapping("/insertMovie")
	public String insertMovie() {
		return "cinemaMovie/insertMovie";
	}
	
	@PostMapping("/insertMovie")
	public String insertMovie2(CinemaScheduleDTO dto, String hallName) {
		int row = cms.insertMovie(dto, hallName);
		return "redirect:/";
	}
	
	
	@PostMapping("/ticketing2")
	public String ticketing2(CinemaTicketingDTO dto, int schedule_idx) {
		
//		int row = cms.ticketing(dto,schedule_idx);
		int ticketing_idx = cms.getTicketing_idx();
		
		
		String[] seatNameAll = dto.getSeatNameAll().split(",");
		for(String seatName : seatNameAll) {
		
			cms.seatInsert(ticketing_idx,seatName);
		}
	
		return "redirect:/";
	}
	
	@PostMapping("")	// 예매 취소 시 돌아가는 메서드
	public String ticketingCancel(int ticketing_idx) {	// hidden으로 받아오자
		cms.ticketingCancel(ticketing_idx);
		return "redirect:/";
	}
	
	

	
}
