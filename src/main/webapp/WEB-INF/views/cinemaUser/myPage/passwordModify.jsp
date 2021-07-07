<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/passwordModify.css">
<div class="mainBody">
	<main id="passwordModifyMain">
	<div id="passwordModfiyTile">비밀번호 수정</div>

	<form id="passwordModifyForm">

		<div class="passwordInputBox" id="newPasswordInputBox">
			<div class="passwordInputEx">새로운 비밀번호 입력</div>
			<input type="password" name="newUserPw" class="passwordModifyInput"
				id="newPw">
		</div>

		<div class="passwordInputBox" id="checkNewPasswordInputBox">
			<div class="passwordInputEx">비밀번호 확인</div>
			<input type="password" class="passwordModifyInput" id="newPwCheck">
		</div>
		<div class="newPwMsg"></div>
		<p id="passwordModifyBtnBox">
			<input type="submit" value="수정하기" id="passwordModifyBtn">
		</p>
		<div id="passwordModifyMsg"></div>
	</form>
	</main>
	<!-- passwordModify end -->
</div>
<%@ include file="../../footer.jsp"%>
<script src="${cpath }/resources/cinemaUser/myPage/passwordModify.js"></script>