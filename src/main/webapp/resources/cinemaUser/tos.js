// 동의 모두선택 / 해제
const agreeChkAll = document.querySelector('input[name=agree_all]');
agreeChkAll.addEventListener('change', (e) => {
	let agreeChk = document.querySelectorAll('input[name=agree]');
	for (let i = 0; i < agreeChk.length; i++) {
		agreeChk[i].checked = e.target.checked;
	}
});
// 필수항목들이 체크다 되어있는 경우만 회원가입 창으로가라
let agreeChk = document.querySelectorAll('input[name=agree]');
const agreeBtn = document.querySelector('input[type=button]');
agreeBtn.onclick = function(event) {
    if(agreeChk[0].checked == false || agreeChk[1].checked == false || agreeChk[2] == false){
         event.preventDefault()
    }
}