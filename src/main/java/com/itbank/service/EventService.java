package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaEventListDTO;
import com.itbank.model.EventDao;

@Service
public class EventService {

	@Autowired private EventDao dao;
	
	public List<CinemaEventListDTO> selectList() {
		return dao.selectList();
	}

	public List<CinemaEventListDTO> selectList2() {
		return dao.selectList2();
	}

	public List<CinemaEventListDTO> selectOne(int event_idx) {
		return dao.selectOne(event_idx);
	}

}
