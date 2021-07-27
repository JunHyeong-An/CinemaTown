<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link rel="stylesheet" href="${cpath }/resources/cinemaMovie/movieInfo/movieInfo.css">
<c:set var="userId" value="${userId }"/>
<input type="hidden" id="userId" value="${userId }">
<%-- \${userId } : ${userId } --%>
\${vodUrl } : ${vodUrl }
<div id="movieInfoContainer">
	<div id="movieInfoPosterAndTitle">
		<img id="movieInfoPoster">
		<div id="movieTitles">
			<span id="title"></span>
			<p id="engTitle"></p>
		</div>
	</div>

	<div id="movieInfoMoreInformation">
		<table id="movieMoreInfo">
			<tr>
				<th>감독</th>
				<td id="director"></td>
			</tr>
			<tr>
				<th>출연진</th>
				<td id="actors"></td>
			</tr>
			<tr>
				<th>제작국가</th>
				<td id="nation"></td>
			</tr>
			<tr>
				<th>제작년도</th>
				<td id="prodYear"></td>
			</tr>
			<tr>
				<th>상영시간</th>
				<td id="runtime"></td>
			</tr>
			<tr>
				<th>관람등급</th>
				<td id="rating"></td>
			</tr>
			<tr>
				<th>장르</th>
				<td id="genre"></td>
			</tr>
		</table>
		<div id="moviePlot"></div>
	</div>
	<div id="movieStillCuts">
		<div class="stillCutMove" id="stillCutMoveLeft">◀</div>
		<div id="stillCutSection">
			<div id="stillCutBox">
			</div>
		</div>
		<div class="stillCutMove" id="stillCutMoveRight">▶</div>
	</div>

	<div id="moveiTrailer">
		<video src="" id="video"></video>
	</div>
	
	<div id="reviewContainer">
		<div id="reviewForm">
			<textarea id="reviewText"></textarea>
			<input type="button" id="reviewBtn" value="관람평 쓰기">
		</div>
		
		<div id="reviewList">
<!-- 			<div class="review"> -->
<!-- 				<p class="reviewUserId">jsodm12</p> -->
<!-- 				<div class="reviewValue">꿀잼</div> -->
<!-- 			</div> -->
		</div>
	</div>
</div>

<script src="${cpath }/resources/cinemaMovie/movieInfo/movieInfo.js"></script>

<%@ include file="../footer.jsp"%>