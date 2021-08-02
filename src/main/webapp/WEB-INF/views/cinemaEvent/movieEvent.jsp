<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/cinemaEvent/eventList.css">

<div class="eventMain">
        <div class="eventContainer">
    
            <div class="eventTop">
                <div class="smallTitle" style="background-color:rgb(7, 82, 105);">진행중인 이벤트</div>
                <div class="smallTitle">종료된 이벤트</div>
            </div>
    
            <div class="listContainer">
                <div class="eventList1">
                <c:forEach var="dto" items="${list }">
    
                    <div class="events"><a href="${cpath }/cinemaEvent/movieEventRead/${dto.event_idx}">            
                    <img src="${cpath }/resources/master/img/${dto.event_idx }.jpg" width="160px"></a>
                        <div class="eventDate">${dto.start_time } ~ ${dto.end_time }</div>
                    </div>
                   
    			</c:forEach>
                </div>
    
                <div class="line1"></div>
                <div class="line"></div>
    
                <div class="eventList2">
    			<c:forEach var="dto2" items="${list2 }">
                    <div class="events"><a href="${cpath }/cinemaEvent/movieEventRead/${dto2.event_idx}">
                    <img src="${cpath }/uploadimage/${dto2.eventListFileName}" width="160px"></a>
                        <div class="eventDate">${dto2.start_time } ~ ${dto2.end_time }</div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>



<%@ include file="../footer.jsp"%>