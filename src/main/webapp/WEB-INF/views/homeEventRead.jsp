<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/cinemaEvent/eventRead.css">

<div class="eventMain">
        <div class="eventTitle">
            이벤트 상세
        </div>
		<c:forEach var="dto" items="${list }">
        <div class="smallTitle">이벤트 기간</div>
        <div class="eventDate">${dto.start_time } ~ ${dto.end_time }</div>
        <div class="smallTitle"></div>
        
        <div class="msg"><div class="eventImg"><img src="${cpath }/uploadimage/${dto.eventListFileName}" width="220px"></div>
    	${dto.eventListContent }
    	</div>
		</c:forEach> 
    </div>

<%@ include file= "footer.jsp"%>