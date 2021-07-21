<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing1.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing2.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing3.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing4.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing.css">
<!-- ticketing4 start -->
<div class="changeElements hidden" id="ticketing4">
	<div id="paymentContainer">
		<div id="paymentMovieInfoContainer">
			<div id="movieInfo">
				<img src="/1.jpg">
			</div>
			<div id="paymentInfo">
				<div id="paymentMovieTitle">
					<div class="ageLimit">청불</div>
					<span>킬러의 보디가드2</span>
				</div>
				<div id="paymentMoreInfo">
					<table>
						<tr>
							<td>날짜</td>
							<td>123</td>
						</tr>
						<tr>
							<td>시간</td>
							<td>1234</td>
						</tr>
						<tr>
							<td>상영관</td>
							<td>4관</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div id="paymentResultBox">
			<div id="paymentMsg">결제가 완료 되었습니다.</div>
			<div id="paymentResultInfo">
				<div id="paymentTitle">결제정보</div>
				<table>
					<tr>
						<th>고객정보</th>
						<td>김진현</td>
					</tr>
					<tr>
						<th>카드이름</th>
						<td>1234-1234-1234-1234</td>
					</tr>
				</table>
			</div>
			<div id="totalCostResult">
				<div>총 결제금액</div>
				<div>28,900</div>
			</div>
		</div>
	</div>
</div>
<!-- ticketing4 end -->
<script src="${cpath }/resources/ticketing/ticketing.js"></script>
<script src="${cpath }/resources/ticketing/ticketing1.js"></script>
<script src="${cpath }/resources/ticketing/ticketing2.js"></script>
<script src="${cpath }/resources/ticketing/ticketing3.js"></script>
<script src="${cpath }/resources/ticketing/ticketing4.js"></script>
<%@ include file="../../footer.jsp"%>
</body>
</html>