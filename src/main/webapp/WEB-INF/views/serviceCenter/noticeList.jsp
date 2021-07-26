<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link rel="stylesheet" href="${cpath }/resources/serviceCenter/noticeList.css">

<div id="boardContainer">

        <div id="boardList">
        	<c:forEach var="dto" items="${list }">
            <table border="1" align="center">
    
                <tr>
                    <td class="content"><a href="${cpath }/serviceCenter/noticeRead/${dto.notice_idx}">${dto.noticeTitle }</a></td>
                    <td>관리자</td>
                    <td>${dto.noticeDate }</td>
                </tr>
          

            </table> 
            </c:forEach>
            <div class="paging">
                <div id="number">
                    <c:if test="${paging.prev }">
                        <a href="${cpath }/serviceCenter/noticeList"> [처음] </a>
                    </c:if>
                    <c:if test="${paging.prev }">
                        <a href="${cpath }/serviceCenter/noticeList?page=${paging.begin-1}">
                            [이전] </a>
                    </c:if>
            
                    <c:if test="${empty param.page}">
                        <a href="${cpath }/serviceCenter/noticeList"><strong>1</strong></a>
                    </c:if>
                    <c:forEach var="i" begin="${empty param.page ? paging.begin + 1 : paging.begin}" end="${paging.end }">
                        <span> ${i == param.page ? '<strong>' : '' } <c:if test="${i == 1 }">
                                    <a href="${cpath }/serviceCenter/noticeList">${i }</a>
                                </c:if>
                                <c:if test="${i != 1}">
                                    <a href="${cpath }/serviceCenter/noticeList?page=${i}">${i }</a>
                                </c:if> ${i == param.page ? '
                            </strong>' : '' }
                        </span>
            
                    </c:forEach>
            
                    <c:if test="${paging.next }">
                        <a href="${cpath }/serviceCenter/noticeList?page=${paging.end+1}">
                            [다음] </a>
                    </c:if>
                    <c:if test="${paging.next }">
                        <a href="${cpath }/serviceCenter/noticeList?page=${paging.pageCount}">
                            [맨끝] </a>
                    </c:if>
                </div>
            </div>
        </div>

    </div>



<%@ include file="../footer.jsp" %>