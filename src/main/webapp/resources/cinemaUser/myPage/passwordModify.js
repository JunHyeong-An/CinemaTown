/**
 * 
 */
//비밀번호 일치확인
var newPw = document.getElementById('newPw')
var newPwCheck = document.getElementById('newPwCheck')
const newPwMsg = document.querySelector('.newPwMsg')

newPwCheck.onblur = () => {
   if(newPw.value == newPwCheck.value){
      newPwMsg.innerText = '비밀번호가 일치합니다.'
         newPwMsg.style.color = 'green'
   }
   else {
      newPwMsg.innerText = '비밀번호가 일치하지 않습니다'
         newPwMsg.style.color = 'red'
   }
   if(newPw.value == '') {
      passwordModifyMsg.innerText = '필수값을 입력해주세요'
   }
   else {
      passwordModifyMsg.innerText = ''
   }
}