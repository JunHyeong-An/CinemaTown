// 변수 선언부

// userId Input
const userId = document.querySelector('input[name="userId"]')
// 비밀번호 확인 input
var pwCheck = document.getElementById('passwordCheck')
// 회원 가입 버튼
const submitBtn = document.querySelector("#submitJoin")
// input type이 text인 것들을 모두 가져와서 nodelist에서 array로 변환함.
const checkJoinText = Array.from(document.querySelectorAll("input[type='text'"))
// home header에 있는 li들을 모두 가져와서 nodelist에서 array로 변환함
const liBoxes = document.querySelectorAll("#headerList li")
//회원가입 정규식 변수
var idPattern = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
var pwPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/;
var phonePattern = /^[0-9]{4}$/;
var birthPattern = /^[0-9]{6}$/;
var genderPattern = /^[1-4]{1}$/;


//-------------------------------함수 선언부---------------------------------
//폰넘버 합치기
makePhnumber = function() {
   const userPh1 = document.querySelector('select[name="userPh1"]')
   const userPh2 = document.querySelector('input[name="userPh2"]')
   const userPh3 = document.querySelector('input[name="userPh3"]')
   const userPhHidden = document.getElementById('userPhHidden')
   const userPh = userPh1.value +'-'+ userPh2.value +'-' + userPh3.value
   userPhHidden.value = userPh
}
//이메일 합치기
makeEmailAddr = function() {
   const userEmail1 = document.querySelector('input[name="userEmail1"]')
   const userEmail2 = document.querySelector('select[name="userEmail2"]')
   const emailHidden = document.getElementById('emailHidden')
   const userEmail = userEmail1.value + '@' + userEmail2.value
   emailHidden.value = userEmail
  
}
//생일 합치기
makeBirthAddr = function() {
      const userSn1 = document.querySelector('input[name="userSn1"]')
      const userSn2 = document.querySelector('input[name="userSn2"]')
      const userBirthHidden = document.getElementById('userBirthHidden')
      const userBirth = userSn1.value + '-' + userSn2.value
      userBirthHidden.value = userBirth
   
}
//주소 합치기
makeAddressAdd = function() {
   const postcode = document.querySelector('input[name="postcode"]')
   const userAddr1 = document.querySelector('input[name="userAddr1"]')
   const userAddr2 = document.querySelector('input[name="userAddr2"]')
   const userAddrHidden = document.getElementById('userAddrHidden')
   const userAddr = postcode.value+'/'+ userAddr1.value + ',' + userAddr2.value
   userAddrHidden.value = userAddr
   
}
//비밀번호 일치확인
function checkPw() {
   var pw = document.getElementById('password')
   const pwMsg = document.querySelector('.passwordMsg')
   if(pw.value != ''){
	   if(pwPattern.test(pw.value)){
		   if(pw.value == pwCheck.value){
			   pwMsg.innerText = '비밀번호가 일치합니다.'
				   pwMsg.style.color = 'green'
		   }
		   else {
			   pwMsg.innerText = '비밀번호가 일치하지 않습니다'
				   pwMsg.style.color = 'red'
		   }
	   }else {
		   alert('비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리를 사용해야합니다.')
		   pw.value = ''
			   pwCheck.value = ''
				   pw.focus();
	   }	   
   }else {
	   joinMsg.innerHTML = "필수값을 입력해주세요"
   }
   
}

// 필수 값 체크
function checkRequiredValue(ar) {
   const joinMsg = document.querySelector("#joinMsg")

   if(ar.value == '') joinMsg.innerHTML = "필수값을 입력해주세요"
   else joinMsg.innerHTML = ''
}

// 회원가입 버튼을 눌렀을때 필수값이 모두 들어가있는지 확인
function checkRequiredValueSubmit(ar, event) {
   if(ar.value == ''){
      joinMsg.innerHTML = "필수값을 입력해주세요"
      event.preventDefault()
   }
}

//아이디중복
function checkIdOverlap() {
   const userIdValue = document.getElementById('useridValue')
      const checkIdMsg = document.querySelector("#checkIdMsg")
    
      const url = 'idCheck/'+userId.value+'/'
      const opt = {
            method: 'GET'
      }
      fetch(url, opt)
      .then(function(resp) {return resp.text()})
      .then(function(text) {
    	 if(userId.value != ''){
    		 if(idPattern.test(userId.value)) {
    			 if(text=='1'){
    				 checkIdMsg.innerText = '아이디중복입니다.'
    					 checkIdMsg.style.color = 'red'
    			 }
    			 else {
    				 checkIdMsg.innerText = '사용가능한아이디입니다.'
    					 checkIdMsg.style.color = 'green'
    			 }    		 
    		 }
    		 if(!idPattern.test(userId.value)){
    			 alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
    			 checkIdMsg.innerHTML = ''
    				 userId.value = ''
    				 userId.focus();
    		 }    		 
    	 }else {
    		 joinMsg.innerHTML = "필수값을 입력해주세요"
    	 }
      })
}

//주소 api
function sample6_execDaumPostcode() {
   new daum.Postcode({
      oncomplete: function (data) {
         // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

         // 각 주소의 노출 규칙에 따라 주소를 조합한다.
         // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
         var addr = ''; // 주소 변수
         var extraAddr = ''; // 참고항목 변수

         //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
         if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
         } else { // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
         }

         // 우편번호와 주소 정보를 해당 필드에 넣는다.
         document.getElementById('sample6_postcode').value = data.zonecode;
         document.getElementById("sample6_address").value = addr;
         // 커서를 상세주소 필드로 이동한다.
         document.getElementById("sample6_detailAddress").focus();
      }
   }).open();
}

