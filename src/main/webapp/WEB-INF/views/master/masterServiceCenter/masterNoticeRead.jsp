<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
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
            <div class="buttonContainer">
                <a href="${cpath }/master/masterServiceCenter/masterNoticeModify/${dto.notice_idx}"><div class="button" name="modifyButton">수정</div></a>
                <a href="${cpath }/master/masterServiceCenter/masterNoticeDelete/${dto.notice_idx}"><div class="button" name="deleteButton">삭제</div></a>
            </div>
        </c:forEach>
        </div>
    </div>

</body>
</html>