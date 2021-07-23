package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.MasterNoticeDTO;
import com.itbank.model.OneToOneAnswerDTO;
import com.itbank.model.OneToOneDTO;
import com.itbank.model.Paging;
import com.itbank.model.ReviewDTO;
import com.itbank.model.ServiceCenterDTO;
import com.itbank.service.MasterService;
import com.itbank.service.reviewService;
import com.itbank.service.seviceCenterService;

@Controller
@RequestMapping("/master")
public class MasterController {
	
	@Autowired private reviewService rs;
	@Autowired private MasterService mse;
	
	
		// 관리자 페이지 및 매출 페이지
		@GetMapping("/master/masterHome")
		public String masterHome(Model model) {
	
			// 영화 별로 매출
			List<HashMap<String, Object>> movieSales = mse.movieSales();
			System.out.println(movieSales.toString());
			model.addAttribute("movieSales", movieSales);
			// 달별로 매출
			List<HashMap<String, Object>> monthSales = mse.monthSales();
			model.addAttribute("monthSales", monthSales);
	
			return "master/masterHome";
		}
	   
	   // 관리자 페이지 리뷰 리스트 관리
	   @GetMapping("/masterReview/masterReviewList/")
	   public void movieDelete(Model model) {
	      String[] movieNameList = rs.movieNameList();
	      model.addAttribute("movieNameList", movieNameList);
	      System.out.println(movieNameList);
	   }
	   // 관리자 리뷰 리스트 영화이름으로 분류
	   @GetMapping(value="/masterReview/masterReviewList/{movieName}/",produces="application/json;charset=utf-8")
	   @ResponseBody
	   public List<ReviewDTO> movieReviewList(@PathVariable String movieNm, Model model){
		   List<ReviewDTO> reviewList =  rs.movieReviewList(movieNm);
		  model.addAttribute("reviewList", reviewList);
	      return reviewList;
	   }
	   // 관리자 리뷰 리스트 중 한개 삭제
	   @DeleteMapping("/masterReview/masterReviewList/{review_idx}/")
	   @ResponseBody
		public int reviewDelete(@PathVariable int review_idx) {
		   return rs.reviewDelete(review_idx);
	   }
	   
	   //문의 정보 리스트 불러오기
	   @GetMapping("/masterServiceCenter/masterLost")
	   public String lostList(Model model) {
		   List<ServiceCenterDTO> list = mse.lostList();
		   model.addAttribute("lostList", list);
		   return "/master/masterServiceCenter/masterLost";
	   }
	   
	   // 1:1문의 리스트 불러오기 
	   @GetMapping("/masterServiceCenter/masterOneToOne")
	   public String oneToOneList(Model model) {
		   List<OneToOneDTO> list = mse.oneToOneList();
		   model.addAttribute("oneToOneList", list);
		   return "/master/masterServiceCenter/masterOneToOne";
	   }
	   
	   // 1:1문의 제목 클릭 하고 들어와서 내용 보여주게 하기 (낱개낱개 보여줌), 답변 단것 보여주기
	   @GetMapping("/masterServiceCenter/masterOneToOne2/{oneToOne_idx}")
	   public ModelAndView EachOneToOne(@PathVariable int oneToOne_idx ) {
		   ModelAndView mav = new ModelAndView("master/masterServiceCenter/masterOneToOne2");
		   List<OneToOneAnswerDTO> list = mse.replyList();
		   OneToOneDTO dto = mse.EachOneToOne(oneToOne_idx);
		   mav.addObject("dto",dto);
		   mav.addObject("replyList", list);
		   return mav;
	   }
	   
	   // 1:1 문의 제목클릭해서 그 해당 글에 답변 달아 주기
	   @PostMapping("/masterServiceCenter/masterOneToOne2/{oneToOne_idx}")
	   public String oneToOneAnswer(OneToOneAnswerDTO dto) {
		   int row = mse.oneToOneAnswer(dto);
		   return "/master/masterServiceCenter/masterOneToOne";
	   }
	   
	   // 답변 수정 하기 (jsp에서는 구현 안했음)
	   @PostMapping("//")
	   public String oneToOneAnswerModify(OneToOneAnswerDTO dto) {
		   int row = mse.oneToOneAnswerModify(dto);
		   return "/master/masterServiceCenter/masterOneToOne";
	   }
	   
