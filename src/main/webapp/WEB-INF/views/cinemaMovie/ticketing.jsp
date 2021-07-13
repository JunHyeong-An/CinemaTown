<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing1.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing2.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing3.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing4.css">
<link rel="stylesheet" href="${cpath }/resources/ticketing/ticketing.css">
<div id="coverBox"></div>
<div id="coverBoxInfo">
		<div id="coverBoxHeader">
			<div>
				<span>영화제목 : </span><span id="coverBoxMovieName"></span>
			</div>
			<div id="coverBoxExit">X</div>		
		</div>
		<div>
			<span>시작 시간 : </span><span id="coverBoxStartTime"></span>
			<p id="coverBoxHallName"></p>
		</div>
			
		<p style="padding: 10px 0;">예매를 계속 진행하시겠습니까?</p>
		<div style="text-align: right;">
			<input id="toSeatSelect" type="button" value="좌석선택">
		</div>
	</div>

<div id='container'>
	<div id="ticketingMain">
		<!-- ticketing1 header -->
		<div class="ticketingHeader hidden">
			<div class="movieAndDate">영화 선택</div>
			<div class="movieAndDate">
				<p>날짜 선택</p>
				<p>
					<span id="headerYear">2021</span>/<span id="headerMonth"></span>/<span id="headerDate"></span>
				</p>
			</div>
		</div>
		<!-- ticketing1 header -->
		<!-- ticketing2 header -->
		<div class="ticketingHeader hidden">
			<div id="selectMovieInfo">
				<div class="ageLimit">청불</div>
				<span>콰이어트 플레이스2</span> <span>2021년 7월 7일 20 : 30 ~ 22 : 05
					3관</span>
			</div>
		</div>
		<!-- ticketing2 header -->
		<!-- ticketing3 header -->
		<div class="ticketingHeader hidden">
			<div class="movieAndDate">예매정보</div>
			<div class="movieAndDate">
				<p>결제하기</p>
			</div>
		</div>
		<!-- ticketing3 header -->

		<!-- ticketing4 header -->
		<div class="ticketingHeader hidden">
			<div class="movieAndDate">예매정보</div>
			<div class="movieAndDate">
				<p>결제하기</p>
			</div>
		</div>
		<!-- ticketing4 header -->


		<div id="ticketingSelectSection">
			<ul id="ticketingSideList">
				<li class="listSelect">
					<div class="ticketingSideListLocation">
						<p>1</p>
						<span>상영시간</span>
					</div>
				</li>
				<li class="listUnSelect">
					<div class="ticketingSideListLocation">
						<p>2</p>
						<span>인원 | 좌석</span>
					</div>
				</li>
				<li class="listUnSelect">
					<div class="ticketingSideListLocation">
						<p>3</p>
						<span>결제</span>
					</div>
				</li>
				<li class="listUnSelect">
					<div class="ticketingSideListLocation">
						<p>4</p>
						<span>결제완료</span>
					</div>
				</li>
			</ul>
			<!-- default -->

			<!-- 우리가 상영하는 영화 갯수에 맞춰서 for문 돌려야함 -->
			<div id="changeArea">
				<!--ticketing1-->
				<div class="changeElements" id="ticketing1">
					<ul id="showingMovieList">
						<c:forEach var="movieList" items="${movieList }">
							<li>
								<div class="ageLimit">${movieList.ageLimit }</div> 
								<span class="movieName">${movieList.movieName }</span>
							</li>
						</c:forEach>
					</ul>
					<div id="dateSection">
						<div id="selectDateBox">
							<div id="selectMonth">
								<div class="monthBtnBox">
									<div id="monthDreBtn" class="dateMove">
										<img src="${cpath }/resources/ticketing/img/arrowLeftBlack.png" class="monthBtnImg">
									</div>
								</div>

								<div id="month"></div>

								<div class="monthBtnBox">
									<div id="monthIncBtn" class="dateMove">
										<img src="${cpath }/resources/ticketing/img/arrowRightBlack.png" class="monthBtnImg">
									</div>
								</div>
							</div>

							<div id="selectBox">
								<div id="dateDcrBtnBox">
									<div id="dateDcrBtn" class="dateMove">◀</div>
								</div>

								<ul id="selectDate"></ul>
								<div id="dateIncBtn" class="dateMove">▶</div>
							</div>
						</div>

						<div id="showSelectDate">
							2021/<span id='showSelectMonth'></span>/<span
								id="showSelectDateValue"></span>
						</div>

						<div id="showTimeList">
							<!-- 갯수 만큼 for 문  -->
