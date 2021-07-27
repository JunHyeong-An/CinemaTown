<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterNoticeList.css">
<style>
        .boardForm {
      /*    border: 1px solid black;    */
            width: 100%;
            height: 1000px;
        }
        .boardTitle {
            padding-bottom: 20px;
            border-bottom: 1px solid rgb(216, 216, 216);
            width: 1000px;
            height: 40px;
            display: flex;
            align-items: center;
            text-align: center;
            justify-content: center;
            margin: 0 auto;
            font-size: 20pt;
            margin-top: 200px;
        }
        .miniContainer {
            width: 1000px;
            height: 30px;
            margin: 0 auto;
    /*      border: 1px solid orange;   */
            margin-top: 20px;  
        }
        .wdate {
            width: 200px;
            float: right;
            font-size: 10pt;
            text-align: right;
        }

        .id {
            width: 1000px;
            height: 30px;
       /*   border: 1px solid green; */
            margin: 0 auto;
            text-align: left;
        }
        .id > div {
        	margin-bottom: 10px;
        }
        .contentImg {
        /*  border: 1px solid purple;  */
            width: 1000px;
            height: fit-content;    
            margin: 0 auto;
            margin-top: 20px;
            justify-content: center;
        }

        .content {
    /*      border: 1px solid rgb(187, 187, 187);     */
            width: 1000px;
            height: 200px;
            margin: 0 auto;
            margin-top: 40px;
            text-align: left;
            padding: 20px 20px 20px 20px;
            font-family: 'gmarketLight';
            font-weight: 600;
            font-size: 12pt;
            border-bottom: 1px solid rgb(216, 216, 216);
        }
        .reply {
        	margin: 0 auto;
        	margin-top: 30px;
        	margin-bottom: 20px;
        	justify-content: space-between;
        	width: 1000px;
        	text-align: left;
        }
        form {
            width: 100%;
            height: 150px;
         /*   border: 1px solid red;   */
            margin-top: 30px;
            text-align: center;
            
        }
        textarea {
            resize: none;
            width: 1000px;
            height: 100px;
            border: 1px solid rgb(216, 216, 216);
            border-radius: 10px;
            outline: none;
            padding: 10px 10px 10px 10px;
            margin: 0 auto;

        }

        button {
            width: 100px;
            height: 30px;
            border: 1px solid black;
            background-color: black;
            border-radius: 5px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto;
            margin-bottom: 10px;
            color: white;
        }
</style>
</head>
<body>

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