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
				<img src="/master/home1.png" width="40px">
			</div>
			<div class="mainPageGo">
				<h3>
					<a href="">CINEMA TOWN</a>
				</h3>
			</div>
		</div>
		<div class="header">
			<div class="Logo">
				<h1>관리자 페이지</h1>
			</div>
			<div class="nav">
				<ul>
					<li>영화관리</li> |
					<li>매출확인</li> |
					<li>리뷰관리</li> |
					<li>이벤트</li> |
					<li>게시판관리</li>
				</ul>
			</div>
		</diV>
	</header>
</body>
</html>