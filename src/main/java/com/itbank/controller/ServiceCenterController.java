package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.serviceCenterDTO;
import com.itbank.service.seviceCenterService;

@Controller
public class ServiceCenterController {

	@Autowired private seviceCenterService scs;
	
	@GetMapping("/serviceCenter/lost")
	public String lost(serviceCenterDTO dto) {
		return "serviceCenter/lost";
	}
	
	@PostMapping("/serviceCenter/lost")
	public String addlostList(serviceCenterDTO dto) {
		System.out.println(dto);
		int row = scs.addlostList(dto);
		return "redirect:/";
	}
	
	
	
	
}
