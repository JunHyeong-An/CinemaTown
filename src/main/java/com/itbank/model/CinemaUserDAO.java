package com.itbank.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CinemaUserDAO {

	// 로그인하기
	@Select("select * from cinemaUser where userid = #{userId} and userpw = #{userPw}")
	CinemaUserDTO login(CinemaUserDTO dto);
		
	// 회원가입된 내용 DB에 저장
	@Insert("insert into cinemaUser(userId, userPw, userName, userBirth, userEmail, userAddr, userPh, userGender, userAge) values(#{userId}, #{userPw}, #{userName}, #{userBirth}, #{userEmail}, #{userAddr}, #{userPh}, #{userGender}, #{userAge})")
	int insert(CinemaUserDTO dto);

	// user의 정보 변경(이메일주소, 주소)해서 DB에 수정하기
	@Update("update cinemaUser set userAddr=#{userAddr}, userPh=#{userPh} where userId=#{userId}")
	int infoModify(@Param("userId")String userId, @Param("userAddr")String userAddr, @Param("userPh")String userPh);
	
	// 회원가입 페이지에서 아이디 중복체크하기
	@Select("select count(*) from cinemaUser where userId=#{userId}")
	int idCheck(String userId);

	// user의 비밀번호를 기입한 후 탈퇴하기
	@Delete("delete from cinemaUser where userId=#{userId} and userPw=#{userPw}")
	int deleteCheck(CinemaUserDTO dto);

	// 정보 변경 전에 비밀번호 기입 시 일치, 불일치 확인하기
	@Select("select * from cinemaUser where userId=#{userId} and userPw=#{userPw}")
	CinemaUserDTO passwordModifyCheck(CinemaUserDTO dto);

	// user의 새 비밀번호 넣어주기
	@Update("update cinemaUser set userPw=#{userPw} where userId=#{userId}")
	int passwordModify(CinemaUserDTO dto);

	
	

	
}
