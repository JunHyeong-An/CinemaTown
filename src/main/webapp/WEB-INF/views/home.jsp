<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="homeHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/commons/home.css">
    <div id="movieList">
        <div id="movieSchedule">
            <div id="movieScheduleTitle">
                <div class="currentDate">2021년 7월 7일</div>
            </div>
            <div class="movieNameList">
                <ul style="list-style: none;">
                    <li><div class="movieName">발신제한</div></li>
                    <li><div class="movieName">콰이어트 플레이스2</div></li>
                    <li><div class="movieName">킬러의 보디가드2</div></li>
                    <li><div class="movieName">크루엘라</div></li>
                    <li><div class="movieName">미드나이트</div></li>
                    <li><div class="movieName">컨저링</div></li>
                </ul>
            </div>
            <div class="movieSelect">
                <div class="movieSelectBox"><a href="" style="color:black">21:45<br>4관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">24:00<br>5관</a></div>
            </div>
            <div class="movieSelect">
                <div class="movieSelectBox"><a href="" style="color:black">09:05<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">12:05<br>2관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">18:15<br>3관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">20:00<br>1관</a></div>

            </div>
            <div class="movieSelect">
                <div class="movieSelectBox"><a href="" style="color:black">09:05<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">12:05<br>2관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">18:15<br>3관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">20:00<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">21:45<br>4관</a></div>
            </div>
            <div class="movieSelect">
                <div class="movieSelectBox"><a href="" style="color:black">09:05<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">12:05<br>2관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">20:00<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">21:45<br>4관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">24:00<br>5관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">21:45<br>4관</a></div>
            </div>
            <div class="movieSelect">
                <div class="movieSelectBox"><a href="" style="color:black">09:05<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">24:00<br>5관</a></div>
            </div>
            <div class="movieSelect">
                <div class="movieSelectBox"><a href="" style="color:black">09:05<br>1관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">12:05<br>2관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">18:15<br>3관</a></div>
                <div class="movieSelectBox"><a href="" style="color:black">24:00<br>5관</a></div>
            </div>
        </div>
        
        <div id="movieTop10">
            <ol type="1">
                <li><a href="" style="color:white">　발신제한</a></li>
                <li><a href="" style="color:white">　킬러의 보디가드2</a></li>
                <li><a href="" style="color:white">　콰이어트 플레이스2</a></li>
                <li><a href="" style="color:white">　크루엘라</a></li>
                <li><a href="" style="color:white">　루카</a></li>
                <li><a href="" style="color:white">　미드나이트</a></li>
                <li><a href="" style="color:white">　인 더 하이츠</a></li>
                <li><a href="" style="color:white">　체르노빌</a></li>
                <li><a href="" style="color:white">　컨저링3</a></li>
                <li><a href="" style="color:white">　빛나는 순간</a></li>
            </ol>
        </div>
    </div>


    <div id="board">
        <div class="iconList">
            <a href="" style="color:black">
                <div class="icon"><img src="userIcon.png"></div>
                <div class="iconBottom">내정보</div>
            </a>
        </div>
        <div class="iconList">
            <a href="" style="color:black">
                <div class="icon"><img src="InformationIcon.png"></div>
                <div class="iconBottom">1:1문의</div>
            </a>
        </div>
        <div class="iconList">
            <a href="" style="color:black">
                <div class="icon"><img src="boardIcon.png"></div>
                <div class="iconBottom">공지사항</div>
            </a>
        </div>
    </div>
<script src="${cpath }/resources/commons/home.js"></script>
<%@ include file="footer.jsp" %>
</body>
</html>