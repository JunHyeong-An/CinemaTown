package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaMovieDTO;
import com.itbank.model.CinemaScheduleDAO;

@Service
public class CinemaScheduleListService {

	@Autowired private CinemaScheduleDAO schedule_dao;

	public String[] movieNameList(String showDay) {
		
		return schedule_dao.movieNameList(showDay);
	}

	public int[] scheduleCountList(String showDay,String movieName) {
		
		return schedule_dao.scheduleCountList(showDay,movieName);
	}

	public String[] hallNameList(String movieName,String showDay) {
		
		return schedule_dao.hallNameList(movieName,showDay);
	}

	public String[] start_timeList(String movieName, String showDay,String hallName) {
		
		return schedule_dao.start_timeList(movieName,showDay, hallName);
	}

	public String[] end_timeList(String movieName,String showDay ,String hallName) {
		
		return schedule_dao.end_timeList(movieName, showDay,hallName);
	}
	public CinemaMovieDTO runningTimeAgeLimitList(String movieName) {
		
		return schedule_dao.runningTimeAgeLimitList(movieName);
	}

	public int[] seatCountRemainList(String showDay,String movieName,String hallName) {
		
		return schedule_dao.seatCountRemainList(showDay,movieName, hallName);
	}
	
}
