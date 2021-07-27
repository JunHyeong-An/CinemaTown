<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterNoticeList.css">
<style>
        .boardForm {
        /*  border: 1px solid black;     */
            width: 100%;
            height: 600px;
        }
        .boardTitle {
            padding-bottom: 10px;
            border-bottom: 1px solid rgb(216, 216, 216);
            width: 600px;
            height: 40px;
            display: flex;
            align-items: center;
            text-align: center;
            justify-content: center;
            margin: 0 auto;
            margin-top: 10px;
            margin-bottom: 20px;
            font-size: 20pt;
        }
        .miniContainer {
            width: 1000px;
            height: 30px;
            margin: 0 auto;
         /*   border: 1px solid orange;    */
            margin-top: 20px;  
        }
        .ex {
            width: 70px;
        }
        .wdate {
            width: 400px;
            float: top;
            margin-left: 30%;
            font-size: 10pt;
            text-align: left;
        /*    border: 1px solid sienna; */
            display: flex;
            margin-bottom: 5px;
        }
        .name {
            width: 300px;
            float: top;
            margin-left: 30%;
            font-size: 10pt;
            text-align: left;
        /*    border: 1px solid sienna; */
            display: flex;
            margin-bottom: 5px;
        }
        .birth {
            width: 300px;
            float: top;
            margin-left: 30%;
            font-size: 10pt;
            text-align: left;
       /*     border: 1px solid sienna; */
            display: flex;
            margin-bottom: 5px;
        }
        .phone {
            width: 300px;
            float: top;
            margin-left: 30%;
            font-size: 10pt;
            text-align: left;
        /*    border: 1px solid sienna; */
            display: flex;
            margin-bottom: 5px;
        }

        .content {
            border: 1px solid rgb(187, 187, 187);   
            border-radius: 10px;  
            width: 900px;
            height: 250px;
            margin: 0 auto;
            margin-top: 20px;
            text-align: left;
            padding: 20px 20px 20px 20px;
            font-family: 'gmarketLight';
            font-weight: 600;
            font-size: 12pt;
            
        }
</style>
</head>
<body>

 <div id="boardContainer">
        <div class="boardForm">
            <div class="boardTitle">${dto.cinemaLostKind }</div>
            <div class="wdate"><div class="ex">분실일</div>${dto.cinemaLostDateTime }</div>
            <div class="wdate"><div class="ex">작성일</div>${dto.cinemaLostToDay }</div>
            <div class="name"><div class="ex">작성자</div>${dto.cinemaLostName }</div>
            <div class="birth"><div class="ex">생년월일</div>${dto.cinemaLostBirth }</div>
            <div class="phone"><div class="ex">연락처</div>${dto.cinemaLostPH }</div>
            <div class="content">${dto.cinemaLostContent }</div>
        </div>
    </div>



</body>
</html>