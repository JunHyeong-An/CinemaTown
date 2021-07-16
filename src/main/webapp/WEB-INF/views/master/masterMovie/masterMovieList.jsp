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
<<<<<<< HEAD
            <div class="movieAddName"><a href="${cpath }/master/masterMovie/masterMovieAdd">영화추가</a></div>
            <div class="movieAddName"><a href="${cpath }/master/masterMovie/cinemaSchedule">상영관 배치</a></div>
=======
            <div class="movieAddName"><a href="${cpath }/master/masterMovie/masterMovieAdd/">영화추가</a></div>
            <div class="movieAddName"><a href="${cpath }/master/masterMovie/cinemaSchedule/">상영관 배치</a></div>
>>>>>>> refs/remotes/origin/master
        </div>
</div>
<div class="main">
	<!-- DB에 있는 영화 목록들 불러옵니다
	종류는 : 이름, 등급, 상영시간, 포스터 -->
       <c:forEach var="movieInfo" items="${list}">
       <div>
	       <div><img src="${movieInfo.urlName }"></div>
	       <div>
	       		<table>
	       			<tr>
	       				<th class="tdName">영화 이름 </th>
	       				<td>${movieInfo.movieName }</td>
	       			</tr>
	       			<tr>
	       				<th class="tdName">영화 등급  </th>
	       				<td>${movieInfo.ageLimit }세 관람과</td>
	       			</tr>
	       			<tr>
	       				<th class="tdName">영화 상영시간 </th>
	       				<td>${movieInfo.runningTime }분</td>
	       			</tr>
	       		</table>
	       	</div>
       	</div>
       </c:forEach>
</div>
<script src="${cpath }/resources/master/masterMovie/masterMovieList.js"></script>
</body>
</html>