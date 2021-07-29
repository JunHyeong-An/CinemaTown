<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/deleteCheck.css">
<div class="colorBox">
	<main id="pwMain">
		<div class="pwTitle">회원탈퇴</div>
		
		<form class="pwCheckForm" method="post">
			<input type="submit" value="본인확인" id="submitBtn">
	
			<div class="pwInputBox" id="PwInputBox">
				<input type="password" name="userPw" class="pwInput" id="userPw" placeholder="현재 비밀번호 입력">
			</div>
			<div id="pwNotice"></div>
		</form>
	</main>
</div>
<script src="${cpath }/resources/cinemaUser/myPage/deleteCheck.js"></script>
<%@ include file="../../footer.jsp" %>