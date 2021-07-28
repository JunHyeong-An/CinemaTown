<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterLostRead.css">
 <div id="boardContainer">
        <div class="boardForm">
            <div class="boardTitle">${dto.cinemaLostKind }</div>
            <div class="wdate"><div class="ex">분실일</div>${dto.cinemaLostDateTime }</div>
            <div class="wdate"><div class="ex">작성일</div>${dto.cinemaLostToDay }</div>
            <div class="name"><div class="ex">작성자</div>${dto.cinemaLostName }</div>
            <div class="birth"><div class="ex">생년월일</div>${dto.cinemaLostBirth }</div>
            <div class="phone"><div class="ex">연락처</div>${dto.cinemaLostPH }</div>
            <div class="content">${dto.cinemaLostContent }</div>
        </div>
    </div>



</body>
</html>