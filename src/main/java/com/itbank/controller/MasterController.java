package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.reviewDTO;
import com.itbank.model.serviceCenterDTO;
import com.itbank.service.MasterService;
import com.itbank.service.reviewService;

@Controller
@RequestMapping("/master")
public class MasterController {
	
	@Autowired private reviewService rs;
	@Autowired private MasterService mse;
	   
	// master 홈
	   @GetMapping("/master/masterHome")
	   public void masterHome() {}
	   
	   //마스터 리뷰에서 영화를 클릭해서 그 영화에 관련된 리뷰만 불러오기
	   @GetMapping("/masterReview/masterReviewList/")
	   public void movieDelete(Model model) {
	      String[] movieNameList = rs.movieNameList();
	      model.addAttribute("movieNameList", movieNameList);
	      System.out.println(movieNameList);
	   }
	   //리뷰 리스트 불러오기
	   @GetMapping(value="/masterReview/masterReviewList/{movieName}/",produces="application/json;charset=utf-8")
	   @ResponseBody
	   public List<reviewDTO> movieReviewList(@PathVariable String movieName, Model model){
		   List<reviewDTO> reviewList =  rs.reviewList(movieName);
		  model.addAttribute("reviewList", reviewList);
	      return reviewList;
	   }
	   //리뷰삭제
	   @DeleteMapping("/masterReview/masterReviewList/{review_idx}/")
	   @ResponseBody
		public int reviewDelete(@PathVariable int review_idx) {
		   return rs.reviewDelete(review_idx);
	   }
	   
	   //문의 정보 리스트 불러오기
	   @GetMapping("/masterServiceCenter/masterLost")
	   public String lostList(Model model) {
		   List<serviceCenterDTO> list = mse.lostList();
		   model.addAttribute("lostList", list);
		   return "/master/masterServiceCenter/masterLost";
	   }
	   
	   //영화 목록 띄우기(관리자)
	   @GetMapping("/masterMovie/masterMovieList")
	   public ModelAndView listType() {
	      ModelAndView mav = new ModelAndView("master/masterMovie/masterMovieList");
	      List<CinemaMovieDTO> list = mse.movieList();
	      mav.addObject("list", list);
	      return mav;
	   }
	   
	   @GetMapping("/masterMovie/masterMovieAdd")
	   public void movieadd2() {}

		// 영화 추가하기(관리자)
		@PostMapping("/masterMovie/masterMovieAdd")
		public String movieadd(CinemaMovieDTO dto) {
			int row = mse.insert(dto);
			return "redirect:/master/masterMovie/masterMovieList";
		}
		
		// 영화 or 상영관 일정 추가하는 페이지 (관리자)
		@GetMapping("/masterMovie/cinemaSchedule")
		public ModelAndView addMovieClick(){
			ModelAndView mav = new ModelAndView("master/masterMovie/cinemaSchedule");
			List<CinemaMovieDTO> list = mse.movieList();
			List<CinemaHallDTO> list2 = mse.hallList();
			mav.addObject("list", list);
			mav.addObject("list2", list2);
			return mav;
		}
		
		// 상영관 일정 추가하기(관리자)
		@PostMapping("/masterMovie/cinemaSchedule")
		public String insertMovie(CinemaScheduleDTO dto, String hallName) {
			int row = mse.insertMovie(dto, hallName);
			return "redirect:/master/masterMovie/masterMovieList";
		}
	   
	   // 이벤트 추가하는 관리자 페이지(관리자)
	   @GetMapping("/masterEvent/masterEventAdd")
	   public void add() {}
		
	   // 이벤트 추가하기(관리자)
	   @PostMapping("/masterEvent/masterEventAdd")
	   public String writeEvent(CinemaEventListDTO dto){
		   System.out.println(dto);
	   int row = mse.uploadEvent(dto);
	   System.out.println(row);
	   return "redirect:/master/masterEvent/masterEventList/";
	   }

	   // 이벤트 리스트(관리자)
	   @GetMapping("/masterEvent/masterEventList")
	   public ModelAndView eventList() {
	   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventList");
			
	   // 현재 진행중인 이벤트 리스트
	   List<CinemaEventListDTO> list = mse.selectList();
			
	   // 종료된 이벤트 리스트
	   List<CinemaEventListDTO> list2 = mse.selectList2();
			
	   mav.addObject("list", list);
	   mav.addObject("list2", list2);
	   return mav;	
	   }
		
	   // 이벤트 리스트중 한개를 끌어와서 그 리스트에 대한 내용 끌어오기
	   @GetMapping("/masterEvent/masterEventListRead/{event_idx}")
	   public ModelAndView read(@PathVariable int event_idx) {
	   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventListRead");
	   List<CinemaEventListDTO> list = mse.selectOne(event_idx);
	   mav.addObject("list", list);
	   return mav;
	   }
		
	   // 이벤트 한개에 대한 내용 수정 페이지 끌어오기
	   @GetMapping("/masterEvent/masterEventModify/{event_idx}")
	   public ModelAndView readmodify(@PathVariable int event_idx) {
		   ModelAndView mav = new ModelAndView("master//masterEvent/masterEventModify");
		   List<CinemaEventListDTO> list = mse.selectOneList(event_idx);
		   mav.addObject("list", list);
		   return mav;
	   }
		
	   // 이벤트 한개에 대한 내용 수정하기
	   @PostMapping("/masterEvent/masterEventModify/{event_idx}")
	   public String modify(CinemaEventListDTO dto) {
		   int row = mse.modify(dto);
		   return "redirect:/master/masterEvent/masterEventList/";
	   }
	   
	   
}
