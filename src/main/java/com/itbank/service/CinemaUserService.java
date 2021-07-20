package com.itbank.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.CinemaUserDAO;
import com.itbank.model.CinemaUserDTO;

@Service
public class CinemaUserService {

	@Autowired private CinemaUserDAO dao;
	
	// 로그인하기
	public CinemaUserDTO login(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
	      return dao.login(dto);
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

		return dao.insert(dto);
	}

	// user의 정보 변경(이메일주소, 주소)해서 DB에 수정하기
	public int infoModify(String userId, String userAddr, String userPh) {
	
		return dao.infoModify(userId, userAddr, userPh);
	}

	// 회원가입 페이지에서 아이디 중복체크하기
	public int idCheck(String userId) {
		
		return dao.idCheck(userId);
	}

	// user의 비밀번호를 기입한 후 탈퇴하기
	public int deleteCheck(CinemaUserDTO dto) {
		
		return dao.deleteCheck(dto);
	}

	// 정보 변경 전에 비밀번호 기입 시 일치, 불일치 확인하기
	public CinemaUserDTO passwordModifyCheck(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
		return dao.passwordModifyCheck(dto);
	}

	// user의 새 비밀번호 넣어주기
	public int passwordModify(CinemaUserDTO dto) {
		dto.setUserPw(Hash.getHash(dto.getUserPw()));
		return dao.passwordModify(dto);
	}

	public void keepLogin(String userId, String sessionId, Date sessionLimit) {
		dao.keepLogin(userId, sessionId, sessionLimit);
		
	}
	
	public CinemaUserDTO checkUserWithSessionId(String sessionId) {
		return dao.checkUserWithSessionId(sessionId);
		
	}
	
	
	
	
}
