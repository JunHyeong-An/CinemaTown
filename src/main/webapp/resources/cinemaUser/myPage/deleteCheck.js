const userPw = document.querySelector("#userPw")
const pwBtn = document.querySelector("#submitBtn")
const pwNotice = docuemnt.querySelector("#pwNotice")

pwBtn.onclick = function(event) {
	if(userPw.value == '') {
		event.defaultPrevented()
		pwNotice.innerHTML = "비밀번호를 입력해주세요"
	}
}