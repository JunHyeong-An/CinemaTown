<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/serviceCenter/oneToOne.css">

 <div id="boardContainer">
        <div id="boardMenu">
            <div class="oneToOne">1:1 문의</div>
        </div>
        <form method="POST">
            <div class="writeForm">
                <div class="writeSelect">
                    - 문의종류 선택 -<br>
                    <select name="otoKind">
                        <option value="오류">오류</option>
                        <option value="예매 문의">예매문의</option>
                        <option value="개인정보">개인정보</option>
                        <option value="영화관">영화관</option>
                        <option value="개인정보">개인정보</option>
                        <option value="기타">기타</option>
                    </select>
                </div>
                <input type="hidden" name="userId" value="${userId }"readonly>
            <div class="writeTitle"><input type="text" name="otoTitle" placeholder="제목을 입력하세요"> </div>
                <div class="writeContent"><textarea name="otoContent" placeholder="내용을 입력하세요"></textarea></div>
                <div class="writeButton">
                    <input type="submit" 
                    style="outline: none; background-color: black; border:none; color:white; cursor: pointer; font-family: gmarketLight; font-weight: 800;"
                    value="문의하기">
                 </div>
            </div>
		</form>
  </div>
<%@ include file="../footer.jsp" %>