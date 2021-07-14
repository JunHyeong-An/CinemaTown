package com.itbank.controller;

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

import com.itbank.model.CinemaUserDTO;
import com.itbank.service.CinemaUserService;

@Controller
@RequestMapping("/cinemaUser")
public class CinemaUserController {

	@Autowired private CinemaUserService cus;

	// cinemaUser폴더에 login form부분 띄우기
	@GetMapping("/login")
	public void login() {}


	// id, pw 입력해서 로그인 구현
	@PostMapping("/login")
	public String login(CinemaUserDTO dto, HttpSession session, HttpServletResponse response, HttpServletRequest request, String keepLogin) {      
		
		// login logic
		CinemaUserDTO login = cus.login(dto);
		session.setAttribute("login", login);
		

		if(login !=  null) {
			session.setAttribute("userId", login.getUserId());
			
			return "redirect:/";
		}
		
//		String keepLoginRe = request.getParameter("keepLogin");
//
//		if(keepLoginRe !=null) {
//		// JSESSION cookie
//			if(keepLoginRe.equals("on")) {
//				if(session.getAttribute("login") != null) {
//					Cookie jsId = new Cookie("JSESSIONID", session.getId());
//					jsId.setMaxAge(86400 * 7);
//					jsId.setPath("/test/cinemaUser");
//					response.addCookie(jsId);
//				}
//	
//			}
//		}
		return "redirect:/cinemaUser/login";
	
		
	}

	// 로그아웃 구현
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// session에 저장된 정보 제거
		session.invalidate();
		return "redirect:/";
	}



	// 회원가입 페이지에서 아이디 중복체크하기
	@GetMapping("/idCheck/{userId}/")
	@ResponseBody
	public int idCheck(@PathVariable String userId) {
		return cus.idCheck(userId);
	}

	// 회원가입 페이지 보여주기
	@GetMapping("/join")
	public String join() {
		return "cinemaUser/join";
	}

	// 회원가입된 내용 DB에 저장
	@PostMapping("/join")
	public String insert(CinemaUserDTO dto) {
		int row = cus.insert(dto);
		return "redirect:/cinemaUser/login";
	}

	// 정보 변경 페이지 넘어가기 전에 비밀번호 확인 받는 페이지
	@GetMapping("/myPage/passwordModifyCheck")
	public String passwordModifyCheck() {		
		return "cinemaUser/myPage/passwordModifyCheck";
	}

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
		return "redirect:/"; 	// 어디로 갈건지 설정!!
	}

	// user의 비밀번호 변경할 페이지 보여주기
	@GetMapping("/myPage/passwordModify")
	public String passwordModify() {
		
		return "cinemaUser/myPage/passwordModify";
	}

	// user의 새 비밀번호 넣어주기
	@PostMapping("/myPage/passwordModify")
	public String passwordModify(CinemaUserDTO dto) {
		int row = cus.passwordModify(dto);
		// 로그아웃 시키고 session값지우고 다시 로그인 시킬것인지 의논하기★
		return "home";
	}

	// user의 탈퇴 페이지 보여주기
	@GetMapping("/deleteCheck")
	public String delete() {
		return "cinemaUser/deleteCheck";
	}

	// user의 비밀번호를 기입한 후 탈퇴하기 ==> ajax로 처리할 건지 의논하기★
	@PostMapping("/deleteCheck")
	public int deleteCheck(CinemaUserDTO dto) {
		return cus.deleteCheck(dto);
	}



}
