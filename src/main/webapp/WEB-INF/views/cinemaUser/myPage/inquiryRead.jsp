<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/inquiryRead.css">

<div class="main">
        <div class="readTitle"><h1>제목 : ${dto.otoTitle }</h1></div>
        <div class="readId">아이디 : ${dto.userId }</div>
        <div class="idKind">
            <div class="readKind">종류 : ${dto.otoKind }</div>
            <div class="readDate">날짜 : ${dto.otoWriteDay }</div>
        </div>
        <hr>
        <div class="readContent">내용: ${dto.otoContent }
        </div>
        <div class="Page"><a href="${cpath }/cinemaUser/myPage/inquiry"><button class="beforePage">이전페이지로</button></a></div>
    </div>
</body>
</html>