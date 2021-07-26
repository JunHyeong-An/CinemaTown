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
			<div class="paging">
				<div id="number">
					<c:if test="${paging.prev }">
						<a href="${cpath }/master/masterServiceCenter/masterNotice">
							[처음] </a>
					</c:if>

					<c:if test="${paging.prev }">
						<a href="${cpath }/master/masterNotice?page=${paging.begin-1}">[이전]
						</a>
					</c:if>

					<c:if test="${empty param.page}">
						<a href="${cpath }/master/masterServiceCenter/masterNotice"><strong>1</strong></a>
					</c:if>

					<c:forEach var="i"
						begin="${empty param.page ? paging.begin + 1 : paging.begin}"
						end="${paging.end }">
						<span> ${i == param.page ? '<strong>' : '' } <c:if
								test="${i ==1 }">
								<a href="${cpath }/master/masterServiceCenter/masterNotice">${i }</a>
							</c:if> <c:if test="${i != 1}">
								<a
									href="${cpath }/master/masterServiceCenter/masterNotice?page=${i}">${i }</a>
							</c:if> ${i == param.page ? '</strong>' : '' }
						</span>
					</c:forEach>

					<c:if test="${paging.next }">
						<a
							href="${cpath }/master/masterServiceCenter/masterNotice?page=${paging.end+1}">[다음]
						</a>
					</c:if>

					<c:if test="${paging.next }">
						<a
							href="${cpath }/master/masterServiceCenter/masterNotice?page=${paging.pageCount}">[맨끝]
						</a>
					</c:if>
				</div>
			</div>
		</div>

    </div>
<script src="${cpath }/resources/master/masterReview/masterReviewList.js"></script>
</body>
</html>