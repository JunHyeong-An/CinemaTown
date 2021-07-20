<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의</title>
</head>
<body>

<h1>1:1 문의 </h1>

<form method="POST">
	<select name="otoKind">
		<option value="오류">오류</option>
		<option value="예매 문의">예매 문의</option>
		<option value="개인정보">개인정보</option>
		<option value="영화관">영화관</option>
		<option value="개인정보">개인정보</option>
		<option value="기타">기타</option>
	</select>
	<input type="text" name="userId" value="${userId }"readonly>
	<input type="text" name="otoTitle" placeholder="제목">
	<textarea name="otoContent" placeholder="작성할 내용"></textarea>
	<input type="submit" value="제출">
</form>


</body>
</html>