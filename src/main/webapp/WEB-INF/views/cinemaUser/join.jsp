<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/join.css">
<div class="mainBody">
        <main class="joinMain">
            <div class="joinTitle">
                회원 가입
            </div>
            <form id="mainForm" method="POST">
                <div class="Form">
                    <div class="joinName">ID</div>
                    <input type="text" class="joinInput" name="userId" id="userIdValue">
                </div>
                <div id="checkIdMsg"></div>
                <div class="Form">
                <div class="joinName">비밀번호</div>
                <!--회원가입할때 type이 password인거 같아서 password로 했습니다-->
                <input type="password" class="joinInput" name="userPw" id="password">
                </div>
                <div class="Form">
                    <div class="joinName">비밀번호 확인</div>
                    <input type="password" class="joinInput" id="passwordCheck">
                </div>
                <div class="passwordMsg"></div>
                <div class="Form">
                    <div class="joinName">NAME</div>
                    <input type="text" class="joinInput" name="userName">
                </div>
                <div class="Form">
                    <div class="joinBirthName">주민등록번호</div>
                    <!--joinBirth 부분에 생년월일 적고 joinGender부분에 1234중 한글자로 성별판단합니다-->
                    <!--name은 백엔드 부분이랑 상의하고 하기로했습니다-->
                    <input type="hidden" name="userBirth" id="userBirthHidden">
                    <div><input type="text" class="joinBirth" name="userSn1"></div> -
                    <div><input type="text" class="joinGender" name="userSn2"></div>
                    <div class="blind">* * * * * *</div>
                </div>
                <div class="phoneForm">
                    <div class="joinName">PHONE</div>
                    <!--value="010"으로 했는데 올리면 앞에 0빼고 11부터 시작되네요 어떻게 하는지몰라서 나뒀습니다-->
                    <input type="hidden" name="userPh" id="userPhHidden">
                    <select class="joinPhoneOne" name="userPh1"> 
                        <option value="010" selected>010</option>
                        <option value="011">011</option>
                        <option value="012">012</option>
                        <option value="017">017</option>
                        <option value="070">070</option>
                    </select> -
                    <input type="text" class="joinPhone" name="userPh2"> -
                    <input type="text" class="joinPhone" name="userPh3">
                </div>
                <div class="Form">
                    <div class="joinName">EMAIL</div>
                    <input type="hidden" name="userEmail" id="emailHidden">
                     <input type="text" class="joinEmail" name="userEmail1">@
                    <!--이메일 부분은 잘몰라서 일단 select로 해놨습니다-->
                    <select class="joinEmail" name="userEmail2">
                        <option>google.com</option>
                        <option>naver.com</option>
                        <option>daum.net</option>
                        <option>yahoo.co.kr</option>
                    </select>
      				<input type="button" value="인증받기" id="confirmEmail">
                </div>
                <div id="sendMailMsg"></div>
                <div class="emailCheckForm">
                    <div class="joinName">EMAIL 인증</div>
                    <!--이메일 인증은 api로 백엔드쪽이랑 상의해봐야될거같아요-->
                    <input type="text" placeholder="인증번호입력" name="auth" class="joinEmailCheck">
                    <input type="button" value="인증하기" id="submitEmail">
                </div>
                <div id="authMailMsg"></div>
                <!--주소도 api로 해야해서 일단 html만 만들었습니다-->
                <div class="Form">
                    <div class="joinName">ADDRESS</div>
                	<input type="hidden" name="userAddr" id="userAddrHidden">
                    <input type="text" name="postcode" placeholder="우편번호" class="joinAddress" id="sample6_postcode">
                    <input type="button"value="우편번호 찾기" id="submitAddress" onclick="sample6_execDaumPostcode()">
                </div>
                <div class="Form">
                    <div class="joinName"></div>
                    <input type="text" name="userAddr1" placeholder="주소" class="joinInput" id="sample6_address">
                </div>
                <div class="Form">
                    <div class="joinName"></div>
                    <input type="text" name="userAddr2"  placeholder="상세주소 입력" class="joinInput" id="sample6_detailAddress">
                  
                </div>
                <div class="Form">
                    <input type="submit" value="회원가입" id="submitJoin">
                </div>
                <div id="joinMsg"></div>
            </form>
        </main>
    </div>  
<%@ include file="../footer.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${cpath }/resources/cinemaUser/join.js"></script>