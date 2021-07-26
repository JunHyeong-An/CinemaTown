<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterNoticeRead.css">

<div id="boardContainer">
        <div class="boardForm">
        <c:forEach var="dto" items="${list }">
            <div class="boardTitle" name="boardTitle">${dto.noticeTitle }</div>
            <div class="miniContainer"><div class="wdate" name="date">${dto.noticeDate }</div></div>
            <c:if test="${not empty dto.noticeFileName}">
            	<div class="contentImg"><img src="${cpath }/uploadimage/${dto.noticeFileName}"></div>
            </c:if>
            <c:if test="${empty dto.noticeFileName}">
            	<div class="contentImg"></div>
            </c:if>
            <div class="content"><pre>${dto.noticeContent }</pre></div>
            
        </c:forEach>
        </div>
    </div>


<%@ include file="../footer.jsp" %>