<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/master/masterReview/masterReviewList.css">

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
        <div class="main"></div>

    </div>
<script src="${cpath }/resources/master/masterReview/masterReviewList.js"></script>
</body>
</html>