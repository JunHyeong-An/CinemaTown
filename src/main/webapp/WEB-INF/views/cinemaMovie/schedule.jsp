<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaMovie/schedule/schedule.css">

	<div class="title">
		<h2>상영시간표</h2>
	</div>
	<div class="head">
		<div class="all"></div>
		<div class="dayList">
			<!-- <div class="day">20</div> -->
		</div>
	</div>
	<div>
		<div class="movieInfo">
			<div class="ageLimit">12</div>
			<div class="movieName">블랙위도우 (134분)</div>
		</div>
		<div>
			<div class="oneSpace">
				<div class="movieInfoDetail">09:30 11:44 64/72 1관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 1관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 1관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 1관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 1관</div>
			</div>
			<div class="twoSpace">
				<div class="movieInfoDetail">09:30 11:44 64/72 2관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 2관</div>
			</div>
			<div class="threeSpace">
				<div class="movieInfoDetail">09:30 11:44 64/72 3관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 3관</div>
				<div class="movieInfoDetail">09:30 11:44 64/72 3관</div>
			</div>
		</div>
	</div>
	<hr>
<script src="${cpath }/resources/cinemaMovie/schedule/schedule.js"></script>

<%@ include file="../footer.jsp"%>