//-------------------------------이벤트 선언부---------------------------------

// 비밀번호 확인 이벤트
pwCheck.onblur = function() {
   checkPw()
}

// 모든 필수값 input에 관한 필수값 체크
checkJoinText.forEach(ar => {
   ar.onblur = function() {
      checkRequiredValue(ar)
   }
})

// 회원가입 버튼 이벤트
submitBtn.onclick = function(event) {
   makeEmailAddr()
   makePhnumber()
   makeBirthAddr()
   makeAddressAdd()
   // 회원가입 버튼을 눌렀을때 필수값 체크
   checkJoinText.forEach(ar => {
      checkRequiredValueSubmit(ar, event)
   })
   if(authMailMsg.innerText == '인증 실패!!'){
	   event.preventDefault()
	   alert('이메일 인증을 실패하셨습니다.')
	   userNumber.focus()
   }
   
}

// 아이디 중복검사
userId.onblur = function(event){
   checkIdOverlap()
}
//메일 주소를 입력하고 폼을 서브밋하면 작동할 이벤트 + 정규식
const confirmEmail = document.getElementById('confirmEmail')
const sendMailMsg = document.getElementById('sendMailMsg')
const submitEmail = document.getElementById('submitEmail')
const authMailMsg = document.getElementById('authMailMsg')
const emailCheckForm = document.querySelector('.emailCheckForm')
const userNumber = document.querySelector('input[name="auth"]')
const sendMailHandler = function(event){
   makeEmailAddr()
   const userEmail = document.querySelector('input[name="userEmail"]')
   
   const url = 'mailto/' + userEmail.value +'/'
   const opt = {
      method : 'GET'
   }
   fetch(url,opt).then(resp => resp.text())
   .then(text => {
      console.log(text)
      console.log(userEmail.value)
      if(userEmail.value != ''){
    	  if(emailPattern.test(userEmail.value)){
    		  if(text.length == 128){      // hash값을 받았다면 길이는 128이다
    			  sendMailMsg.innerText = '입력한 이메일로 인증번호를 전송했습니다'
    			  sendMailMsg.style.color = 'blue'
    			  sendMailMsg.style.fontWeight = 'bold'
    		  }
    		  else{                  // error msg를 받았다면 128이 아니다
    			  sendMailMsg.innerText = text
    			  sendMailMsg.style.color = 'red'
    			  sendMailMsg.style.fontWeight = 'bold'
    		  }    	      		  
    		  emailCheckForm.style.display = 'flex'
    	  }else {
    		  alert('이메일 형식이 아닙니다. 이메일 형식으로 입력해주세요!')
    	  }
      }
      else{
    	  joinMsg.innerHTML = "필수값을 입력해주세요"
      }
   })
}
confirmEmail.onclick = sendMailHandler

// 인증번호를 입력해서 결과를 확인하는 이벤트 함수
const authHandler = function(event){

   const userNumber = document.querySelector('input[name="auth"]')
   const url = 'getAuthResult/' + userNumber.value
   const opt = {
         method: 'GET'
   }
   fetch(url,opt).then(resp => resp.text())
   .then(text => {
      console.log(text)
      if(text == 'true'){
         authMailMsg.innerText = '인증 성공!!'
         authMailMsg.style.color ='green'
      }
      else{
         authMailMsg.innerText = '인증 실패!!'
         authMailMsg.style.color ='red'
      }
   })
}
submitEmail.onclick = authHandler

//휴대폰번호 정규식 숫자 0~9중에 4자리만 입력가능
const userPh2 = document.querySelector('input[name="userPh2"]')
userPh2.onblur = function(event) {
	if(userPh2.value != ''){
		if(!phonePattern.test(userPh2.value)) {
			alert('숫자 0~9중에 4자리만 입력하실수있습니다.')
			userPh2.value = ''
			userPh2.focus();
		}		
	}else {
		joinMsg.innerHTML = "필수값을 입력해주세요"
	}
	
}
const userPh3 = document.querySelector('input[name="userPh3"]')
userPh3.onblur = function(event) {
	if(userPh3.value != ''){
		if(!phonePattern.test(userPh3.value)) {
			alert('숫자 0~9중에 4자리만 입력하실수있습니다.')
			userPh3.value = ''
			userPh3.focus();
		}		
	}
	else {
		joinMsg.innerHTML = "필수값을 입력해주세요"
	}
}
//생일 정규식 숫자 6자리만 입력가능
const joinBirth = document.querySelector('.joinBirth')
joinBirth.onblur = function(event) {
	if(joinBirth.value != ''){
		if(!birthPattern.test(joinBirth.value)) {
			alert('숫자 0~9중에 6자리만 입력하실수있습니다.')
			joinBirth.value = ''
			joinBirth.focus();
		}		
	}else {
		joinMsg.innerHTML = "필수값을 입력해주세요"
	}
}
//성별 정규식 숫자 0~4중에 1자리만 입력가능
const joinGender = document.querySelector('.joinGender')
joinGender.onblur = function(event) {
	if(joinGender.value != ''){
		if(!genderPattern.test(joinGender.value)) {
			alert('숫자 1~4중에 1자리만 입력하실수있습니다.')
			joinGender.value = ''
			joinGender.focus();
		}		
	}else {
		joinMsg.innerHTML = "필수값을 입력해주세요"
	}
}










