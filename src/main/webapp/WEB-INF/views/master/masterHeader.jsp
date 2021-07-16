<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cpath }/resources/master/masterHeader.css">
</head>
<body>
	<header>
		<div class="mainPageLogo">
			<div>
				<img src="${cpath }/resources/master/home1.png" width="40px">
			</div>	
			<div class="mainPageGo">
				<h3>
					<a href="${cpath }">CINEMA TOWN</a>
				</h3>
			</div>
		</div>
		<div class="header">
			<div class="Logo">
				<h1>관리자 페이지</h1>
			</div>
			<div class="nav">
				<ul>
					<li><a href="${cpath }/master/masterMovie/masterMovieList/">영화관리</a><span class="line">|</span></li>
					<li><a href="${cpath }/master/masterHome">매출확인</a><span class="line">|</span></li>
					<li><a href="${cpath }/master/masterReview/masterReviewList/">리뷰관리</a><span class="line">|</span></li>
					<li><a href="${cpath }/master/masterEventList">이벤트</a><span class="line">|</span></li>
					<li><a href="">게시판관리</a></li>
				</ul>
			</div>
		</diV>
	</header>
</body>
</html>