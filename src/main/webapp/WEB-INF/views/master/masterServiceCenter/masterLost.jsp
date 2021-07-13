<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath } "/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마스터 분실물</title>
</head>
<body>

<c:forEach var="dto" items="${lostList }">
	<tr>
		<th>${dto.cinemaLostDateTime }</th>
		<th>${dto.cinemaLostKind }</th>
		<th>${dto.cinemaLostContent }</th>
		<th>${dto.cinemaLostName }</th>
		<th>${dto.cinemaLostBirth }</th>
		<th>${dto.cinemaLostPH }</th>
		<th>${dto.cinemaLostToDay }</th>
	</tr>
</c:forEach>



</body>
</html>