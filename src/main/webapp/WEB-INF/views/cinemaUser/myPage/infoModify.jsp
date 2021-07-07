<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/modify.css">
<div class="mainBody">
        <main class="modifyMain">
            <div class="modifyTitle">
            정보수정
            </div>
            
            <form method="POST">
            	<input type="hidden" name="userPw" value="${info.userPw }">
                <div class="Form">
                    <div class="modifyName">ID</div>
                    <input type="text" name="userId" class="modifyInput" value="${info.userId }" readonly>
                </div>
                <div class="Form">
                    <div class="modifyName">NAME</div>
                    <input type="text" name="userName" class="modifyInput" value="${info.userName }" readonly>
                </div>
                <div class="Form">
                    <div class="modifyBirthName">생년월일</div>
                    
                    <div><input type="text" class="modifyBirth" value="${userBirth }" readonly></div>
                </div>
                <div class="Form">
                    <div class="modifyName">EMAIL</div>
                    <input type="text" name="userEmail1" class="modifyEmail" value="${userEmail1 }" readonly>
                    @<input type="text" name="userEmail2" class="modifyEmail" value="${userEmail2 }" readonly>
                </div>
                <!--여기까지 readOnly붙여서 읽기만 가능합니다-->
                <div class="pwButton">
                    <a href="${cpath }/cinemaUser/myPage/passwordModify"><input type="button" id="pwModifyButton" value="비밀번호변경"></a>
                	<!-- 임시로 a태그 넣음 ( 경로 확인차)-->
                </div>
                <!--버튼 누르면 비밀번호 변경사이트로-->
                <div class="phoneForm">
                    <div class="modifyName">PHONE</div>
                    <input type="hidden" name="userPh" id="userPhHidden">
                    <select class="modifyPhoneOne" name="userPh1"> 
                        <option value="010" <c:if test="${userPh1=='010' }">selected</c:if>>010</option>
                        <option value="011" <c:if test="${userPh1=='011' }">selected</c:if>>011</option>
                        <option value="012" <c:if test="${userPh1=='012' }">selected</c:if>>012</option>
                        <option value="017" <c:if test="${userPh1=='017' }">selected</c:if>>017</option>
                        <option value="070" <c:if test="${userPh1=='070' }">selected</c:if>>070</option>
                    </select> -
                    <input type="text" name="userPh2" value="${userPh2 }" class="modifyPhone"> -
                    <input type="text" name="userPh3" value="${userPh3 }" class="modifyPhone">
                </div>
                <!--여기부터는 API-->
                <div class="Form">
                    <div class="modifyName">ADDRESS</div>
                    <input type="hidden" name="userAddr" id="userAddrHidden">
                    <input type="text" name="postcode" value="${postcode }" placeholder="우편번호" class="modifyAddress" id="sample6_postcode">
                <input type="button" value="우편번호 찾기" id="submitAddress" onclick="sample6_execDaumPostcode()">
            </div>
            <div class="Form">
                <div class="modifyName"></div>
                <input type="text" name="userAddr1" value="${userAddr1}" placeholder="주소" class="modifyAddressInput" id="sample6_address">
            </div>
            <div class="Form">
                <div class="modifyName"></div>
                <input type="text" name="userAddr2" value="${userAddr2}" placeholder="상세주소 입력" class="modifyAddressInput" id="sample6_detailAddress">
            </div>
            <div class="Form">
                <input type="submit" value="정보수정" id="submitModify">
            </div>
            <div id="modifyMsg"></div>
        </form>
   </main>
</div>
<%@ include file="../../footer.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${cpath }/resources/cinemaUser/myPage/modify.js"></script>