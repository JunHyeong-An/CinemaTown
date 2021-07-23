<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 내역</title>
</head>
<body>

<!-- 	1:1문의 내역 리스트 불러오기 , 리스트에 링크달아 세부내용 보기(inquiryRead.jsp)  -->
<c:forEach var="dto" items="${inquiryList}">
	<tr>
		<th>${dto.oneToOne_idx }</th>
		<th>${dto.otoKind }</th>
		<th><a href="${cpath}/cinemaUser/myPage/inquiryRead/${dto.oneToOne_idx}">${dto.otoTitle }</a></th>
		<th>${dto.otoWriteDay }</th>
	</tr>
</c:forEach>

</body>
</html>