package com.itbank.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.CinemaScheduleListDTO;
import com.itbank.model.CinemaTicketingDTO;
import com.itbank.service.CinemaMovieService;
import com.itbank.service.CinemaScheduleListService;


@Controller
@RequestMapping("/cinemaMovie")
public class CinemaMovieController {

	@Autowired private CinemaMovieService cms;
	@Autowired private CinemaScheduleListService csls;
	private ObjectMapper mapper = new ObjectMapper();
	
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
		// 다시 작업
		return "cinemaMovie/schedule";
	}
	
	
	
	// 예매하기
	@PostMapping("/ticketing/{ticketingJson}/")
	@ResponseBody
	public int ticketing(@PathVariable String ticketingJson, CinemaTicketingDTO dto, HttpSession session) throws JsonMappingException, JsonProcessingException {

		HashMap<String, String> map = new HashMap<String, String>();
		
		map = mapper.readValue(ticketingJson, new TypeReference<HashMap<String,String>>() {});
		

		// userId받아오기(로그인 세션값으로 들고오기)
		String userId = (String)session.getAttribute("userId");
		dto.setUserId(userId);

		// 예매 insert하기
		int schedule_Idx = Integer.parseInt(map.get("scheduleIdx"));
		dto.setSchedule_idx(schedule_Idx);
		
		dto.setSeatNameAll(map.get("selectSeats"));
		dto.setAdultCount(Integer.parseInt(map.get("adultCnt")));
		dto.setTeenagerCount(Integer.parseInt(map.get("studentCnt")));
		int result = cms.ticketing(dto);
		
		if(result == 1) { return 1; }
		
		return 0;

	}
	
	// 예매 취소 시 돌아가는 메서드 ==> 주소 넣어야함
	@PostMapping("")
	public String ticketingCancel(int ticketing_idx) {	// hidden으로 받아오자
		cms.ticketingCancel(ticketing_idx);
		return "redirect:/";
	}
	
	@GetMapping("/movieInfo")
	public String movieInfo() {
		return "cinemaMovie/movieInfo";
	}
	
	@GetMapping(value="/schedule/list",produces="application/json;charset=utf-8")
	@ResponseBody
	public String scheduleList(Model model) throws JsonProcessingException {
	
		List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();

		String[] movieNameList = csls.movieNameList();
		
		for(int i=0;i<movieNameList.length;i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("movieName", movieNameList[i]);
				int[] scheduleCountList = csls.scheduleCountList(movieNameList[i]);
				String[] hallNameList = csls.hallNameList(movieNameList[i]);
				
				for(int j=0;j<scheduleCountList.length;j++) {
					CinemaScheduleListDTO dto = new CinemaScheduleListDTO();
					
					dto.setSchedule_allCount(scheduleCountList[j]);
					dto.setHallName(hallNameList[j]);
					String[] start_timeList = csls.start_timeList(movieNameList[i], hallNameList[j]);
					String[] end_timeList = csls.end_timeList(movieNameList[i],hallNameList[j]);
					dto.setStart_time(start_timeList);
					dto.setEnd_time(end_timeList);
					map.put(Integer.toString(j), dto);
					
				}
				listMap.add(map);
		}

		System.out.println(listMap);
		String jsonData = mapper.writeValueAsString(listMap);
		System.out.println(jsonData);
		return jsonData;
	}	
	

	
}
