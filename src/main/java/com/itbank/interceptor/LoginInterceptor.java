package com.itbank.interceptor;


import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.itbank.model.CinemaUserDTO;
import com.itbank.service.CinemaUserService;


public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Inject private CinemaUserService cus;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		String requestURL = request.getRequestURL().toString();

		
		HttpSession session = request.getSession();
		if(session.getAttribute("login")==null) {
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				String sessionId = loginCookie.getValue();

				CinemaUserDTO user = cus.checkUserWithSessionId(sessionId);
				
				if(user != null) {
					session.setAttribute("userId", user.getUserId());
					session.setAttribute("login", user);
					response.sendRedirect(request.getContextPath());
					return true;
				}
			}
			
		
			response.sendRedirect(request.getContextPath()+"/cinemaUser/login"); 
			session.setAttribute("url", request.getQueryString() != null ? requestURL+"?"+request.getQueryString() : requestURL );
			return false;
		}
		return true;
	}
	

	
}
