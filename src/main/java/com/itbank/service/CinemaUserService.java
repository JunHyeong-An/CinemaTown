package com.itbank.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaUserDAO;
import com.itbank.model.CinemaUserDTO;
import com.itbank.model.OneToOneAnswerDTO;
import com.itbank.model.OneToOneDTO;

@Service
public class CinemaUserService {

	@Autowired private CinemaUserDAO user_dao;
	
	// 회원가입 페이지에서 아이디 중복체크하기
	public int idCheck(String userId) {
		
		return user_dao.idCheck(userId);
	}
	
	// 회원가입된 내용 DB에 저장
	public int insert(CinemaUserDTO dto) {
		// 생년월일통해서 나이 DB에 저장
		int userAgeRe = Integer.parseInt(dto.getUserBirth().split("-")[0])/10000;
		userAgeRe += userAgeRe/10 < 3 ? 2000 : 1900;
		int userAge = 2021 - userAgeRe +1;
		dto.setUserAge(userAge);
		
		// 생년월일통해서 성별 DB에 저장
		int userGenderRe = Integer.parseInt(dto.getUserBirth().split("-")[1]);
		String userGender = userGenderRe%2==0 ? "F" : "M" ;
		dto.setUserGender(userGender);

		dto.setUserPw(Hash.getHash(dto.getUserPw()));

		return user_dao.insert(dto);
	}

	// 로그인하기
	public CinemaUserDTO login(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
	      return user_dao.login(dto);
	 }

	// 로그인 유지
	public void keepLogin(String userId, String sessionId, Date sessionLimit) {
		user_dao.keepLogin(userId, sessionId, sessionLimit);
		
	}

	// 정보 변경 전에 비밀번호 기입 시 일치, 불일치 확인하기
	public CinemaUserDTO passwordModifyCheck(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
		return user_dao.passwordModifyCheck(dto);
	}
	
	// user의 정보 변경(이메일주소, 주소)해서 DB에 수정하기
	public int infoModify(String userId, String userAddr, String userPh) {
	
		return user_dao.infoModify(userId, userAddr, userPh);
	}

	// user의 새 비밀번호 넣어주기
	public int passwordModify(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
		return user_dao.passwordModify(dto);
	}

	// user의 비밀번호를 기입한 후 탈퇴하기
	public int deleteCheck(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
		return user_dao.deleteCheck(dto);
	}

	// 자동로그인유지를 위해 Interceptor에서 sessionId가 저장되어있는 지를 확인하기
	public CinemaUserDTO checkUserWithSessionId(String sessionId) {
		return user_dao.checkUserWithSessionId(sessionId);
		
	}

	// 자신의 문의한 1:1문의 리스트 불러오기 
	public List<OneToOneDTO> inquiryList(HttpSession session) {
		String userId = (String)session.getAttribute("userId");
		return user_dao.inquiryList(userId);
	}

	// 1:1문의 리스트 개개인 답변리스트
	public List<OneToOneAnswerDTO> replyList() {
		return user_dao.replyList();
	}

	// 1:1 문의 내역 (세부내용)
	public OneToOneDTO inquiryRead(int oneToOne_idx) {
		return user_dao.inquiryRead(oneToOne_idx);
	}

	public List<HashMap<String, Object>> ticketingHistory(String userId) {
	
		return user_dao.ticketingHistory(userId);
	}
	
	
	

	// myPage 정보 불러오기(List로처리하는방법)
//	public List<CinemaUserDTO> myPageInfo(String userId) {
//		return user_dao.myPageInfo(userId);
//	}

	
	
	
	
	
	
	
}
