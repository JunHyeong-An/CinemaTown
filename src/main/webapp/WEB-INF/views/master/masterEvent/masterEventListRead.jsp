<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        
        .eventMain {
 /*         border: 1px solid black;    */
            width: 100%;
            height: 900px;
            position: relative;
            margin-top: 50px;
            padding-top: 40px;
            align-items: center;
            align-content: center;
            justify-content: center;
            text-align: center;
        }
        .eventTitle {
            font-size: 12pt;
            border-bottom: 1.5px solid gray;
            width: 10%;
            height: 20px;
            float: top;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto;
        }
        .eventImg img{
            margin-top: 45px;
            margin-bottom: 20px;
            box-shadow: 2px 2px 3px gray;
        }
        .smallTitle {
            margin-top: 30px;
        }

        .msg {
            width: 350px;
            height: 160px;
            border: 1px solid rgb(117, 117, 117);
            border-radius: 10px;
            margin: 0 auto;
            margin-top: 10px;
            margin-bottom: 50px;
            padding: 10px 10px 10px 10px;
            text-align: left;
            font-family: sans-serif;
        }
        .eventDate {
            color:rgb(117, 117, 117);
            font-size: 11pt;
            margin-top: 15px;
        }
        .modifyButton {
            width: 360px;
            height: 30px;
            border: 1px solid black;
            background-color: black;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto;
            margin-top: 40px;
            color: white;
        }
    </style>
</head>
<body>
    
    <div class="eventMain">
        <div class="eventTitle">
            이벤트 상세
        </div>
		<c:forEach var="dto" items="${list }">
        <div class="eventImg"><img src="${cpath }/resources/master/img/${dto.event_idx }.jpg" width="220px"></div>
        <div class="smallTitle">${dto.eventListTitle }</div>
        <div class="msg">
        	${dto.eventListContent }
        </div>
        <div class="smallTitle">이벤트 기간</div>
        <div class="eventDate">${dto.start_time } ~ ${dto.end_time }</div>
        <a href="${cpath }/master/masterEvent/masterEventModify/${dto.event_idx}"><div class="modifyButton">이벤트 수정하기</div></a>
        <a href="${cpath }/master/masterEvent/masterEventDelete/${dto.event_idx}"><div class="modifyButton">이벤트 삭제하기</div></a>
 		</c:forEach>
    </div>


</body>
</html>