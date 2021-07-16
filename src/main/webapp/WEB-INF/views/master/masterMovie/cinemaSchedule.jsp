<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        /* logo font */
        @import url('https://fonts.googleapis.com/css2?family=Zen+Tokyo+Zoo&display=swap');
        @font-face {
            font-family: 'gmarket';
            src: url('font/GmarketSansTTFMedium.ttf') format('truetype');
        }

        /* 각 태그들의 크기를 직접 보시려면 border 주석을 제거하면 됩니다. */

        body {
            font-family: 'gmarket';
            font-size: 10pt;
        }
        header {
            border-bottom: 1px solid #dadada;
        }
        .header {
            display: inline-block;
            flex-flow: column;
            justify-content: center;
        }
        .Logo {
            font-size: 20px;
        }
        .mainPageLogo {
            display: flex;
            justify-content: flex-end;
            /* border: 1px solid black; */
        }
        .mainPageGo > h3 > a {
            text-decoration: none;
        }
        .header {
            width: 100%;
            /* border: 1px solid black; */
            text-align: center;
        }
        .nav { 
            padding: 20px;
        }
        .nav > ul > li {
            display: inline-block;
            padding-left: 25px;
            padding-right: 25px;
        }
        /*///////헤더부분//////////////////////////////////////////////////////////////*/
        .main {
            display: flex;
            flex-flow: column;
            justify-content: center;
            align-items: center;
        }
        .movieSelect {
            display: flex;
        }
        .selectName {
            display: flex;
            justify-content: center;
            align-items: center;
            /* border: 1px solid black; */
            width: 200px;
            height: 50px;
        }
        .movieName,.moviePlace,.date,.movieTime,.addNumber {
            width: 300px;
            height: 30px;
            border-radius: 10px;
            padding-left: 10px;
            margin: 15px 0;
            border: 0;
            white-space:nowrap;
            overflow:hidden;
            text-overflow:ellipsis;
            box-shadow:0.5px 0.5px 0.5px grey;
        }
        .addButton {
            width: 300px;
            height: 30px;
            border-radius: 10px;
            outline: none;
            border: 1px solid black;
            color: white;
            background-color: black;
            margin-top: 40px;
            cursor: pointer;
        }
        .movieAddButton {
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
   
    <div class="main">
        <div class="title">
            <h4>상영관 배치</h4>
        </div>
        <form method="post">
        <div class="movieSelect">
            <div class="selectName">
                영화선택
            </div>
            <div>
            <select class="movieName" name="movieName">
            	<c:forEach var="dto" items="${list }" >
                    <option value="${dto.movieName }">${dto.movieName }</option>
	            </c:forEach>
            </select>
            </div>
        </div>
        <div class="movieSelect">
            <div class="selectName">
                상영관 선택
            </div>
            <div>
            <select class="moviePlace" name="hallName">
	            <c:forEach var="dto2" items="${list2 }">
                    <option value="${dto2.hallName }">${dto2.hallName }</option>
          	  	</c:forEach>
           	</select>
            </div>
        </div>
        <div class="movieSelect">
            <div class="selectName">
                날짜선택
            </div>
            <div>
                <input type="date" name="day" class="date">
            </div>
        </div>
        <div class="movieSelect">
            <div class="selectName">
                시간선택
            </div>
            <div>
            <input type="time" name="time" class="movieTime">
            </div>
        </div>
        <div class="movieAddButton">
            <input type="submit" value="영화 추가하기" class="addButton">
        </div>
    </form>
    </div>



	<script>
    const form = document.forms[0]
    form.onsubmit = function(event) {
       event.preventDefault()
       const showDay = document.querySelector('input[name="day"]').value.replace(/-/gi,'')
       const startTime = document.querySelector('input[name="time"]').value.replace(/:/,'')
     
      
       const startTimeReal = showDay + startTime
       console.log(startTimeReal)
      
       const dateTime1 = document.createElement('input')
       dateTime1.type = 'hidden'
       dateTime1.name = 'showDay'
       dateTime1.value = showDay
       event.target.appendChild(dateTime1)
      
       const dateTime2 = document.createElement('input')
       dateTime2.type = 'hidden'
       dateTime2.name = 'startTime'
       dateTime2.value = startTimeReal
       event.target.appendChild(dateTime2)
       event.target.submit()
    }
</script>
	




</body>
</html>