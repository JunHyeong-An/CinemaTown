<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link rel="stylesheet" href="${cpath }/resources/cinemaMovie/movieInfo/movieInfo.css">

<div id="movieInfoContainer">
	<div id="movieInfoPosterAndTitle">
		<img src="1.jpg" id="movieInfoPoster">
		<div id="movieTitles">
			<span id="koreanTitle">이스케이프 룸2 : 노 웨이 아웃</span>
			<p id="engTitle">aswdfsdf</p>
		</div>
	</div>

	<div id="movieInfoMoreInformation">
		<table id="movieMoreInfo">
			<tr>
				<th>감독</th>
				<td>애덤 로비텔</td>
			</tr>
			<tr>
				<th>출연진</th>
				<td>테일러 러셀, 등등등등등등등등등등등등..</td>
			</tr>
			<tr>
				<th>제작국가</th>
				<td>애덤 로비텔</td>
			</tr>
			<tr>
				<th>제작년도</th>
				<td>애덤 로비텔</td>
			</tr>
			<tr>
				<th>상영시간</th>
				<td>애덤 로비텔</td>
			</tr>
			<tr>
				<th>관람등급</th>
				<td>애덤 로비텔</td>
			</tr>
			<tr>
				<th>장르</th>
				<td>애덤 로비텔</td>
			</tr>
		</table>
		<div id="moviePlot">Irure laboris et enim et commodo est
			aliquip. Exercitation tempor et sunt dolor laboris nostrud incididunt
			duis irure nisi do amet. Qui sint ut officia id ullamco eiusmod qui.
			Nostrud ipsum velit est dolore do reprehenderit. Nulla sint proident
			id labore deserunt proident ex occaecat dolor fugiat.</div>
	</div>
	<div id="movieStillCuts">
		<div id="stillCutMoveLeft">◀</div>
		<div id="stillCutSection">
			<div id="stillCutBox">
				<img src="1.jpg" class="movieStillCut"> <img src="2.jpg"
					class="movieStillCut"> <img src="3.jpg" class="movieStillCut">
				<img src="1.jpg" class="movieStillCut">
			</div>
		</div>
		<div id="stillCutMoveRight">▶</div>
	</div>

	<div id="moveiTrailer">
		<div id="video">video 태그로 변경</div>
	</div>
</div>

<script src="${cpath }/resources/cinemaMovie/movieInfo/movieInfo.js"></script>

<%@ include file="../footer.jsp"%>