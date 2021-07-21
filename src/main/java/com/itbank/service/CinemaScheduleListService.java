package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleListDAO;

@Service
public class CinemaScheduleListService {

	@Autowired private CinemaScheduleListDAO csl_dao;

	public String[] movieNameList(String showDay) {
		
		return csl_dao.movieNameList(showDay);
	}

	public int[] scheduleCountList(String showDay,String movieName) {
		
		return csl_dao.scheduleCountList(showDay,movieName);
	}

	public String[] hallNameList(String movieName,String showDay) {
		
		return csl_dao.hallNameList(movieName,showDay);
	}

	public String[] start_timeList(String movieName, String showDay,String hallName) {
		
		return csl_dao.start_timeList(movieName,showDay, hallName);
	}

	public String[] end_timeList(String movieName,String showDay ,String hallName) {
		
		return csl_dao.end_timeList(movieName, showDay,hallName);
	}
	public CinemaMovieDTO runningTimeAgeLimitList(String movieName) {
		
		return csl_dao.runningTimeAgeLimitList(movieName);
	}

	public int[] seatCountRemainList(String showDay,String movieName,String hallName) {
		
		return csl_dao.seatCountRemainList(showDay,movieName, hallName);
	}
	
}
