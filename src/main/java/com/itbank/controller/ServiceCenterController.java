package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.model.OneToOneDTO;
import com.itbank.model.serviceCenterDTO;
import com.itbank.service.seviceCenterService;

@Controller
public class ServiceCenterController {

	@Autowired private seviceCenterService scs;
	
	// 분실물문의 페이지 띄워주는 문구
	@GetMapping("/serviceCenter/lost")
	public String lost(serviceCenterDTO dto) {
		return "serviceCenter/lost";
	}
	
	// 분실물 문의 페이지에서 작성한거 받아오는 문구 
	@PostMapping("/serviceCenter/lost")
	public String addlostList(serviceCenterDTO dto) {
		System.out.println(dto);
		int row = scs.addlostList(dto);
		return "redirect:/";
	}
	
	// 1:1 문의페이지 불러오기
	@GetMapping("/serviceCenter/oneToOne")
	public void oneToOne() {}
	
	// 1:1 문의 페이지에서 받아오는 문구
	@PostMapping("serviceCenter/oneToOne")
	public String addOneToOneList(OneToOneDTO dto) {
		int row =scs.addOneToOneList(dto);
		return "redirect:/";
	}
	
	
	
}
