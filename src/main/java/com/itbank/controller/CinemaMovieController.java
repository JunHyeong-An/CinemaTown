package com.itbank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleListDTO;
import com.itbank.model.CinemaTicketingDTO;
import com.itbank.model.CinemaUserDTO;
import com.itbank.model.ReviewDTO;
import com.itbank.service.CinemaMovieService;
import com.itbank.service.CinemaScheduleListService;
import com.itbank.service.CinemaUserService;
import com.itbank.service.KakaoPayService;
import com.itbank.service.MovieVodUrlService;


@Controller
@RequestMapping("/cinemaMovie")
public class CinemaMovieController {

	@Autowired private CinemaMovieService cms;
	@Autowired private CinemaUserService cus;
	@Autowired private CinemaScheduleListService csls;
	@Autowired private KakaoPayService kps;
	@Autowired private MovieVodUrlService mvs;
	private ObjectMapper mapper = new ObjectMapper();
	
	// 영화 정보 페이지 보여주기
	@GetMapping("/movieInfo")
	public String movieInfo(HttpServletRequest request, HttpSession session, Model model) {
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		String userId = (String)session.getAttribute("userId");
		if(loginCookie!= null && userId==null) {
			String sessionId = loginCookie.getValue();
			CinemaUserDTO login = cus.checkUserWithSessionId(sessionId);
			userId = login.getUserId();
			model.addAttribute("userId", userId);
		}
		return "cinemaMovie/movieInfo";
	}
	
	// movieInfo에서 티저예고편 보여주기
	@GetMapping(value="/movieInfo/teaserUrl/{movieNm}/",produces="application/json;charset=utf-8")
	@ResponseBody
	public String teaserUrl(@PathVariable String movieNm) throws IOException {
		System.out.println(movieNm);
		String teaserUrl = cms.teaserUrl(movieNm.trim());
		return teaserUrl; 
	}
	
	// 영화 리뷰 등록하기
	@PostMapping(value="/movieInfo/reviewAdd",produces="application/json;charset=utf-8")
	@ResponseBody
	public int reviewAdd(@RequestBody HashMap<String, String>map, HttpSession session, HttpServletRequest request) {
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		String userId = (String)session.getAttribute("userId");
		if(userId==null) {
			String sessionId = loginCookie.getValue();
			CinemaUserDTO login = cus.checkUserWithSessionId(sessionId);
			userId = login.getUserId();
		}
		map.put("userId", userId);
		System.out.println(map);

		return cms.reviewAdd(map);
	}
	
	// 영화 리뷰 리스트 불러오기
	@GetMapping("/movieInfo/list")
	@ResponseBody
	public List<ReviewDTO> reviewList(@RequestParam("movieNm")String movieNm, @RequestParam("rowMax")String rowMax ){
		System.out.println(movieNm);
		return cms.reviewList(movieNm,rowMax);
	}
	
	// 상영시간표 사이트 보여주기
	@GetMapping("/schedule")	
	public void schedule() {}
	
	// 상영시간표 사이트에서 해당 날짜 클릭 시 그 날짜마다의 상영일정 내용 보여주기
	@GetMapping(value="/schedule/list/{tosDateJson}/",produces="application/json;charset=utf-8")
	@ResponseBody
	public String scheduleList(@PathVariable String tosDateJson, Model model) throws JsonProcessingException {
		HashMap<String, String> dateMap = mapper.readValue(tosDateJson, new TypeReference<HashMap<String,String>>() {});
		String showDay = dateMap.get("date");
		
		List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();
		String[] movieNameList = csls.movieNameList(showDay);
		String[] urlNameList = csls.urlNameList(showDay);
	
		for(int i=0;i<movieNameList.length;i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				CinemaMovieDTO movie_dto = csls.runningTimeAgeLimitList(movieNameList[i]);
				map.put("movieName", movieNameList[i]);
				map.put("urlName", urlNameList[i]);
				map.put("runningTime", movie_dto.getRunningTime());
				map.put("ageLimit", movie_dto.getAgeLimit());
				int[] scheduleCountList = csls.scheduleCountList(showDay,movieNameList[i]);
				String[] hallNameList = csls.hallNameList(movieNameList[i],showDay);
				
				for(int j=0;j<scheduleCountList.length;j++) {
					CinemaScheduleListDTO dto = new CinemaScheduleListDTO();
					
					dto.setSchedule_allCount(scheduleCountList[j]);
					dto.setHallName(hallNameList[j]);
					String[] start_timeList = csls.start_timeList(movieNameList[i],showDay ,hallNameList[j]);
					String[] end_timeList = csls.end_timeList(movieNameList[i],showDay,hallNameList[j]);
					int[] seatCountRemainList = csls.seatCountRemainList(showDay,movieNameList[i],hallNameList[j]);
					int[] schedule_idxList = csls.schedule_idxList(movieNameList[i],showDay,hallNameList[j]);
					dto.setStart_time(start_timeList);
					dto.setEnd_time(end_timeList);
					dto.setSchedule_idx(schedule_idxList);
					dto.setSeatCountRemain(seatCountRemainList);
					
					map.put(Integer.toString(j), dto);
					
				}
				listMap.add(map);
		}
		
		String jsonData = mapper.writeValueAsString(listMap);
		
		return jsonData;
	}		
	
	
	// 예매 시 사이트 보여주기
	@GetMapping("/ticketing")
	public String ticketing(Model model) {
		List<CinemaMovieDTO> movieList	=	cms.movieList();   
		model.addAttribute("movieList", movieList);
		
		return "cinemaMovie/ticketing";
	}
	
