package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleListDAO;

@Service
public class CinemaScheduleListService {

	@Autowired private CinemaScheduleListDAO csl_dao;

	public String[] movieNameList() {
		
		return csl_dao.movieNameList();
	}

	public int[] scheduleCountList(String movieName) {
		
		return csl_dao.scheduleCountList(movieName);
	}

	public String[] hallNameList(String movieName) {
		
		return csl_dao.hallNameList(movieName);
	}

	public String[] start_timeList(String movieName, String hallName) {
		
		return csl_dao.start_timeList(movieName, hallName);
	}

	public String[] end_timeList(String movieName, String hallName) {
		
		return csl_dao.end_timeList(movieName, hallName);
	}
	public CinemaMovieDTO runningTimeAgeLimitList(String movieName) {
		
		return csl_dao.runningTimeAgeLimitList(movieName);
	}

	public int[] seatCountRemainList(String movieName,String hallName) {
		
		return csl_dao.seatCountRemainList(movieName, hallName);
	}
	
}
