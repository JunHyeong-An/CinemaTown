const userPw = document.querySelector("#userPw")
const pwBtn = document.querySelector("#submitBtn")
const pwNotice = document.querySelector("#pwNotice")

pwBtn.onclick = function(event) {
	if(userPw.value == '') {
		event.preventDefault()
		pwNotice.innerHTML = "비밀번호를 입력해주세요"
	}
}

submitBtn.onclick = function(event) {
	if(!confirm("탈퇴하시겠습니까?")) {
		event.preventDefault()
	}
}