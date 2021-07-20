<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 1:1</title>
</head>
<body>

<c:forEach var="dto" items="${oneToOneList }">
	<tr>
		<th>${dto.oneToOne_idx }</th>
		<th>${dto.userId }</th>
		<th>${dto.otoKind }</th>
		<th><a href="${cpath}/master/masterServiceCenter/masterOneToOne2/${dto.oneToOne_idx}">${dto.otoTitle }</a></th>
		<th>${dto.otoWriteDay }</th>
	</tr>
</c:forEach>

</body>
</html>