package com.itbank.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CinemaUserDAO {

	// 회원가입 페이지에서 아이디 중복체크하기
	@Select("select count(*) from cinemaUser where userId=#{userId}")
	int idCheck(String userId);
	
	// 회원가입된 내용 DB에 저장
	@Insert("insert into cinemaUser(userId, userPw, userName, userBirth, userEmail, userAddr, userPh, userGender, userAge) values(#{userId}, #{userPw}, #{userName}, #{userBirth}, #{userEmail}, #{userAddr}, #{userPh}, #{userGender}, #{userAge})")
	int insert(CinemaUserDTO dto);
	
	// 로그인하기
	@Select("select * from cinemaUser where userid = #{userId} and userpw = #{userPw}")
	CinemaUserDTO login(CinemaUserDTO dto);
		
	// 자동로그인 유지 처리
	@Update("update cinemaUser set sessionId=#{sessionId}, sessionLimit=#{sessionLimit} where userId=#{userId}")
	void keepLogin(@Param("userId")String userId, @Param("sessionId")String sessionId, @Param("sessionLimit")Date sessionLimit);
	
	// 자동로그인유지를 위해 Interceptor에서 sessionId가 저장되어있는 지를 확인하기
	@Select("select * from cinemaUser where sessionId=#{sessionId} and sessionLimit > sysdate")
	CinemaUserDTO checkUserWithSessionId(@Param("sessionId")String sessionId);

	// 정보 변경 전에 비밀번호 기입 시 일치, 불일치 확인하기
	@Select("select * from cinemaUser where userId=#{userId} and userPw=#{userPw}")
	CinemaUserDTO passwordModifyCheck(CinemaUserDTO dto);
	
	// user의 정보 변경(이메일주소, 주소)해서 DB에 수정하기
	@Update("update cinemaUser set userAddr=#{userAddr}, userPh=#{userPh} where userId=#{userId}")
	int infoModify(@Param("userId")String userId, @Param("userAddr")String userAddr, @Param("userPh")String userPh);
	
	// user의 새 비밀번호 넣어주기
	@Update("update cinemaUser set userPw=#{userPw} where userId=#{userId}")
	int passwordModify(CinemaUserDTO dto);

	// user의 비밀번호를 기입한 후 탈퇴하기
	@Delete("delete from cinemaUser where userId=#{userId} and userPw=#{userPw}")
	int deleteCheck(CinemaUserDTO dto);

	// 자신의 문의한 1:1문의 리스트 불러오기 
	@Select("select * from oneToOne where userId=#{userId} order by otoWriteDay desc")
	List<OneToOneDTO> inquiryList(String userId);

	// 1:1문의 리스트 개개인 답변리스트
	@Select("select * from oneToOneAnswer")
	List<OneToOneAnswerDTO> replyList();

	// 1:1 문의 내역 (세부내용)
	@Select("select * from oneToOne where oneToOne_idx=#{oneToOne_idx}")
	OneToOneDTO inquiryRead(int oneToOne_idx);

	// 마이페이지에서 예매내역 보여주기  ==> 필요없는 컬럼은 빼기★
	@Select("select seatNameAll, adultCount, teenagerCount, movieName, showDay," + 
			" to_char(startTime,'HH24:mi') as start_time, to_char(endTime,'HH24:mi') as end_time, hallName, paymentDay, totalAmount" + 
			" from cinemaTicketing" + 
			" join cinemaSchedule" + 
			" on cinemaTicketing.schedule_idx = cinemaSchedule.schedule_idx" + 
			" join cinemaHall" + 
			" on cinemaHall.hall_idx = cinemaTicketing.hall_idx" + 
			" join cinemaPayment" + 
			" on cinematicketing.ticketing_idx = cinemapayment.ticketing_idx" + 
			" where cinemaTicketing.userId = #{userId} order by cinemaTicketing.ticketing_idx")
	List<HashMap<String, Object>> ticketingHistory(@Param("userId")String userId);

	@Select("select * from cinemaUser where userId=#{userId}")
	CinemaUserDTO newUserInfo(String userId);

	// myPage 정보 불러오기(List로처리하는방법)
//	@Select("select userName, userId, userBirth, userPh, userEmail from cinemaUser where userId = #{userId}")
//	List<CinemaUserDTO> myPageInfo(String userId);


	

	
}
