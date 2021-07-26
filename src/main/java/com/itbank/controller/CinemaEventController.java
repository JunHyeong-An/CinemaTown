package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.service.EventService;
import com.itbank.service.MasterService;

@Controller
@RequestMapping("/cinemaEvent")
public class CinemaEventController {

	@Autowired private EventService es;
	
	@GetMapping("/movieEvent")
	public ModelAndView eventList() {
		ModelAndView mav = new ModelAndView("cinemaEvent/movieEvent");
		
		// 현재 진행중인 이벤트 리스트
		List<CinemaEventListDTO> list = es.selectList();
		
		// 종료된 이벤트 리스트
		List<CinemaEventListDTO> list2 = es.selectList2();

		mav.addObject("list", list);
		mav.addObject("list2", list2);
		return mav;
		
	}
	
	// 이벤트 리스트중 한개를 끌어와서 그 리스트에 대한 내용 끌어오기
	@GetMapping("/movieEventRead/{event_idx}")
	public ModelAndView read(@PathVariable int event_idx) {
		ModelAndView mav = new ModelAndView("cinemaEvent/movieEventRead");
		List<CinemaEventListDTO> list = es.selectOne(event_idx);
		mav.addObject("list", list);
		return mav;
	}
	
}
