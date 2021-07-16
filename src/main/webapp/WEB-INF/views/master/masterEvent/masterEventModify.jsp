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
         /* border: 1px solid black;    */
            width: 45%;
            height: 750px;
            position: relative;
            margin-top: 50px;
            padding-top: 40px;
            align-items: center;
            align-content: center;
            justify-content: center;
            text-align: center;
            margin: 0 auto;
        }
        .eventTitle {
            font-size: 12pt;
            border-bottom: 1.5px solid gray;
            width: 120px;
            height: 20px;
            float: top;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0 auto;
            margin-bottom: 70px;
            margin-top: 50px;
        }
        .container {
            width: 400px;
            height: 300px;
     /*     border: 1px solid blue;     */
            margin: 0 auto;
        }
        .msgTitle {
            margin-top : 20px;
            width: 100%;
     /*     border: 1px solid red;  */
            display: flex;
            margin-left: 4%;
            margin-bottom: 10px;
        }

        .msg {
            width: 350px;
            height: 160px;
            border: 1px solid rgb(117, 117, 117);
            border-radius: 10px;
            margin-top: 20%;
            margin-bottom: 5px;
            margin: 0 auto;
            padding: 10px 10px 10px 10px;
            text-align: left;
            font-family: sans-serif;
            position: relative;
        }
        textarea {
            width: 100%;
            height: 100%;
            border: none;
            resize: none;
            outline: none;
        }
        p {
            float: left;
            margin-left: 5%;
            margin-top: 10px;
        }
        .eventDate {
     /*       border: 1px solid red;  */
            font-size: 11pt;
            margin: 0 auto;
            margin-top: 30px;
            width: 370px;
            float: top;
            display: flex;
            justify-content: space-between;
        }
        .eventDatePick {
     /*       border: 1px solid green;  */
            width: 40%;
            height: 50px;
            margin-right: 10px;
            margin-bottom: 50px;
        }

        .modifyButton {
            width: 370px;
            height: 30px;
            border: 1px solid black;
            background-color: black;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 40px;
            margin: 0 auto;
            color: white;
        }
    </style>
</head>
<body>
   
    <div class="eventMain">

        <div class="eventTitle">
            이벤트 수정
        </div>
        <form method="POST" enctype="multipart/form-data">
        <c:forEach var="dto" items="${list }">
        <div class="container">
            <div class="msgTitle"><input type="text" name="eventListTitle" 
                style="border-style: none; outline:none; border-bottom: 1.5px solid black;" 
                placeholder="이벤트 제목" value="${dto.eventListTitle }"></div>
            <div class="msg"><textarea name="eventListContent" placeholder="내용을 입력하세요.">${dto.eventListContent }</textarea></div>
            <p><input type="file" name="files" accept="image/*" style="color: rgb(104, 103, 103);" placeholder="파일 선택"/></p>
        </div>
        <div class="eventDate">
            <div class="eventDatePick">시작날짜<br><input type="date" name="start_time"></div>
            <div class="mid" style="font-size: 20pt; margin-top: 25px;">~</div>
            <div class="eventDatePick">종료날짜<br><input type="date" name="end_time"></div>
        </div>
        <div class="modifyButton">
           <input type="submit" 
           style="outline: none; background-color: black; border:none; color:white; cursor: pointer;"
           value="이벤트 수정하기">
        </div>
        </c:forEach>
       </form>
    </div>



</body>
</html>