package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.CinemaScheduleHomeDTO;
import com.itbank.service.CinemaMovieService;


@Controller
public class HomeController {
	
	@Autowired private CinemaMovieService cms;
	private ObjectMapper mapper = new ObjectMapper();
	
	// Home에 이벤트 이미지 띄우기
	@GetMapping("/")
	public String home(Model model) {
		
		String[] movieCodeList	= cms.movieCodeList();
		List<CinemaEventListDTO> mainEvent = cms.listEvent();
		model.addAttribute("movieCodeList", movieCodeList); 
		model.addAttribute("mainEvent", mainEvent);
		return "home";
	}
	
	// 이벤트 이미지 클릭 시 이벤트 상세 내용 나오는 페이지
	@GetMapping("/homeEventRead/{event_idx}")
	public ModelAndView read(@PathVariable int event_idx) {
		ModelAndView mav = new ModelAndView("/homeEventRead");
		List<CinemaEventListDTO> list = cms.selectEvent(event_idx);
		mav.addObject("list", list);
		return mav;
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
