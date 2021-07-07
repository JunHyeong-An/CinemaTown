<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/cinemaUser/login.css">
   <div class="colorBox">
        <main id="loginMain">
            <div class="loginTitle">
        <c:if test="${not empty login}">로그아웃</c:if>
        <c:if test="${empty login }">로그인</c:if>
            </div>
            <form method="POST" class="loginForm">

                <input type="submit" value="LOGIN" id="loginBtn">

                <div class="idInputBox" id="IdInputBox">
                    <input type="text" name="userId" class="loginInput" placeholder="ID">
                </div>
                <div class="passwordInputBox" id="PasswordInputBox">
                    <input type="password" name="userPw" class="loginInput" placeholder="PASSWORD">
                </div>
<!--                 <div class="keepLogin"> -->
<!--                     <input type="checkbox" id="CheckLogin" name="keepLogin"><label>　로그인 상태 유지</label> -->
<!--                 </div> -->

                <ul id="miniMenu">
                    <li><div class="miniMunuText">ID 찾기</div></li>
                    <li><div class="miniMunuText">PW 찾기</div></li>
                    <li><div class="miniMunuText">회원가입</div></li>
                </ul>
            </form>
        </main>
    </div>
<%@ include file="../footer.jsp"%>
<script src="${cpath }/resources/cinemaUser/login.js"></script>