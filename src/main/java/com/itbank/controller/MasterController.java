package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	   @GetMapping("/masterReview/masterReviewList")
	   public void movieDelete(Model model) {
	      String[] movieNameList = rs.movieNameList();
//	      List<reviewDTO> list= rs.movieDelete(movieName1);
//	      model.addAttribute("reviewList", list);
	      model.addAttribute("movieNameList", movieNameList);
	      System.out.println(movieNameList);
	   }
	   
	   @GetMapping(value="/masterReivew/masterReviewList/{movieName}/",produces="application/json;charset=utf-8")
	   @ResponseBody
	   public List<reviewDTO> movieReviewList(@PathVariable String movieName){
	      return rs.reviewList(movieName);
	   }
	   
}
