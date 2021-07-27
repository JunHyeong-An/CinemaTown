<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../masterHeader.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/master/masterServiceCenter/masterNoticeList.css">
 	
<div id="boardContainer">
      <div id="boardMenu">
         <a href="${cpath }/master/masterServiceCenter/masterNoticeList"><div class="notice">공지사항</div></a> 
         <a href="${cpath }/master/masterServiceCenter/masterOneToOne"><div class="inquiry">1:1문의</div></a> 
         <a href="${cpath }/master/masterServiceCenter/masterLost"><div class="lostAndFound">분실물 문의</div></a>
      </div>
      
      
      <div class="boardList">
         <c:forEach var="dto" items="${list }">
            <table>
               <tr>
                  <td><a href="${cpath }/master/masterServiceCenter/masterNoticeRead/${dto.notice_idx}">${dto.noticeTitle }</a></td>
                  <td>${dto.noticeDate }</td>
               </tr>
            </table>
         </c:forEach>

         <div class="paging">
            <div id="number">
               <c:if test="${paging.prev }">
                  <a href="${cpath }/master/masterServiceCenter/masterNoticeList"> [처음] </a>
               </c:if>
               
               <c:if test="${paging.prev }">
                  <a href="${cpath }/master/masterServiceCenter/masterNoticeList?page=${paging.begin-1}">[이전] </a>
               </c:if>

               <c:if test="${empty param.page}">
                  <a href="${cpath }/master/masterServiceCenter/masterNoticeList"><strong>1</strong></a>
               </c:if>
               
               <c:forEach var="i"
                  begin="${empty param.page ? paging.begin + 1 : paging.begin}"
                  end="${paging.end }">
                  <span> ${i == param.page ? '<strong>' : '' } 
                     <c:if test="${i ==1 }">
                        <a href="${cpath }/master/masterServiceCenter/masterNoticeList">${i }</a>
                     </c:if> 
                     <c:if test="${i != 1}">
                        <a href="${cpath }/master/masterServiceCenter/masterNoticeList?page=${i}">${i }</a>
                     </c:if> ${i == param.page ? '</strong>' : '' }
                  </span>
               </c:forEach>

               <c:if test="${paging.next }">
                  <a href="${cpath }/master/masterServiceCenter/masterNoticeList?page=${paging.end+1}">[다음] </a>
               </c:if>
               
               <c:if test="${paging.next }">
                  <a href="${cpath }/master/masterServiceCenter/masterNoticeList?page=${paging.pageCount}">[맨끝] </a>
               </c:if>
            
            </div>
         <a href="${cpath }/master/masterServiceCenter/masterNoticeAdd"><button>공지사항 추가</button></a>
         </div>
         
         
      </div>
   </div>

</body>
</html>