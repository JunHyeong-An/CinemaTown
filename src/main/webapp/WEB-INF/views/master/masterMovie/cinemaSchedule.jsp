<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cpath }/resources/master/masterMovie/cinemaSchedule.css">
</head>
<body>
   
    <div class="main">
        <div class="title">
            <h4>상영관 배치</h4>
        </div>
        <form method="post">
        <div class="movieSelect">
            <div class="selectName">
                영화선택
            </div>
            <div>
            <select class="movieName" name="movieName">
            	<c:forEach var="dto" items="${list }" >
                    <option value="${dto.movieName }">${dto.movieName }</option>
	            </c:forEach>
            </select>
            </div>
        </div>
        <div class="movieSelect">
            <div class="selectName">
                상영관 선택
            </div>
            <div>
            <select class="moviePlace" name="hallName">
	            <c:forEach var="dto2" items="${list2 }">
                    <option value="${dto2.hallName }">${dto2.hallName }</option>
          	  	</c:forEach>
           	</select>
            </div>
        </div>
        <div class="movieSelect">
            <div class="selectName">
                날짜선택
            </div>
            <div>
                <input type="date" name="day" class="date">
            </div>
        </div>
        <div class="movieSelect">
            <div class="selectName">
                시간선택
            </div>
            <div>
            <input type="time" name="time" class="movieTime">
            </div>
        </div>
        <div class="movieAddButton">
            <input type="submit" value="영화 추가하기" class="addButton">
        </div>
    </form>
    </div>
<script src="${cpath }/resources/master/masterMovie/cinemaSchedule.js"></script>
</body>
</html>