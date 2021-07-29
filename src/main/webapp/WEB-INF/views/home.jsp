<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="homeHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/commons/home.css">
<input type="hidden"  id="userAge" value="<c:out value="${login.userAge}"/>">
    <div id="movieList">
        <div id="movieSchedule">
            <div id="movieScheduleTitle">
                <div class="currentDate"></div>
            </div>
            <div class="movieNameList">
                <ul style="list-style: none;">
<!--                     <li><div class="movieName">발신제한</div></li> -->
                </ul>
            </div>
<!--             <div class="movieSelect"> -->
<!--                 <div class="movieSelectBox"><a href="" style="color:black">21:45<br>4관</a></div> -->
<!--                 <div class="movieSelectBox"><a href="" style="color:black">24:00<br>5관</a></div> -->
<!--             </div> -->
        </div>
        
        <div id="movieTop10">
            <ol type="1">
            
            </ol>
        </div>
    </div>

	<div class="eventTitle">── EVENTS ──</div>
	<div class="eventTitle">　2021　</div>

	<div class="eventContainer">
	<c:forEach var="dto" items="${mainEvent }">
		<a href="${cpath }/homeEventRead/${dto.event_idx}"> 
		<img src="${cpath }/uploadimage/${dto.eventListFileName}">
		</a> 
	</c:forEach>
	</div>


<div id="board">
        <div class="iconList">
            <a href="${cpath }/cinemaUser/myPage/myPageHome" style="color:black">
                <div class="icon"><img src="${cpath }/resources/commons/imgs/userIcon.png"></div>
                <div class="iconBottom">내정보</div>
            </a>
        </div>
        <div class="iconList">
            <a href="${cpath }/serviceCenter/oneToOne" style="color:black">
                <div class="icon"><img src="${cpath }/resources/commons/imgs/InformationIcon.png"></div>
                <div class="iconBottom">1:1문의</div>
            </a>
        </div>
        <div class="iconList">
            <a href="${cpath }/serviceCenter/noticeList" style="color:black">
                <div class="icon"><img src="${cpath }/resources/commons/imgs/boardIcon.png"></div>
                <div class="iconBottom">공지사항</div>
            </a>
        </div>
    </div>
<script src="${cpath }/resources/commons/home.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>