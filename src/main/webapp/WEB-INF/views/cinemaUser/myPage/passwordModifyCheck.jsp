<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/passwordModifyCheck.css">
	<div class="colorBox">
		<main id="pwMain">
		<div class="pwTitle">비밀번호 변경하기</div>
		<form class="pwCheckForm" method="POST">
	
			<input type="submit" value="본인확인" id="submitBtn">
	
			<div class="pwInputBox" id="PwInputBox">
				<input type="hidden" name="userId" value="${login.userId }">
				<input type="password" name="userPw" class="pwInput"
					placeholder="현재 비밀번호 입력">
			</div>
		</form>
		</main>
	</div>
<%@ include file="../../footer.jsp"%>
<script src="${cpath }/resources/cinemaUser/myPage/passwordModifyCheck.js"></script>