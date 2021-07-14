<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cpath }/resources/master/masterReview/masterReviewList.css">
</head>
<body>
	<div class="mainHeader">
        <div class="reviewHeader">리뷰 관리</div>
        <div class="movieNameSelectForm">
            <select class="movieNameSelect" name="movieName" id="movieName">
             <c:forEach var="moviename" items="${movieNameList }">
                <option class="movieOption" >${moviename}</option>             
             </c:forEach>
            </select>
        </div>
        <div><input type="button" value="선택" id="movieNameButton"></div>
        <div class="main"> 
        </div>
<!--         <div class="paging-number"> -->
<%-- 			<c:if test="${paging.prev }"> --%>
<%-- 				<a href="${cpath }?page=${paging.begin - 1}"> --%>
<!-- 					◁ -->
<!-- 				</a> -->
<%-- 			</c:if> --%>
		
<%-- 			<c:forEach var="i" begin="${paging.begin }" end="${paging.end }"> --%>
<%-- 				<a href="${cpath }?page=${i}"> --%>
<%-- 					${i == param.page ? '<strong>' : ''} --%>
<%-- 						&nbsp;&nbsp;${i }&nbsp;&nbsp; --%>
<%-- 					${i == param.page ? '</strong>' : ''} --%>
<!-- 				</a> -->
<%-- 			</c:forEach> --%>
			
<%-- 			<c:if test="${paging.next }"> --%>
<%-- 				<a href="${cpath }?page=${paging.end + 1}"> --%>
<!-- 					▷ -->
<!-- 				</a> -->
<%-- 			</c:if> --%>
<!-- 		</div> -->
    </div>
<script src="${cpath }/resources/master/masterReview/masterReviewList.js"></script>
</body>
</html>