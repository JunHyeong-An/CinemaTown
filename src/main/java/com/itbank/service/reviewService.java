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
	
	// 리뷰 한개 페이징
	public int selectCount() {
		return dao.selectCount();
	}

	public int reviewDelete(int review_idx) {
		return dao.reviewDelete(review_idx);
	}

	public List<ReviewDTO> movieReviewList(int offset, int perPage, String movieNm) {
		return dao.movieReviewList(offset, perPage, movieNm);
	}

	public List<ReviewDTO> noticeSelect(int offset, int perPage) {
		return dao.noticeSelect(offset, perPage);
	}

	


//	public int reviewDelete(String movieName) {
//		return dao.reviewDelete(movieName);
//	}



	
}