	   // 영화 리스트 페이지
	   @GetMapping("/masterMovie/masterMovieList")
	   public ModelAndView listType() {
	      ModelAndView mav = new ModelAndView("master/masterMovie/masterMovieList");
	      List<CinemaMovieDTO> list = mse.movieList();
	      mav.addObject("list", list);
	      return mav;
	   }
	   @GetMapping("/masterMovie/masterMovieList/delete")
	   public String delete(@RequestParam("movieName") String movieName) {
		   mse.deleteMovie(movieName);
		   return "redirect:/master/masterMovie/masterMovieList";
	   }
	   
	   // 영화 추가 페이지
	   @GetMapping("/masterMovie/masterMovieAdd")
	   public void movieadd2() {}

		// 영화 추가 하기
		@PostMapping("/masterMovie/masterMovieAdd")
		public String movieadd(CinemaMovieDTO dto) {
			int row = mse.insert(dto);
			System.out.println(dto.getMovieCode());
			return "redirect:/master/masterMovie/masterMovieList";
		}
		
		// 상영 일정 페이지
		@GetMapping("/masterMovie/cinemaSchedule")
		public ModelAndView addMovieClick(){
			ModelAndView mav = new ModelAndView("master/masterMovie/cinemaSchedule");
			List<CinemaMovieDTO> list = mse.movieList();
			List<CinemaHallDTO> list2 = mse.hallList();
			mav.addObject("list", list);
			mav.addObject("list2", list2);
			return mav;
		}
		
		// 상영 일정 추가 시 같은 상영관에 시간 겹치지 않도록 해주기
		@GetMapping("/masterMovie/cinemaSchedule/check/{scheduleTime}/{hallName}/")
		@ResponseBody
		public int scheduleCheck(@PathVariable String scheduleTime, @PathVariable String hallName) {

			return mse.scheduleCheck(scheduleTime, hallName);
		}
		
		// 상영 일정에 영화, 상영관 추가하기
		@PostMapping("/masterMovie/cinemaSchedule")
		public String insertMovie(CinemaScheduleDTO dto, String hallName) {
			
			int row = mse.insertMovie(dto, hallName);
			return "redirect:/master/masterMovie/masterMovieList";
		}
	   
	   // 관리자 이벤트 추가 페이지
	   @GetMapping("/masterEvent/masterEventAdd")
	   public void add() {}
		
	   // 관리자 이벤트 추가
	   @PostMapping("/masterEvent/masterEventAdd")
	   public String writeEvent(CinemaEventListDTO dto){
		   System.out.println(dto);
	   int row = mse.uploadEvent(dto);
	   System.out.println(row);
	   return "redirect:/master/masterEvent/masterEventList/";
	   }

	   // 관리자 이벤트 리스트
	   @GetMapping("/masterEvent/masterEventList")
	   public ModelAndView eventList() {
	   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventList");
			
	   // 진행 중 이벤트 리스트
	   List<CinemaEventListDTO> list = mse.selectList();
			
	   // 종료된 이벤트 리스트
	   List<CinemaEventListDTO> list2 = mse.selectList2();
			
	   mav.addObject("list", list);
	   mav.addObject("list2", list2);
	   return mav;	
	   }
		
	   // 관리자 이벤트 페이지 리스트 중 한개 정보
	   @GetMapping("/masterEvent/masterEventListRead/{event_idx}")
	   public ModelAndView read(@PathVariable int event_idx) {
	   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventListRead");
	   List<CinemaEventListDTO> list = mse.selectOne(event_idx);
	   mav.addObject("list", list);
	   return mav;
	   }
		
	   // 관리자 이벤트 페이지 수정
	   @GetMapping("/masterEvent/masterEventModify/{event_idx}")
	   public ModelAndView readmodify(@PathVariable int event_idx) {
		   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventModify");
		   List<CinemaEventListDTO> list = mse.selectOneList(event_idx);
		   mav.addObject("list", list);
		   return mav;
	   }
		
	   // 관리자 이벤트 페이지 수정한 후 리스트로 이동
	   @PostMapping("/masterEvent/masterEventModify/{event_idx}")
	   public String modify(CinemaEventListDTO dto) {
		   int row = mse.modify(dto);
		   return "redirect:/master/masterEvent/masterEventList/";
	   }
	   
	   // 관리자 이벤트 리스트 중 한개 삭제
	   @GetMapping("/masterEvent/masterEventDelete/{event_idx}")
	   public String eventDelete(@PathVariable int event_idx) {
		   int row = mse.eventDelete(event_idx);
		   return "redirect:/master/masterEvent/masterEventList";
	   }
	   
	   
}
