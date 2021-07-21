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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.CinemaHallDTO;
import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDTO;
import com.itbank.model.OneToOneAnswerDTO;
import com.itbank.model.OneToOneDTO;
import com.itbank.model.reviewDTO;
import com.itbank.model.serviceCenterDTO;
import com.itbank.service.MasterService;
import com.itbank.service.reviewService;

@Controller
@RequestMapping("/master")
public class MasterController {
	
	@Autowired private reviewService rs;
	@Autowired private MasterService mse;
	   
	// master �솃
	   @GetMapping("/master/masterHome")
	   public void masterHome() {}
	   
	   //留덉뒪�꽣 由щ럭�뿉�꽌 �쁺�솕瑜� �겢由��빐�꽌 洹� �쁺�솕�뿉 愿��젴�맂 由щ럭留� 遺덈윭�삤湲�
	   @GetMapping("/masterReview/masterReviewList/")
	   public void movieDelete(Model model) {
	      String[] movieNameList = rs.movieNameList();
	      model.addAttribute("movieNameList", movieNameList);
	      System.out.println(movieNameList);
	   }
	   //由щ럭 由ъ뒪�듃 遺덈윭�삤湲�
	   @GetMapping(value="/masterReview/masterReviewList/{movieName}/",produces="application/json;charset=utf-8")
	   @ResponseBody
	   public List<reviewDTO> movieReviewList(@PathVariable String movieName, Model model){
		   List<reviewDTO> reviewList =  rs.reviewList(movieName);
		  model.addAttribute("reviewList", reviewList);
	      return reviewList;
	   }
	   //由щ럭�궘�젣
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
	   
	   //�쁺�솕 紐⑸줉 �쓣�슦湲�(愿�由ъ옄)
	   @GetMapping("/masterMovie/masterMovieList")
	   public ModelAndView listType() {
	      ModelAndView mav = new ModelAndView("master/masterMovie/masterMovieList");
	      List<CinemaMovieDTO> list = mse.movieList();
	      mav.addObject("list", list);
	      return mav;
	   }
	   @GetMapping("/masterMovie/masterMovieList/delete")
	   public String delete(@RequestParam("movieName") String movieName) {
		   mse.delete(movieName);
		   return "redirect:/master/masterMovie/masterMovieList/";
	   }
	   
	   @GetMapping("/masterMovie/masterMovieAdd")
	   public void movieadd2() {}

		// �쁺�솕 異붽��븯湲�(愿�由ъ옄)
		@PostMapping("/masterMovie/masterMovieAdd")
		public String movieadd(CinemaMovieDTO dto) {
			int row = mse.insert(dto);
			System.out.println(dto.getMovieCode());
			return "redirect:/master/masterMovie/masterMovieList";
		}
		
		// �쁺�솕 or �긽�쁺愿� �씪�젙 異붽��븯�뒗 �럹�씠吏� (愿�由ъ옄)
		@GetMapping("/masterMovie/cinemaSchedule")
		public ModelAndView addMovieClick(){
			ModelAndView mav = new ModelAndView("master/masterMovie/cinemaSchedule");
			List<CinemaMovieDTO> list = mse.movieList();
			List<CinemaHallDTO> list2 = mse.hallList();
			mav.addObject("list", list);
			mav.addObject("list2", list2);
			return mav;
		}
		
		// �긽�쁺愿� �씪�젙 異붽��븯湲�(愿�由ъ옄)
		@PostMapping("/masterMovie/cinemaSchedule")
		public String insertMovie(CinemaScheduleDTO dto, String hallName) {
			int row = mse.insertMovie(dto, hallName);
			return "redirect:/master/masterMovie/masterMovieList";
		}
	   
	   // �씠踰ㅽ듃 異붽��븯�뒗 愿�由ъ옄 �럹�씠吏�(愿�由ъ옄)
	   @GetMapping("/masterEvent/masterEventAdd")
	   public void add() {}
		
	   // �씠踰ㅽ듃 異붽��븯湲�(愿�由ъ옄)
	   @PostMapping("/masterEvent/masterEventAdd")
	   public String writeEvent(CinemaEventListDTO dto){
		   System.out.println(dto);
	   int row = mse.uploadEvent(dto);
	   System.out.println(row);
	   return "redirect:/master/masterEvent/masterEventList/";
	   }

	   // �씠踰ㅽ듃 由ъ뒪�듃(愿�由ъ옄)
	   @GetMapping("/masterEvent/masterEventList")
	   public ModelAndView eventList() {
	   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventList");
			
	   // �쁽�옱 吏꾪뻾以묒씤 �씠踰ㅽ듃 由ъ뒪�듃
	   List<CinemaEventListDTO> list = mse.selectList();
			
	   // 醫낅즺�맂 �씠踰ㅽ듃 由ъ뒪�듃
	   List<CinemaEventListDTO> list2 = mse.selectList2();
			
	   mav.addObject("list", list);
	   mav.addObject("list2", list2);
	   return mav;	
	   }
		
	   // �씠踰ㅽ듃 由ъ뒪�듃以� �븳媛쒕�� �걣�뼱���꽌 洹� 由ъ뒪�듃�뿉 ���븳 �궡�슜 �걣�뼱�삤湲�
	   @GetMapping("/masterEvent/masterEventListRead/{event_idx}")
	   public ModelAndView read(@PathVariable int event_idx) {
	   ModelAndView mav = new ModelAndView("master/masterEvent/masterEventListRead");
	   List<CinemaEventListDTO> list = mse.selectOne(event_idx);
	   mav.addObject("list", list);
	   return mav;
	   }
		
	   // �씠踰ㅽ듃 �븳媛쒖뿉 ���븳 �궡�슜 �닔�젙 �럹�씠吏� �걣�뼱�삤湲�
	   @GetMapping("/masterEvent/masterEventModify/{event_idx}")
	   public ModelAndView readmodify(@PathVariable int event_idx) {
		   ModelAndView mav = new ModelAndView("master//masterEvent/masterEventModify");
		   List<CinemaEventListDTO> list = mse.selectOneList(event_idx);
		   mav.addObject("list", list);
		   return mav;
	   }
		
	   // �씠踰ㅽ듃 �븳媛쒖뿉 ���븳 �궡�슜 �닔�젙�븯湲�
	   @PostMapping("/masterEvent/masterEventModify/{event_idx}")
	   public String modify(CinemaEventListDTO dto) {
		   int row = mse.modify(dto);
		   return "redirect:/master/masterEvent/masterEventList/";
	   }
	   
	   
}
