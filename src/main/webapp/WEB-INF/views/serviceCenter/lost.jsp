<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="${cpath }/resources/serviceCenter/oneToOne.css">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <style>
        /* logo font */
        @import url('https://fonts.googleapis.com/css2?family=Zen+Tokyo+Zoo&display=swap');
        @font-face {
            font-family: 'gmarket';
            src: url('font/GmarketSansTTFMedium.ttf') format('truetype');
        }
        @font-face {
            font-family: 'gmarketLight';
            src: url('font/GmarketSansTTFLight.ttf') format('truetype');
        }

        /* 각 태그들의 크기를 직접 보시려면 border 주석을 제거하면 됩니다. */

        body {
            font-family: 'gmarket';
            font-size: 10pt;
        }

        #headerBanner {
            display: flex;
            position: relative;
            justify-content: center;
            align-items: center;
            border: 0px solid black;
            background-color: black;
        }

        #bannerCloseBtn {
            color: white;
            position: absolute;
            right: 25px;
            font-size: 15pt;
            cursor: pointer;
        }

        header {
            border: 0px solid white;
            margin-bottom: 50px;
            background-color: white;
        }

        #loginStatusBox {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            padding-right: 20px;
            /* border: 1px solid black; */
        }
        #logo {
            width: 500px;
            margin: 0 auto;
            margin-top: 50px;
            text-align: center;
            font-family: 'Zen Tokyo Zoo', cursive;
            font-size: 40pt;
            user-select: none;
            cursor: pointer;
            color: black;
            /* border: 1px solid black; */
        }

        #headerListBox {
            color: black;
            position: relative;
            margin-top: 50px;
            /* border: 1px solid red; */
        }

        #headerList {
            display: flex;
            justify-content: center;
            list-style: none;
            /* border: 1px solid blue; */
            margin-bottom: 0px;
        }

        #headerList li {
            position: relative;
            /* display: flex; */
            /* justify-content: center; */
            /* align-items: center; */
            width: 150px;
            height: 25px;
            /* border: 1px solid red; */
        }

        .menuText {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100px;
            height: 30px;
            margin: 0 auto;
            /* border: 1px solid black; */
        }

        .menuText p {
            position: absolute;
        }

        #headerList li:not(:last-child) {
            border-right: 1px solid black;
        }
        /* 드롭 다운 메뉴 css */
        .dropDownMenu {
            display: flex;
            justify-content: center;
            padding-top: 10px;
            /* border: 1px solid black; */
        }

        #serviceCenterDropDown {
            width: 270px;
        }

        .serviceCenterDropDownElement {
            padding: 0 10px;
        }

        .hidden {
            display: none;
        }
/*-------------------------------------------------------------------------------------------*/

        #boardContainer {
            width: 100%;
            height: 690px;
        /*  border: 1px solid black;   */
            text-align: center;
            margin-top: 100px;
        }
        #boardMenu {
            width: 300px;
            height: 30px;
            border-bottom: 1px solid gray;
            display: flex;
            margin: 0 auto;
            justify-content: center;
            align-items: center;
        }


/*-------------------------------------------------------------------------------------------*/
        footer {
            font-family: 'gmarketLight';
            font-size: 10pt;
            margin-top: 50px;
            color: gray;
        }

        #footerAdBanner {
            /* border: 1px solid black; */
            height: 100px;
            margin-bottom: 170px;
            /* background-color: yellow; */
        }

        #footerAdBanner img { max-width: 100%; }

        #moreInfo {
            display: flex;
            list-style: none;
            margin-top: 200px;
            margin-bottom: 40px;
            padding-left: 0;
            /* border: 1px solid black; */
        }

        #moreInfo > li {
            padding: 0 10px;
            border-right: 1px solid gray;
            /* border: 1px solid black; */
        }
        #moreInfo > li:first-child {
            border-left: 1px solid gray;
        }

