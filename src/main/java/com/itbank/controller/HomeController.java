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
		
		String[] movieCodeList	= cms.movieCodeList();
		model.addAttribute("movieCodeList", movieCodeList); 
		return "home";
	}
	
	
	@GetMapping(value="/list",produces="application/json;charset=utf-8")
	@ResponseBody
	public String list(Model model) throws JsonProcessingException {
	
		List<CinemaScheduleHomeDTO> listMap = new ArrayList<CinemaScheduleHomeDTO>();

		String[] movieNameList = cms.movieNameList();
		String[] urlNameList = cms.urlNameList();
		int[] ageLimitList = cms.ageLimitList();
		int[] scheduleCountList = cms.scheduleCountList();
		
		for(int i=0;i<movieNameList.length;i++) {
			CinemaScheduleHomeDTO dto = new CinemaScheduleHomeDTO();
				dto.setMovieName(movieNameList[i]);
				dto.setUrlName(urlNameList[i]);
				dto.setAgeLimit(ageLimitList[i]);
				dto.setSchedule_allCount(scheduleCountList[i]);
				String[] start_timeList = cms.start_timeList(movieNameList[i]);
				String[] end_timeList = cms.end_timeList(movieNameList[i]);
				String[] hallNameList = cms.hallNameList(movieNameList[i]);
				int[] schedule_idxList = cms.Schedule_idxList(movieNameList[i]);
				dto.setStart_time(start_timeList);
				dto.setEnd_time(end_timeList);
				dto.setSchedule_idx(schedule_idxList);
				dto.setHallName(hallNameList);
				listMap.add(dto);
	
		}
		
		String jsonData = mapper.writeValueAsString(listMap);

		return jsonData;
	}
	

	
}
