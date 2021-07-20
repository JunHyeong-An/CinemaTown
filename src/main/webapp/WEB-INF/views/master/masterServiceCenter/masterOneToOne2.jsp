<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의 세부 내용</title>
</head>
<body>

${dto.oneToOne_idx } | ${dto.otoKind } | ${dto.userId } | ${dto.otoTitle } | ${dto.otoContent } | ${dto.otoWriteDay } 
<c:if test="${not empty replyList }">
	<c:forEach var="reply" items="${replyList}">
		<div>
			${reply.answerContent }  / ${reply.answerDay }
		</div>
	</c:forEach>
</c:if>
<form method="POST">
	<input type="hidden" name="oneToOne_idx" value="${dto.oneToOne_idx } ">
	<textarea name="answerContent"></textarea>
	<input type="submit" value="등록">
</form>

</body>
</html>