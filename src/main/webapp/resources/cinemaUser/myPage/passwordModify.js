/**
 * 
 */
//비밀번호 일치확인
var newPw = document.getElementById('newPw')
var newPwCheck = document.getElementById('newPwCheck')
const newPwMsg = document.querySelector('.newPwMsg')
var newPwPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;

newPwCheck.onblur = () => {
	if(newPw.value != ''){
		if(newPwPattern.test(newPw.value)){
			if(newPw.value == newPwCheck.value){
				newPwMsg.innerText = '비밀번호가 일치합니다.'
					newPwMsg.style.color = 'green'
			}
			else {
				newPwMsg.innerText = '비밀번호가 일치하지 않습니다'
					newPwMsg.style.color = 'red'
			}			
		}else {
			alert('비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리를 사용해야합니다.')
			newPw.value = ''
			newPwCheck.value = ''
			newPw.focus();
		}
	}else{
		if(newPw.value == '') {
			passwordModifyMsg.innerText = '필수값을 입력해주세요'
		}
		else {
			passwordModifyMsg.innerText = ''
		}		
		
	}
}