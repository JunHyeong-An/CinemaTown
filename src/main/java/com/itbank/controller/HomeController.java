package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.CinemaScheduleHomeDTO;
import com.itbank.service.CinemaMovieService;


@Controller
public class HomeController {
	
	@Autowired private CinemaMovieService cms;
	private ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/")
	public String home(Model model) {
		String[] movieUrlList	= cms.movieUrlList();
		String[] movieName	= cms.movieName();
		model.addAttribute("movieName", movieName); 
		model.addAttribute("movieUrlList", movieUrlList); 
		return "home";
	}
	
	
	@GetMapping(value="/list",produces="application/json;charset=utf-8")
	@ResponseBody
	public String list(Model model) throws JsonProcessingException {
	
		List<CinemaScheduleHomeDTO> listMap = new ArrayList<CinemaScheduleHomeDTO>();

		String[] movieNameList = cms.movieNameList();
		int[] scheduleCountList = cms.scheduleCountList();
		
		for(int i=0;i<movieNameList.length;i++) {
			CinemaScheduleHomeDTO dto = new CinemaScheduleHomeDTO();
				dto.setMovieName(movieNameList[i]);
				dto.setSchedule_allCount(scheduleCountList[i]);
				String[] start_timeList = cms.start_timeList(movieNameList[i]);
				String[] hallNameList = cms.hallNameList(movieNameList[i]);
				dto.setStart_time(start_timeList);
				dto.setHallName(hallNameList);
				listMap.add(dto);
		
		}
		
		String jsonData = mapper.writeValueAsString(listMap);

		return jsonData;
	}
	@GetMapping("/cinemaUser/tos")
	public String tospage() {
		return "/cinemaUser/tos";
	}
	
}
