<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterNoticeList.css">
<style>
        #boardContainer {
            width: 100%;
            height: 900px;
    /*      border: 1px solid black;        */
            text-align: center;
            margin-top: 100px;
        }
        #boardMenu {
            width: 500px;
            height: 30px;
            border-bottom: 1px solid gray;
            display: flex;
            margin: 0 auto;
            justify-content: space-between;
            align-items: center;
        }
        #boardMenu > a {
            width: 160px;
            text-decoration-line: none;
            color: black;
        }
        #boardList {
            float: top;
        /*  border: 1px solid green; */
        }
        table {
            width: 850px;
            height: auto;
            margin: 0 auto;
            margin-bottom: 30px;
            margin-top: 50px;
            border-collapse: collapse;
            border: 1px;
            outline: none;
            font-family: "gmarketLight";
            font-weight: bold;
            font-size: 9pt;
        }
        table a {
            text-decoration-line: none;
            color: black;
        }
        th {
            text-align: center;
            padding-top: 16px;
            padding-bottom: 15px;
            border: none;
            outline: none;
            border-bottom: 1px solid rgb(219, 219, 219);
        }
        .content {
            text-align: left;
            padding-left: 40px;
        }

        .paging {
     /*     border: 1px solid black;  */
            display:flex;
            align-items: center;
            width: 850px;
            height: 50px;
            margin: 0 auto;
        }
        button {
            width: 100px;
            height: 30px;
            float: right;
            margin-top: 6%;
            margin-bottom: 60px;
            background-color: white;
            border: 1px solid gray;
            color: rgb(102, 102, 102);
            font-family: "gmarketLight";
            font-weight: bold;
            cursor: pointer;
        }
        #number {
            width: 300px;
            margin: 0 auto;
            margin-left: 30%;
 /*         border: 1px solid red;  */
        }
        #number  a {
            margin-left: 5%;
            text-decoration-line: none;
            color: black;

        }
</style> 	
<div id="boardContainer">
      <div id="boardMenu">
         <a href="${cpath }/master/masterServiceCenter/masterNoticeList"><div class="notice">공지사항</div></a> 
         <a href="${cpath }/master/masterServiceCenter/masterOneToOne"><div class="inquiry">1:1문의</div></a> 
         <a href="${cpath }/master/masterServiceCenter/masterLost"><div class="lostAndFound">분실물 문의</div></a>
      </div>


	<div class="boardList">
		<table>
			<tr>
				<th>작성일</th>
				<th>종류</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>분실일</th>
			</tr>
		<c:forEach var="dto" items="${lostList }">
			<tr>
				<td>${dto.cinemaLostToDay }</td>
				<td><a href="${cpath}/master/masterServiceCenter/masterLostRead/${dto.cinemaLost_idx}">${dto.cinemaLostKind }</a></td>
				<td>${dto.cinemaLostName }</td>
				<td>${dto.cinemaLostPH }</td>
				<td>${dto.cinemaLostDateTime }</td>
			</tr>
		</c:forEach>
		</table>

		<div class="paging">
			<div id="number">
				<c:if test="${paging.prev }">
					<a href="${cpath }/master/masterServiceCenter/masterLost">
						[처음] </a>
				</c:if>

				<c:if test="${paging.prev }">
					<a
						href="${cpath }/master/masterServiceCenter/masterLost?page=${paging.begin-1}">[이전]
					</a>
				</c:if>

				<c:if test="${empty param.page}">
					<a href="${cpath }/master/masterServiceCenter/masterLost"><strong>1</strong></a>
				</c:if>

				<c:forEach var="i"
					begin="${empty param.page ? paging.begin + 1 : paging.begin}"
					end="${paging.end }">
					<span> ${i == param.page ? '<strong>' : '' } <c:if
							test="${i ==1 }">
							<a href="${cpath }/master/masterServiceCenter/masterLost">${i }</a>
						</c:if> <c:if test="${i != 1}">
							<a
								href="${cpath }/master/masterServiceCenter/masterLost?page=${i}">${i }</a>
						</c:if> ${i == param.page ? '</strong>' : '' }
					</span>
				</c:forEach>

				<c:if test="${paging.next }">
					<a
						href="${cpath }/master/masterServiceCenter/masterLost?page=${paging.end+1}">[다음]
					</a>
				</c:if>

				<c:if test="${paging.next }">
					<a
						href="${cpath }/master/masterServiceCenter/masterLost?page=${paging.pageCount}">[맨끝]
					</a>
				</c:if>

			</div>
		</div>


	</div>
</div>

</body>
</html>