<%-- 							<c:forEach> --%>
<!-- 								<div class="timeNode"> -->
<!-- 									<p class="nodeTime">09 : 30</p> -->
<!-- 									<p> -->
<!-- 										<span class="remainingSeats">236</span> / 250 1관 -->
<!-- 									</p> -->
<!-- 								</div> -->
<%-- 							</c:forEach> --%>
						</div>
					</div>
				</div>
				<!--ticketing1 end-->

				<!-- tickting2 start-->
				<div class="changeElements hidden" id="seatLayoutWrap">
					<div id="countPerson">
						<span>성인</span>
						<div class="countForm">
							<div id="adultMinusBtn" class="plusAndMinus">-</div>
							<div id="adultCount"></div>
							<div id="adultPlusBtn" class="plusAndMinus">+</div>
						</div>
						<span>청소년</span>
						<div class="countForm">
							<div id="studentMinusBtn" class="plusAndMinus">-</div>
							<div id="studentCount"></div>
							<div id="studentPlusBtn" class="plusAndMinus">+</div>
						</div>
					</div>
					<div id="seatLayout">
						<div id="screenAndExit">
							<div id="screen">screen</div>
							<div class="door" id="exit">출구</div>
						</div>

						<div id="seatSections">
							<div id="enter">
								<div class="door" id="enterance">입구</div>
							</div>
							<div class="seatsSection">
								<!--class="seat"-->
							</div>
							<div class="seatsSection" id="centerSeatsSection"></div>
							<div class="seatsSection"></div>

							<ul id="seatsLineId">
								<li>A</li>
								<li>B</li>
								<li>C</li>
								<li>D</li>
								<li>E</li>
								<li>F</li>
								<li>G</li>
								<li>H</li>
							</ul>
						</div>
					</div>
				</div>
				<!-- tickting2 end -->
				<!-- ticketing3 start-->
				<div id="ticketing3" class="changeElements hidden">
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

						<div id="paymentInfoContainer">
							<div id="paymentCostInfo">
								<div id="totalCost">
									<div id="totalCostInner">
										<span>결제금액</span> <span>28,900원</span>
									</div>
								</div>
							</div>
							<div id="payment">
								<div id="paymentMethodChoice">
									<div class="paymentMethod methodSelect">신용카드 결제</div>
									<div class="paymentMethod methodUnSelect">휴대폰 결제</div>
								</div>
								<div id="choiceCreaditCard" class="methodBox">
									<div id="cards">
										<div class="card">신한카드</div>
										<div class="card">국민카드</div>
										<div class="card">농협카드</div>
										<div class="card">삼성카드</div>
									</div>
								</div>
								<div id="phonePayment" class="methodBox hidden">휴대폰 결제</div>
								<div id="paymentPersonalInfo">
									<table id="paymentPersonalInfoTable" class="hidden">
										<tr>
											<th>고객이름</th>
											<td>김진현</td>
										</tr>
										<tr>
											<th id="cardName">카드이름</th>
											<td><input type="password" maxlength="4" class="cardNum">
												<input type="password" maxlength="4" class="cardNum">
												<input type="password" maxlength="4" class="cardNum">
												<input type="password" maxlength="4" class="cardNum">
											</td>
										</tr>
										<tr>
											<th>비밀번호</th>
											<td><input type="password" maxlength="4" id="cardPw">
											</td>
										</tr>
										<tr>
											<td id="paymentBtnBox" colspan="2"><input
												id="paymentBtn" type="button" value="결제하기"></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- ticketing3 end-->
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
			</div>
		</div>
	</div>
</div>

<script src="${cpath }/resources/ticketing/ticketing.js"></script>
<script src="${cpath }/resources/ticketing/ticketing1.js"></script>
<script src="${cpath }/resources/ticketing/ticketing2.js"></script>
<script src="${cpath }/resources/ticketing/ticketing3.js"></script>
<script src="${cpath }/resources/ticketing/ticketing4.js"></script>
<%@ include file="../footer.jsp"%>