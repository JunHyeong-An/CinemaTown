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
            <select class="movieNameSelect" id="movieNameId1">
             <c:forEach var="moviename" items="${movieNameList }">
                <option class="movieOption" id="movieNameId2">${moviename}</option>             
             </c:forEach>
            </select>
        </div>
        <div><input type="button" value="선택"></div>
        <div class="main">
        </div>
        <div>
            <span class="paging"><</span>
            <span class="paging">1</span>
            <span class="paging">2</span>
            <span class="paging">3</span>
            <span class="paging">4</span>
            <span class="paging">5</span>
            <span class="paging">6</span>
            <span class="paging">7</span>
            <span class="paging">8</span>
            <span class="paging">9</span>
            <span class="paging">10</span>
            <span class="paging">></span>
        </div>
    </div>
<script src="${cpath }/resources/master/masterReview/masterReviewList.js"></script>
</body>
</html>