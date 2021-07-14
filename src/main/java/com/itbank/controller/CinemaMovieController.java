package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/ticketing")
	public String ticketing(Model model) {
		List<CinemaMovieDTO> movieList	=	cms.movieList();   
		model.addAttribute("movieList", movieList);
		
		return "cinemaMovie/ticketing";
	}
	
	@GetMapping(value="/ticketing/{movieName}/{showDay}/", produces="application/json;charset=utf-8")
	@ResponseBody
	public List<HashMap<String, Object>> ticketing(@PathVariable String movieName, @PathVariable String showDay){
		return cms.ticketingList(movieName, showDay);
	} 

	@GetMapping("/schedule")	///ticketing/{movieName}/{showDay}/
	public String schedule(Model model) {	//@pathValue �궗�슜�빐�꽌 �꽔�뼱二쇨린
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
	
	@PostMapping("")	// �삁留� 痍⑥냼 �떆 �룎�븘媛��뒗 硫붿꽌�뱶
	public String ticketingCancel(int ticketing_idx) {	// hidden�쑝濡� 諛쏆븘�삤�옄
		cms.ticketingCancel(ticketing_idx);
		return "redirect:/";
	}
	
	

	
}
