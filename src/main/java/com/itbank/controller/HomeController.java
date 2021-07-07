package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/header")
	public String header() {
		return "header";
	}
	@GetMapping("/cinemaUser/join")
	public void join() {}
	@GetMapping("/cinemaUser/login")
	public void login() {}
	@GetMapping("/cinemaUser/myPage/passwordModify")
	public void passwordModify() {}
	@GetMapping("/cinemaUser/myPage/modify")
	public void modify() {}
}
