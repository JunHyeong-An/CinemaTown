const url = getParameterByName("url")
const movieNm = getParameterByName("movieNm")
const loginBtn = document.querySelector("#loginBtn")
const userId = document.querySelector("#userId")
const userPw = document.querySelector("#userPw")
const loginForm = document.querySelector(".loginForm")

loginBtn.onclick = function(event) {
	if(userId.value == '' || userPw.value == '') event.preventDefault()
}

