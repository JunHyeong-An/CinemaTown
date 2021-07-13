package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MasterDAO;
import com.itbank.model.serviceCenterDTO;

@Service
public class MasterService {

	@Autowired private MasterDAO dao;

	public List<serviceCenterDTO> lostList() {
		return dao.lostList();
	}
	
	
}
