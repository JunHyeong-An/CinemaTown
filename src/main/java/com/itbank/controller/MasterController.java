package com.itbank.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.itbank.model.reviewDTO;
import com.itbank.service.reviewService;

@Controller
@RequestMapping("/master")
public class MasterController {
	
	@Autowired private reviewService rs;
	   // master 홈
	   @GetMapping("/master/masterHome")
	   public void masterHome() {}
	   
	   // 마스터 리뷰에서 영화를 클릭해서 그 영화에 관련된 리뷰만 불러오기
	   @GetMapping("/masterReview/masterReviewList/")
	   public void movieDelete(Model model) {
	      String[] movieNameList = rs.movieNameList();
	      model.addAttribute("movieNameList", movieNameList);
	      System.out.println(movieNameList);
	   }
	   
	   @GetMapping(value="/masterReview/masterReviewList/{movieName}/",produces="application/json;charset=utf-8")
	   @ResponseBody
	   public List<reviewDTO> movieReviewList(@PathVariable String movieName, Model model){
		   List<reviewDTO> reviewList =  rs.reviewList(movieName);
		  model.addAttribute("reviewList", reviewList);
	      return reviewList;
	   }
	   
	   @DeleteMapping("/masterReview/masterReviewList/{review_idx}/")
	   @ResponseBody
		public int reviewDelete(@PathVariable int review_idx) {
		   return rs.reviewDelete(review_idx);
	   }
	   
}
