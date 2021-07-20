package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.OneToOneDTO;
import com.itbank.model.serviceCenterDAO;
import com.itbank.model.serviceCenterDTO;

@Service
public class seviceCenterService {

	@Autowired private serviceCenterDAO dao;

	public int addlostList(serviceCenterDTO dto) {
		return dao.addlostList(dto);
	}

	public int addOneToOneList(OneToOneDTO dto) {
		return dao.addOneToOneList(dto);
	}


	
	
}
