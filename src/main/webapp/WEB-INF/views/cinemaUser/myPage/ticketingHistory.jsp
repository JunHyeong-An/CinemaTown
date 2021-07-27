<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/ticketingHistory.css">
<div id="historyContainer">
	<div id="historyLogoBox">
		<img id="historyLogo" src="${cpath }/resources/cinemaUser/myPage/img/myPageTicket.png">	
	</div>
	
	<div id="historyList">
		<div class="history">
			<div class="historyMovieNm">블랙위도우</div>
			<div class="historyMore">
				<p class="historyDate">2021-07-22</p>
				<p class="historyTime">19:55</p>
				<p class="historyHallNm">5관</p>
			</div>
			<div class="historyCostBox">
				<p>결제금액</p> <p class="historyCost">15,000원</p>
			</div>
			<input type="button" class="cancleBtn" value="예매취소">
		</div>
	</div>
</div>

<%@ include file="../../footer.jsp" %>