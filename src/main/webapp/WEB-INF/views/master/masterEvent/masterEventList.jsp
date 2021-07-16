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
    /*      border: 1px solid black;  */
            width: 100%;
            height: 1200px;
            position: relative;
            margin-top: 50px;
            padding-top: 40px;
            align-items: center;
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
        .eventContainer {
    /*      border: 1px solid blue;  */
            width: auto;
            height: 1000px;
            margin-top: 90px;
            padding: 20px 20px 20px 20px;
            position: relative;
        }
        .eventTop {
 /*         border: 1px solid darkcyan;  */
            width: 100%;
            height: 70px;
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;

        }
        .smallTitle {
            border-bottom: 1px solid gray;
            width: 45%;
            height: 20px;
            float: top;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .addEvent {
            width: 85px;
            height: 85px;
            border: 1px solid black;
            border-radius: 50px;
            background-color: black;
            float: top;
            display: flex;
            justify-content: center;
            align-items: center;
            box-shadow: 1.5px 1.5px 1.5px rgb(97, 96, 96);
        }
        .addEvent > a {
            color: white;
        }
        .listContainer {
    /*      border: 1px solid palevioletred;  */
            width: 100%;
            height: 950px;
            display: flex;
            position: relative;
            justify-content: center;    
        }
        .eventList1, .eventList2 {
    /*        border: 1px solid orange;  */
            width: 42%;
            height: 900px;
            margin-top: 30px;
            position: relative;
            justify-content: center;
        }
        .line1, .line {
            width: 3%;
            height: 910px;
    /*      border: 1px solid red;  */
            margin-top: 9px;
        }
        .line1 {
            border-right: 1px solid gray;
        }

        .events {
    /*      border: 1px solid black;  */
            width: 40%;
            height: auto;
            justify-content: center;
            text-align: center;
            float: left;
            margin-left: 7%;
            margin-top: 30px;
        }
        .events img {
            box-shadow: 1.5px 1.5px 3px rgb(128, 126, 126);
        }
        .eventDate {
            margin-top: 5px;
        }
    </style>
</head>
<body>
    
    <div class="eventMain">
        <div class="eventTitle">
            이벤트 관리
        </div>
        <div class="eventContainer">
    
            <div class="eventTop">
                <div class="smallTitle">진행중인 이벤트</div>
                <div class="addEvent"><a href="${cpath }/master/masterEvent/masterEventAdd">이벤트 추가</a></div>
                <div class="smallTitle">종료된 이벤트</div>
            </div>
    
            <div class="listContainer">
                <div class="eventList1">
    				<c:forEach var="dto" items="${list }">
                    <div class="events"><a href="${cpath }/master/masterEvent/masterEventListRead/${dto.event_idx}">
                    <img src="${cpath }/uploadimage/${dto.eventListFileName}" width="160px"></a>
                        <div class="eventDate">${dto.start_time } ~ ${dto.end_time }</div>
                    </div>
                    </c:forEach>
    
                </div>
    
                <div class="line1"></div>
                <div class="line"></div>
    
                <div class="eventList2">
       				<c:forEach var="dto2" items="${list2 }">				
                    <div class="events"><a href="${cpath }/master/masterEvent/masterEventListRead/${dto2.event_idx}">
                    <img src="${cpath }/uploadimage/${dto2.eventListFileName}" width="160px"></a>
                        <div class="eventDate">${dto2.start_time } ~ ${dto2.end_time }</div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>





</body>
</html>