/*-------------------------------------------------------------------------------------*/

        .writeForm {
      /*    border: 1px solid black;     */
            width: 100%;
            height: 1000px;
            margin-top: 50px;
        }
        .writeTitle {
      /*    border: 1px solid red;    */
            width: auto;
            height: 40px;
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .writeContent {
        /*  border: 1px solid green;     */
            width: auto;
            height: 450px;
            margin-top: 30px;
        }
        .miniContainer {
        /*    border: 1px solid purple; */
            width: 100%;
            height: 200px;
            margin-top: 10px;
        }
        .miniMenu {
            font-family: 'gmarketLight';
            font-weight: 700;
            font-size: 7pt;
            float : top;
            text-align: center;
        }
        .miniMenu > input {
            border: 0px;
            border-bottom: 1px solid rgb(197, 197, 197);
            outline: none;
            margin-bottom: 12px;
            width: 300px;
        }
        .writeContent > textarea {
            width: 785px;
            height: 400px;
            resize: none;
            outline: none;
            border: 1px solid rgb(197, 197, 197);
            border-radius: 5px;
            padding: 20px 20px 20px 17px;
            margin-top: 10px;
        }
        .writeButton {
            width: 300px;
            height: 30px;
            border: 1px solid black;
            border-radius: 5px;
            background-color: black;
            margin: 0 auto;
            margin-top: 30px;
            text-align: center;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        

    </style>
</head>



<body>

<form method="POST">
    <div id="boardContainer">
        <div id="boardMenu">
            <div class="lostAndFound">분실물 신고</div>
        </div>
            <div class="writeForm">
                <div class="miniContainer">
                    <div class="miniMenu">-분실날짜-<br>
                        <input type="date" name="cinemaLostDateTime"></div>
                    <div class="miniMenu">
                        <input type="text" name="cinemaLostKind" placeholder="분실물의 종류를 입력하세요">
                    </div>
                    <div class="miniMenu">
                        <input type="text" name="cinemaLostHall" placeholder="분실 장소를 입력하세요 (예: 5관)">
                    </div>
                    <div class="miniMenu">
                        <input type="text" name="cinemaLostName" placeholder="이름">
                    </div>
                    <div class="miniMenu">-생년월일-<br>
                        <input type="date" name="cinemaLostBirth">
                    </div>
                    <div class="miniMenu">
                        <input type="text" name="cinemaLostPH" placeholder="휴대폰 번호를 입력하세요">
                    </div>
                </div>
                <div class="writeContent">
                    <textarea name="cinemaLostContent" placeholder="상세내용을 입력하세요"></textarea>
                </div>
                <div class="writeButton">
                    <input type="submit" 
                    style="outline: none; background-color: black; border:none; color:white; cursor: pointer; font-family: gmarketLight; font-weight: 800;"
                    value="등록하기">
                 </div>
            </div>

        </div>
</form>


    <footer>

        <ul id="moreInfo">
            <li>회원약관</li>
            <li>개인정보처리방침</li>
            <li>이메일무단수집거부</li>
            <li>영상정보처리기기 운영 및 관리방침</li>
            <li>회원 안내</li>
            <li>배정 기준</li>
            <li>채용 안내</li>
            <li>광고/임대문의</li>
            <li>윤리경영</li>
            <li>기업정보</li>
        </ul>

        <div id="addressAndEmail">
            <p>서울특별시 송파구 올림픽로 1005 아이티뱅크월드타워 270층 고객센터 1544-7755</p>
            <p>대표이사 김진현 사업자등록번호 313-87-11979 통신판매신고번호 제 5045호 개인정보 보호 최고 책임자 허용승</p>
            <p>COPYRIGHT <small>&copy;</small> CINEMA TOWN ALL RIGHT RESERVED.</p>
        </div>
    </footer>

    <script>
        // header.js 랑 다를거 없음
        // 메뉴 밑줄 표시 및 드롭다운
        const li = document.querySelectorAll("#headerList li")
        const dropDowns = document.querySelectorAll(".dropDownMenu")
        li.forEach((l, i) => {
            l.onmouseover = function() {
                l.querySelector(".menuText").style.borderBottom = '2px solid white'
                dropDowns[i].style.display = 'flex'
            }
            dropDowns[i].onmouseover = function() {
                l.querySelector(".menuText").style.borderBottom = '2px solid white'
                dropDowns[i].style.display = 'flex'
            }
            l.onmouseleave = function() {
                l.querySelector(".menuText").style.borderBottom = 'none'
                dropDowns[i].style.display = 'none'
            }
            dropDowns[i].onmouseleave = function() {
                l.querySelector(".menuText").style.borderBottom = 'none'
                dropDowns[i].style.display = 'none'
            }
        })
        ////////////////////////////////////////////////////////////////////
    </script>

    <script>
        const bannerCloseBtn = document.querySelector("#bannerCloseBtn")
        const headerBanner = document.querySelector("#headerBanner")

        bannerCloseBtn.onclick = function() {
            headerBanner.style.display = "none"
        }
    </script>
</body>
</html>