<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="masterHeader.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/master/masterHome.css">
<body>
	<div class="main">
		<div class="movieAllMoney">
			<div class="movieTitle">
				<h2>영화별 매출</h2>
			</div>
			<c:forEach var="mS" items="${movieSales}">
				<div class="movieType">
					<div>
						<div class="poster"><img src="${mS.URLNAME}"></div>
						<div class="mNm">${mS.MOVIENAME }</div>
					</div>
					<div class="movieMoney">매출 : ${mS.SUM }</div>
				</div>
			</c:forEach>
		</div>
		<div class="monthAllMoney">
			<div class="monthTitle">
				<h2>달별 매출</h2>
			</div>
			<c:forEach var="mM" items="${monthSales }">
				<div class="monthMoney">
					<div class="month">${mM.SALESDAY }</div>
					<div>매출 : ${mM.SUM }원</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>