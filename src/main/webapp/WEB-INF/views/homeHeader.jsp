<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<c:set var="movieCodeList" value="${movieCodeList }"/>
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
<c:forEach items="${movieCodeList }" var="movieCode">
	<input type="hidden" value="${movieCode }" class="movieCodes">
</c:forEach>
<script>
	const cpath = "${cpath}"
</script>
	<header>
        <div id="headerBanner">
            <img src="${cpath }/resources/commons/imgs/상단광고.jpg">
            <span id="bannerCloseBtn">X</span>
        </div>
        <!-- header안에 맨위에있는 로그인 박스 -->
        <div id="loginStatusBox">
            <ul id="loginStatus">
            	<c:if test="${empty login and empty cookie.loginCookie}">
                	<li><a href="${cpath }/cinemaUser/login">로그인</a></li>
                	<li><a href="${cpath }/cinemaUser/tos">회원가입</a></li>
            	</c:if>
            	<c:if test="${not empty login or not empty cookie.loginCookie }">
            		<li><a href="${cpath }/cinemaUser/logout">로그아웃</a></li>
                	<li><a href="${cpath }/cinemaUser/myPage/myPageHome">마이페이지</a></li>
            	</c:if>
            </ul>
        </div>
        <!-- 로고 -->
        <h1 id="logo">CINEMA TOWN</h1>

        <!-- 로고 밑에 들어가는 메뉴를 전체적으로 감싸는 div(나중에 들어갈 드롭 메뉴에 사용될 것으로 예상. 사용되지 않으면 제거해도 무방합니다.) -->
        <div id="headerListBox">
            <!-- 실질적인 메뉴 headerList에 css로 display:flex를 줘서 전부 가로로 정렬 시킴-->
            <ul id="headerList">
                <li><div class="menuText">영화</div><div class="dropDownMenu hidden"><a href="${cpath }/cinemaMovie/schedule">상영시간표</a></div></li>
                <li><div class="menuText">예매</div><div class="dropDownMenu hidden"><a href="${cpath }/cinemaMovie/ticketing">예매</a></div></li>
                <li><div class="menuText">이벤트</div><div class="dropDownMenu hidden"><a href="${cpath }/cinemaEvent/movieEvent">이벤트</a></div></li>
                <li>
                    <div class="menuText">고객센터</div>
                    <div id="serviceCenterDropDown" class="dropDownMenu hidden">
                        <a href="${cpath }/serviceCenter/noticeList" class="serviceCenterDropDownElement">공지사항</a>
                        <a href="${cpath }/serviceCenter/oneToOne" class="serviceCenterDropDownElement">일대일 문의</a>
                        <a href="${cpath }/serviceCenter/lost" class="serviceCenterDropDownElement">분실물 문의</a>
                    </div>
                </li>
            </ul>
        </div>

        <div id="posterSection">
            <div id="posterBox">
            	<div id="posterSectionImg">      
<%-- 	            		<img src="${movieUrlList }" class="mainPoster">                                                               		 --%>
            	</div>
            </div>
        </div>
    </header>
<script src="${cpath }/resources/commons/homeHeader.js"></script>