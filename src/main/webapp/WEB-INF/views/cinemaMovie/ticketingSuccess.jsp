<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing1.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing2.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing3.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing4.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing.css">
<c:set var="ticketingJson" value="${ticketingJson }"/>
<input type="hidden" id="ticketingJson" value='${ticketingJson }'>
<%-- \${ticketingJson } : ${ticketingJson } --%>
<div id='container'>
        <div id="ticketingMain">
			<div class="ticketingHeader">
				<div class="movieAndDate">예매정보</div>
				<div class="movieAndDate">
					<p>결제하기</p>
				</div>
			</div>

            <div id="ticketingSelectSection">
                <ul id="ticketingSideList">
                    <li >
                        <div class="ticketingSideListLocation">
                            <p>1</p>
                            <span>상영시간</span>
                        </div> 
                    </li>
                    <li style="background-color: red; color: white;">
                        <div class="ticketingSideListLocation">
                            <p>2</p>
                            <span>인원 | 좌석</span>
                        </div>
                    </li>
                    <li>
                        <div class="ticketingSideListLocation">
                            <p>3</p>
                            <span>결제</span>
                        </div>
                    </li>
                    <li>
                        <div class="ticketingSideListLocation">
                            <p>4</p>
                            <span>결제완료</span>
                        </div>
                    </li>
                </ul>
                <div id="ticketing4">
                    <div id="paymentContainer">
                        <div id="paymentMovieInfoContainer">
                            <div id="movieInfo">
                                <img id="ticketingMoviePoster">
                            </div>
                            <div id="paymentInfo">
                                <div id="paymentMovieTitle">
                                    <div class="ageLimit"></div>
                                    <span id="ticketing4MovieName"></span>
                                </div>
                                <div id="paymentMoreInfo">
                                    <table>
                                        <tr>
                                            <td>날짜</td>
                                            <td id="ticketing4Date"></td>
                                        </tr>
                                        <tr>
                                            <td>시간</td>
                                            <td id="ticketing4Time"></td>
                                        </tr>
                                        <tr>
                                            <td>상영관</td>
                                            <td id="ticketing4HallName"></td>
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
                                        <td>${login.userName }</td>
                                    </tr>
                                    <tr>
                                        <th>결제수단</th>
                                        <td id="paymentMethod"></td>
                                    </tr>
                                </table>
                            </div>
                            <div id="totalCostResult">
                                <div>총 결제금액</div>
                                <div id="ticketing4TotalCost"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>

    </div>
<!-- ticketing4 end -->
<script src="${cpath }/resources/ticketing/ticketing4.js"></script>
<%@ include file="../footer.jsp"%>
</body>
</html>