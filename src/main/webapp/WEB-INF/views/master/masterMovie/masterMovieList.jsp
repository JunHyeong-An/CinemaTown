<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cpath }/resources/master/masterMovie/masterMovieList.css">
</head>
<body>
<div class="mainHeader">
        <div class="headerTwice">
            <!--영화 추가랑 상영관 배치는 header에 따로 없어서 여기서 누르면 페이지가 이동하게 a태그 줬습니다-->
            <div class="movieAddName"><a href="${cpath}/master/masterMovie/masterMovieAdd/">영화추가</a></div>
            <div class="movieAddName"><a href="${cpath}/master/masterMovie/cinemaSchedule/">상영관 배치</a></div>
        </div>
</div>
<div class="main">
	<!-- DB에 있는 영화 목록들 불러옵니다
	종류는 : 이름, 등급, 상영시간, 포스터 -->
	<div><h2>영화 목록</h2></div>
       <c:forEach var="movieInfo" items="${list}">
       <div class="movieList">
	       <div class="movieUrl">
	       		<table>
	       			<td><img src="${movieInfo.urlName }"></td>
	       		</table>
	       </div>
	       <div>
	       		<table class="movieNameTable">
	       			<tr>
	       				<th class="tdName">영화 이름 </th>
	       				<td class="movieInfoName">${movieInfo.movieName }</td>
	       			</tr>
	       			<tr>
	       				<th class="tdName">영화 등급  </th>
	       				<td class="movieInfoName">${movieInfo.ageLimit }세 관람과</td>
	       			</tr>
	       			<tr>
	       				<th class="tdName">영화 상영시간 </th>
	       				<td class="movieInfoName">${movieInfo.runningTime }분</td>
	       			</tr>
	       		</table>
	       	</div>
			<div><a href="${cpath }/master/masterMovie/masterMovieList/delete?movieName=${movieInfo.movieName }"><button class="deleteBtn">삭제</button></a></div>
       	</div>
       </c:forEach>
</div>
<script src="${cpath }/resources/master/masterMovie/masterMovieList.js"></script>
</body>
</html>