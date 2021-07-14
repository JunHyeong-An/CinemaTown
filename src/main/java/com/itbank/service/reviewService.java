package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.reviewDAO;
import com.itbank.model.reviewDTO;

@Service
public class reviewService {

	@Autowired private reviewDAO dao;

	public List<reviewDTO> reviewList(String movieName1) {
		return dao.reviewList(movieName1);
	}

	public String[] movieNameList() {
		return dao.movieNameList();
	}

	public int reviewDelete(int review_idx) {
		return dao.reviewDelete(review_idx);
	}

//	public int reviewDelete(String movieName) {
//		return dao.reviewDelete(movieName);
//	}



	
}
