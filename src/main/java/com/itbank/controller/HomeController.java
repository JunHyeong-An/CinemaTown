package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.service.CinemaMovieService;


@Controller
public class HomeController {
	
	@Autowired private CinemaMovieService cms;
	
	@GetMapping("/")
	public String home(Model model) {
		String[] movieNameList	= cms.movieNameList();
		model.addAttribute("movieNameList", movieNameList);   
		return "home";
	}
	
}
