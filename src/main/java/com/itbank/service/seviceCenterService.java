package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.OneToOneDTO;
import com.itbank.model.ServiceCenterDAO;
import com.itbank.model.ServiceCenterDTO;

@Service
public class seviceCenterService {

	@Autowired private ServiceCenterDAO dao;

	public int addlostList(ServiceCenterDTO dto) {
		return dao.addlostList(dto);
	}

	public int addOneToOneList(OneToOneDTO dto) {
		return dao.addOneToOneList(dto);
	}


	
	
}
