<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterNoticeAdd.css">
    
    <div id="boardContainer">
        <div id="boardMenu">
            <div class="notice">공지사항 작성</div>
        </div>
        	<form method="POST" enctype="multipart/form-data">
            <div class="writeForm">
                <div class="writeTitle"><input type="text" name="noticeTitle" placeholder="제목을 입력하세요"> </div>
                <div class="writeContent"><textarea name="noticeContent" placeholder="내용을 입력하세요"></textarea></div>
                <p><input type="file" name="files" accept="image/*" style="color: rgb(104, 103, 103);" placeholder="파일 선택"/></p>
                <div class="writeButton">
                    <input type="submit" 
                    style="outline: none; background-color: black; border:none; color:white; cursor: pointer; font-family: gmarketLight; font-weight: 800;"
                    value="등록하기">
                 </div>
            </div>
			</form>
        </div>

</body>
</html>