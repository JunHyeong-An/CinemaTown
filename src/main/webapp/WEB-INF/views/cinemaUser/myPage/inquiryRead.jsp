<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 내역 (세부내용)</title>
</head>
<body>
<!-- 	1:1 문의 내역 (세부내용) 관리자 답변 포함 -->
${dto.oneToOne_idx } | ${dto.otoKind } | ${dto.userId } | ${dto.otoTitle } | ${dto.otoContent } | ${dto.otoWriteDay } 

<c:if test="${not empty replyList }">
	<c:forEach var="reply" items="${replyList }">
		${reply.answerContent } | ${reply.answerDay }
	</c:forEach>
</c:if>


</body>
</html>