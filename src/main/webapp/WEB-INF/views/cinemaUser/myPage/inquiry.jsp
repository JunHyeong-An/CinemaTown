<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/inquiry.css">

<!-- 	1:1문의 내역 리스트 불러오기 , 리스트에 링크달아 세부내용 보기(inquiryRead.jsp)  -->
    <div class="all">
        <div class="head">
            <div class="myInquiry">내문의</div>
        </div>
        <c:forEach var="dto" items="${inquiryList}">
            <div class="board">
                <div class="idx">${dto.oneToOne_idx}</div>
                <div class="kind">문의종류 : ${dto.otoKind}</div>
                <div class="title"><a href="${cpath}/cinemaUser/myPage/inquiryRead/${dto.oneToOne_idx}">${dto.otoTitle }</a></div>
                <div class="time">${dto.otoWriteDay }</div>
            </div>
        </c:forEach>
    </div>
<%@ include file="../../footer.jsp"%>