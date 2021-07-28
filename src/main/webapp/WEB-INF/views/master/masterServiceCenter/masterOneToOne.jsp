<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterOneToOne.css">
<div id="boardContainer">
      <div id="boardMenu">
         <a href="${cpath }/master/masterServiceCenter/masterNoticeList"><div class="notice">공지사항</div></a> 
         <a href="${cpath }/master/masterServiceCenter/masterOneToOne"><div class="inquiry">1:1문의</div></a> 
         <a href="${cpath }/master/masterServiceCenter/masterLost"><div class="lostAndFound">분실물 문의</div></a>
      </div>


	<div class="boardList">
	<table>
		<tr>
			<th>번호</th>
			<th>유저Id</th>
			<th>문의 종류</th>
			<th>문의 제목</th>
			<th>문의 날자</th>
		</tr>
		<c:forEach var="dto" items="${oneToOneList }">
			<tr>
				<td>${dto.oneToOne_idx }</td>
				<td>${dto.userId }</td>
				<td>${dto.otoKind }</td>
				<td class="content"><a href="${cpath}/master/masterServiceCenter/masterOneToOne2/${dto.oneToOne_idx}">${dto.otoTitle }</a></td>
				<td>${dto.otoWriteDay }</td>
			</tr>
		</c:forEach>
		</table>
		<div class="paging">
			<div id="number">
				<c:if test="${paging.prev }">
					<a href="${cpath }/master/masterServiceCenter/masterOneToOne">
						[처음] </a>
				</c:if>

				<c:if test="${paging.prev }">
					<a
						href="${cpath }/master/masterServiceCenter/masterOneToOne?page=${paging.begin-1}">[이전]
					</a>
				</c:if>

				<c:if test="${empty param.page}">
					<a href="${cpath }/master/masterServiceCenter/masterOneToOne"><strong>1</strong></a>
				</c:if>

				<c:forEach var="i"
					begin="${empty param.page ? paging.begin + 1 : paging.begin}"
					end="${paging.end }">
					<span> ${i == param.page ? '<strong>' : '' } <c:if
							test="${i ==1 }">
							<a href="${cpath }/master/masterServiceCenter/masterOneToOne">${i }</a>
						</c:if> <c:if test="${i != 1}">
							<a
								href="${cpath }/master/masterServiceCenter/masterOneToOne?page=${i}">${i }</a>
						</c:if> ${i == param.page ? '</strong>' : '' }
					</span>
				</c:forEach>

				<c:if test="${paging.next }">
					<a
						href="${cpath }/master/masterServiceCenter/masterOneToOne?page=${paging.end+1}">[다음]
					</a>
				</c:if>

				<c:if test="${paging.next }">
					<a
						href="${cpath }/master/masterServiceCenter/masterOneToOne?page=${paging.pageCount}">[맨끝]
					</a>
				</c:if>

			</div>
		</div>


	</div>
</div>

</body>
</html>