package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.model.CinemaUserDTO;


public class AdminInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURL = request.getRequestURL().toString();
		System.out.println(requestURL);
		
		HttpSession session = request.getSession();
		CinemaUserDTO user = (CinemaUserDTO)session.getAttribute("login");
		if(user.getUserGrade()==0) {
			return true;
		}
		else {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
	}
	
	
}
	

