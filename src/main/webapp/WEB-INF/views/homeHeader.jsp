<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="movieNameList" value="${movieNameList }"/>
<c:forEach var="name" items="${movieNameList }">
	<input class="movieNames" type="hidden" value="${name }">
</c:forEach>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="${cpath }/resources/commons/homeHeader.css">
<link rel="stylesheet" href="${cpath }/resources/commons/footer.css">
</head>
<body>
	<header>
        <div id="headerBanner">
            <img src="${cpath }/resources/commons/imgs/상단광고.jpg">
            <span id="bannerCloseBtn">X</span>
        </div>
        <!-- header안에 맨위에있는 로그인 박스 -->
        <div id="loginStatusBox">
            <ul id="loginStatus">
            	<c:if test="${empty login }">
                	<li><a href="${cpath }/cinemaUser/login">로그인</a></li>
                	<li><a href="${cpath }/cinemaUser/join">회원가입</a></li>
            	</c:if>
            	<c:if test="${not empty login }">
            		<li><a href="${cpath }/cinemaUser/logout">로그아웃</a></li>
                	<li><a href="${cpath }/cinemaUser/mypage">마이페이지</a></li>
            	</c:if>
            </ul>
        </div>
        <!-- 로고 -->
        <h1 id="logo">CINEMA TOWN</h1>

        <!-- 로고 밑에 들어가는 메뉴를 전체적으로 감싸는 div(나중에 들어갈 드롭 메뉴에 사용될 것으로 예상. 사용되지 않으면 제거해도 무방합니다.) -->
        <div id="headerListBox">
            <!-- 실질적인 메뉴 headerList에 css로 display:flex를 줘서 전부 가로로 정렬 시킴-->
            <ul id="headerList">
                <li><div class="menuText">영화</div><div class="dropDownMenu hidden"><a>상영시간표</a></div></li>
                <li><div class="menuText">예매</div><div class="dropDownMenu hidden"><a href="${cpath }/cinemaMovie/ticketing">예매</a></div></li>
                <li><div class="menuText">이벤트</div><div class="dropDownMenu hidden"><a>이벤트</a></div></li>
                <li>
                    <div class="menuText">고객센터</div>
                    <div id="serviceCenterDropDown" class="dropDownMenu hidden">
                        <a href="${cpath }/serviceCenter/notice" class="serviceCenterDropDownElement">공지사항</a>
                        <a href="${cpath }/serviceCenter/oneToOne" class="serviceCenterDropDownElement">일대일 문의</a>
                        <a href="${cpath }/serviceCenter/lost" class="serviceCenterDropDownElement">분실물 문의</a>
                    </div>
                </li>
            </ul>
        </div>

        <div id="posterSection">
            <div class="movePoster">◀</div>
            <div id="posterBox">
            	<div id="posterSectionImg">                                                           
	            	<div class="mainPoster" style="background-color: red;"></div>
	            	<div class="mainPoster" style="background-color: green;"></div>
	            	<div class="mainPoster" style="background-color: yellow;"></div>
	            	<div class="mainPoster" style="background-color: blue;"></div>
	            	<div class="mainPoster" style="background-color: orange;"></div>
	            	<div class="mainPoster" style="background-color: white;"></div>
	            	<div class="mainPoster" style="background-color: lightgray;"></div>
            	</div>
            </div>
            <div class="movePoster">▶</div>
        </div>
    </header>
<script src="${cpath }/resources/commons/homeHeader.js"></script>