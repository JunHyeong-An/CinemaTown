package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.reviewDAO;
import com.itbank.model.reviewDTO;

@Service
public class reviewService {

	@Autowired private reviewDAO dao;

	public List<reviewDTO> reviewList(String movieName1) {
		return dao.reviewList(movieName1);
	}

	public int reviewAdd(reviewDTO dto) {
		return dao.reviewAdd(dto);
	}

	public List<reviewDTO> selectOne(int review_idx) {
		return dao.selectOne(review_idx);
	}

	public int reviewModify(reviewDTO dto) {
		return dao.reviewModify(dto);
	}

	public int reviewDelete(int review_idx) {
		return dao.reviewDelete(review_idx);
	}

	public List<reviewDTO> movieDelete(String movieName1) {
		return dao.movieDelete(movieName1);
	}

	public String[] movieNameList() {
	
		return dao.movieNameList();
	}



	
}
