package com.itbank.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.itbank.model.CinemaUserDTO;
import com.itbank.service.CinemaUserService;

@Controller
@RequestMapping("/cinemaUser")
public class CinemaUserController {

	@Autowired private CinemaUserService cus;

	// 회원가입 페이지 보여주기
	@GetMapping("/join")
	public void join() {}
	
	// 회원가입 시 이용약관 보여주기
	@GetMapping("/tos")
	public void tosPage() {}
	
	// 회원가입 페이지에서 아이디 중복체크하기
	@GetMapping("/idCheck/{userId}/")
	@ResponseBody
	public int idCheck(@PathVariable String userId) {
		return cus.idCheck(userId);
	}
	
	// 회원가입된 내용 DB에 저장
	@PostMapping("/join")
	public String insert(CinemaUserDTO dto) {
		int row = cus.insert(dto);
		return "redirect:/cinemaUser/login";
	}
	
	// cinemaUser폴더에 login form부분 띄우기
	@GetMapping("/login")
	public void login() {}


	// id, pw 입력해서 로그인 구현 + 자동로그인 유지
	@PostMapping("/login")
	public String login(CinemaUserDTO dto, HttpSession session, String url, HttpServletRequest request, HttpServletResponse response) {      
		
		CinemaUserDTO login = cus.login(dto);
		session.setAttribute("login", login);
		
		if(login !=  null) {
			session.setAttribute("userId", login.getUserId());
			// JSESSION cookie
			String keepLogin = request.getParameter("keepLogin");
			if (keepLogin !=null) {
				Cookie cookie = new Cookie("loginCookie", session.getId());
				cookie.setPath("/");
				int time = 86400 * 7;
				cookie.setMaxAge(time);
				response.addCookie(cookie);

				Date sessionLimit = new Date(System.currentTimeMillis() + (1000*time));
				cus.keepLogin(login.getUserId(), session.getId(), sessionLimit);
				
				
			}
			
			return url == null ? "redirect:/" : "redirect:"+url;
		}
			
		return url == null ? "redirect:/" : "redirect:"+url;
	}

	// 로그아웃 
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		CinemaUserDTO login = (CinemaUserDTO) session.getAttribute("login");
		session.invalidate();

		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(login==null) {
			String sessionId = loginCookie.getValue();
			login = cus.checkUserWithSessionId(sessionId);
		}
		
		if (loginCookie != null) {
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			cus.keepLogin(login.getUserId(), "none", new Date());

		}

		return "redirect:/";
	}
	

	
	// 정보 변경 페이지 넘어가기 전에 비밀번호 확인 받는 페이지
	@GetMapping("/myPage/passwordModifyCheck")
	public void passwordModifyCheck() {}

	// 정보 변경 전에 비밀번호 기입 시 일치, 불일치 확인하기
	@PostMapping("/myPage/passwordModifyCheck")
	public String passwordModifyCheck(CinemaUserDTO dto, HttpSession session) {
		// passwordModifyCheck.jsp에서 비밀번호 일치 후 정보 변경 페이지 보여주기 
		
		CinemaUserDTO cinemaUserInfo = cus.passwordModifyCheck(dto);
		if(cinemaUserInfo != null) {			
			session.setAttribute("userInfo", cinemaUserInfo);
			return "redirect:/cinemaUser/myPage/infoModify";
		}
		
		return "redirect:/cinemaUser/myPage/passwordModifyCheck";
		
	}

	// user의 정보 변경할 수 있는 페이지
	@GetMapping("/myPage/infoModify")
	public ModelAndView infoModify(HttpSession session, ModelAndView mav) {
	
		CinemaUserDTO cinemaUserInfo = (CinemaUserDTO)session.getAttribute("userInfo");
		
		mav.addObject("info", cinemaUserInfo);
		mav.addObject("userBirth", cinemaUserInfo.getUserBirth().split("-")[0]);
		mav.addObject("userEmail1", cinemaUserInfo.getUserEmail().split("@")[0]);
		mav.addObject("userEmail2", cinemaUserInfo.getUserEmail().split("@")[1]);

		String[] phNum = cinemaUserInfo.getUserPh().split("-");
		mav.addObject("userPh1", phNum[0]);
		mav.addObject("userPh2", phNum[1]);
		mav.addObject("userPh3", phNum[2]);
		mav.addObject("postcode", cinemaUserInfo.getUserAddr().split("/")[0]);

		String realAddr = cinemaUserInfo.getUserAddr().split("/")[1];
		mav.addObject("userAddr1", realAddr.split(",")[0]);
		mav.addObject("userAddr2", realAddr.split(",")[1]);
		return mav;
	}

	// user의 정보 변경(이메일주소, 주소)해서 DB에 수정하기
	@PostMapping("/myPage/infoModify")
	public String infoModify(String userId, String userAddr, String userPh) {		

		int row = cus.infoModify(userId, userAddr, userPh);
		return "redirect:/"; 	
	}

	// user의 비밀번호 변경할 페이지 보여주기
	@GetMapping("/myPage/passwordModify")
	public void passwordModify() {}

	// user의 새 비밀번호 넣어주기
	@PostMapping("/myPage/passwordModify")
	public String passwordModify(CinemaUserDTO dto) {
		int row = cus.passwordModify(dto);
		
		return "redirect:/cinemaUser/logout";
	}

	// user의 탈퇴 페이지 보여주기
	@GetMapping("/deleteCheck")
	public void delete() {}

	// user의 비밀번호를 기입한 후 탈퇴하기 
	@PostMapping("/deleteCheck")
	public String deleteCheck(CinemaUserDTO dto, HttpSession session) {
		dto.setUserId((String)session.getAttribute("userId"));
		int row = cus.deleteCheck(dto);
		return "redirect:/cinemaUser/" + (row == 1 ? "logout" : "deleteCheck");
	}



}
