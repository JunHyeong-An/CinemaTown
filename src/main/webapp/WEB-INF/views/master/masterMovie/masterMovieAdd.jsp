<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${cpath }/resources/master/masterMovie/masterMovieAdd.css">
</head>
<body>
	<div class="main">
		<div>
			<h4>영화등록</h4>
		</div>
		<div>
			<span><input type="text" name="movieName" id="searchName"></span>
			<span class="imgSpan"><img src="selectEmoticon.PNG"
				id="EmoticonImg"></span>
		</div>
		<!--이 부분은 위에 영화 검색을 하면 글자와 관련된 제작년도 2021년인 영화이름들이 나옵니다-->
		<div class="searchList">
			<ul class="ulList">

			</ul>
		</div>
		<div class="searchTitle">
			<h4>선택한 영화 정보</h4>
		</div>
		<form method="POST">
			<div class="tableMovie">
					<div class="movieInfo">
					<!-- 영화 포스터, 이름 ,등급, 상영시간, 영화코드 DB에 전해줍니다 -->
						영화 포스터 : <input type="url" name=urlName id="urlName" readonly>
						영화 이름 : <input type="text" name="movieName" id="movieNameText"
							readonly> 영화 등급 : <input type="text" name="ageLimit"
							id="ageLimit" readonly> 영화 상영 시간 : <input type="text"
							name="runningTime" id="runningTime" readonly> <input
							type="hidden" name="movieCode" id="movieSeq" readonly>
					
					</div>
			</div>
			<div>
				<input type="submit" value="영화 추가하기" class="insertMovieButton">
			</div>
		</form>
	</div>
	<script src="${cpath }/resources/master/masterMovie/masterMovieAdd.js"></script>
</body>
</html>