	// 예매 사이트에서 선택된 영화와 날짜에 따른 상영일정 보여주기
	@GetMapping(value="/ticketing/{movieName}/{showDay}/", produces="application/json;charset=utf-8")
	@ResponseBody
	public List<HashMap<String, Object>> ticketing(@PathVariable String movieName, @PathVariable String showDay){
		
		return cms.ticketingList(movieName, showDay);
	} 
	
	// 예매된 좌석 비활성화
	@GetMapping("/getSeats/{scheduleIdx}/")
	@ResponseBody
	public String[] reservedSeats(@PathVariable int scheduleIdx) {
		String[] seats = cms.reservedSeats(scheduleIdx);
		return seats;
	}
	
	
	// 카카오페이 성공
	@GetMapping("/success")
	public String success(@RequestParam("pg_token") String pgToken, HttpSession session) throws IOException {
		String userId = (String) session.getAttribute("userId");
		kps.kakaoPayApprove(pgToken, userId);
		
		return "redirect:/cinemaMovie/ticketingDBInsert";
	}
	
	// 카카오페이 결제 준비 단계
	@PostMapping(value="/kakaoPay/", produces="application/text;charset=utf-8")
	@ResponseBody
	public String kakaoPay(@RequestBody HashMap<String, String> ticketingJson , HttpSession session) throws IOException {
		session.setAttribute("ticketingJson", ticketingJson);
		
		String userId = (String) session.getAttribute("userId");
		String next_redirect_pc_url = kps.kakaoPayReady(ticketingJson, userId);
		return next_redirect_pc_url;
	}

	// 예매 진행 후 카카오페이로 결제 시 예매 내역 ~ 매출 등록까지 DB에 Insert하기
	@GetMapping("/ticketingDBInsert")
	public String ticketingDBInsert(CinemaTicketingDTO dto, HttpSession session) throws JsonMappingException, JsonProcessingException {
		HashMap<String, String> map =  (HashMap<String, String>) session.getAttribute("ticketingJson");
		

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
		
		if(result ==1 ) { return "redirect:/cinemaMovie/ticketingSuccess"; }
	
		return "redirect:/cinemaMovie/ticketing";
	}
	
	// 예매 진행 후 일반 카드로 결제 시 예매 내역 ~ 매출 등록까지 DB에 Insert하기
	@PostMapping("/ticketing/")
	@ResponseBody
	public int ticketingDBInsert(@RequestBody HashMap<String, String> map, CinemaTicketingDTO dto, HttpSession session) throws JsonMappingException, JsonProcessingException {

		
		session.setAttribute("ticketingJson", map);

		// userId받아오기(로그인 세션값으로 들고오기)
		String userId = (String) session.getAttribute("userId");
		dto.setUserId(userId);

		// 예매 insert하기
		int schedule_Idx = Integer.parseInt(map.get("scheduleIdx"));
		dto.setSchedule_idx(schedule_Idx);

		dto.setSeatNameAll(map.get("selectSeats"));
		dto.setAdultCount(Integer.parseInt(map.get("adultCnt")));
		dto.setTeenagerCount(Integer.parseInt(map.get("studentCnt")));
		int result = cms.ticketing(dto);
		
		if (result == 1) {return 1;}
		
		return 0;
	}
	
	// 결제수단 상관없이 결제 성공이 되면 나오는 페이지
	@GetMapping("/ticketingSuccess")
	public String ticketingSuccess(HttpSession session, Model model) throws JsonProcessingException {
		model.addAttribute("ticketingJson", mapper.writeValueAsString(session.getAttribute("ticketingJson")));
		return "cinemaMovie/ticketingSuccess";
	}
	
	// 예매 취소 시 돌아가는 메서드 ==> 주소 넣어야함
	@GetMapping("/ticketingHistoryCancel")
	public String ticketingCancel(int idx) {	// idx = ticketing_idx
	
		cms.ticketingCancel(idx);
		return "redirect:/cinemaUser/myPage/ticketingHistory";
	}
	

	

	
}
