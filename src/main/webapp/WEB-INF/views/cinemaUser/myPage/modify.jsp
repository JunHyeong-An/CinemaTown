<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/myPage/modify.css">
<div class="mainBody">
        <main class="modifyMain">
            <div class="modifyTitle">
            정보수정
            </div>
            
            <form>
                <div class="Form">
                    <div class="modifyName">ID</div>
                    <input type="text" name="userId" class="modifyInput" value="danbi1029" readonly>
                </div>
                <div class="Form">
                    <div class="modifyName">NAME</div>
                    <input type="text" name="userName" class="modifyInput" value="나단비" readonly>
                </div>
                <div class="Form">
                    <div class="modifyBirthName">생년월일</div>
                    <div><input type="text" class="modifyBirth" value="2017 / 10 / 04" readonly></div>
                </div>
                <div class="Form">
                    <div class="modifyName">EMAIL</div>
                    <input type="text" name="userEmail1" class="modifyEmail" value="danbi1029" readonly>
                    @<input type="text" name="userEmail2" class="modifyEmail" value="google.com" readonly>
                </div>
                <!--여기까지 readOnly붙여서 읽기만 가능합니다-->
                <div class="pwButton">
                    <input type="button" id="pwModifyButton" value="비밀번호변경">
                </div>
                <!--버튼 누르면 비밀번호 변경사이트로-->
                <div class="phoneForm">
                    <div class="modifyName">PHONE</div>
                    <input type="hidden" name="userPh" id="userPhHidden">
                    <select class="modifyPhoneOne" name="userPh1"> 
                        <option value="010">010</option>
                        <option>011</option>
                        <option>012</option>
                        <option>017</option>
                        <option>070</option>
                    </select> -
                    <input type="text" name="userPh2" class="modifyPhone"> -
                    <input type="text" name="userPh3" class="modifyPhone">
                </div>
                <!--여기부터는 API-->
                <div class="Form">
                    <div class="modifyName">ADDRESS</div>
                    <input type="text" placeholder="우편번호" class="modifyAddress" id="sample6_postcode">
                <input type="submit" value="우편번호 찾기" id="submitAddress" onclick="sample6_execDaumPostcode()">
            </div>
            <div class="Form">
                <div class="modifyName"></div>
                <input type="text" placeholder="주소" class="modifyAddressInput" id="sample6_address">
            </div>
            <div class="Form">
                <div class="modifyName"></div>
                <input type="text"  placeholder="상세주소 입력" id="sample6_detailAddress" class="modifyAddressInput">
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