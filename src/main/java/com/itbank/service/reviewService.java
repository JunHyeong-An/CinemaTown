package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.ReviewDAO;
import com.itbank.model.ReviewDTO;

@Service
public class reviewService {

	@Autowired private ReviewDAO dao;


	// 리뷰 전체 페이징
	public String[] movieNameList() {
		return dao.movieNameList();
	}

	public int reviewDelete(int review_idx) {
		return dao.reviewDelete(review_idx);
	}

	public List<ReviewDTO> reviewList(String movieNm, String rowMax) {
	     return dao.reviewList2(movieNm, rowMax);
	}


	
}
