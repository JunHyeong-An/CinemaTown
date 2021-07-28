<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterOneToOne2.css">

    <div id="boardContainer">
        <div class="boardForm">
            <div class="boardTitle" name="boardTitle">${dto.otoTitle }</div>
            <div class="miniContainer"><div class="wdate" name="date">${dto.otoWriteDay }</div></div>
            <div class="id">
                <div class="userId">작성자　　${dto.userId }</div>
                <div class="kind">문의종류　${dto.otoKind }</div>
            </div>
            <div class="content">${dto.otoContent }</div>
            <div class="reply">
            	<c:if test="${not empty replyList }">
					<c:forEach var="reply" items="${replyList}">
						<div style="display:flex; margin-bottom:10px;">
							<div style="width:150px;">${reply.answerDay }</div>${reply.answerContent } 
						</div>
					</c:forEach>
				</c:if>
			</div>
            <form method="POST">     
                <input type="hidden" name="oneToOne_idx" value="${dto.oneToOne_idx } ">     
                <textarea name="answerContent" placeholder="답글 입력하기"></textarea>     
                <div class="button"><input type="submit" value="등록" style="outline:none; border: 1px solid black; border-radius: 5px; background-color: black; color:white; cursor:pointer; width: 100px; height: 30px; margin-top:5px;"></div>
            </form> 

        </div>
    </div>



</body>
</html>