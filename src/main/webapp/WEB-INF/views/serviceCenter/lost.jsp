<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물</title>
</head>
<body>

<h1>분실물 문의</h1>
<hr>
<form method="POST">
	<input type="datetime-local" name="cinemaLostDateTime" >
	<input type="text" name="cinemaLostKind" placeholder="분실물의 종류를 넣어주세요">
	<textarea name="cinemaLostContent" placeholder="어디서 잃어버렸는지 상세내용을 적어주세요"></textarea>
	<input type="text" name="cinemaLostName" placeholder="성명" >
	<input type="text" name="cinemaLostBirth" >
	<input type="text" name="cinemaLostPH" >
	<input type="submit" value="문의하기">
</form>

</body>
</html>