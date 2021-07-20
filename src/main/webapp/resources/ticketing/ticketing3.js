const paymentMethods = Array.from(document.querySelectorAll(".paymentMethod"))
const methodBox = document.querySelectorAll(".methodBox")
const cards = document.querySelectorAll(".card")
const table = document.querySelector("#paymentPersonalInfoTable")

paymentMethods.forEach((method, i) => {
    method.addEventListener('click', function() {selectPaymetMethod(method, i)})
})


function selectPaymetMethod(method, i) {
    if(i == 0) {
        methodBox[0].classList.remove("hidden")
        methodBox[1].classList.add("hidden")
    }
    else {
        methodBox[1].classList.remove("hidden")
        methodBox[0].classList.add("hidden")
        table.classList.add("hidden")
        cardBackInit()
    }

    if(method.classList.contains('methodUnSelect')) {
        method.classList.replace('methodUnSelect', 'methodSelect')
        
        if(method.nextElementSibling != null) {
            method.nextElementSibling.classList.replace('methodSelect', 'methodUnSelect')
        }
        else if(method.previousElementSibling != null) {
            method.previousElementSibling.classList.replace('methodSelect', 'methodUnSelect')
        }
    }
}

cards.forEach(card => {
    card.addEventListener("click", function() {showPayment(card)})
})

function showPayment(card) {
	cardCompany = card.innerHTML
    cardBackInit()
    card.style.backgroundColor = "gray"

    let cardName = card.innerHTML
    const tableCardName = document.querySelector("#cardName")

    if(table.classList.contains("hidden")) {
        table.classList.remove("hidden")
    }
    else {
        tableCardName.innerHTML = cardName
    }
    tableCardName.innerHTML = cardName
}

function cardBackInit() {
    cards.forEach(card => {
        card.style.backgroundColor = "white"
    })
}

document.querySelector("#paymentBtn").onclick = function() {

	cardNum = ""
	const cardNums = Array.from(document.querySelectorAll(".cardNum"))
	const cardPw = document.querySelector("#cardPw")
	
	cardNums.forEach(num => {
		cardNum += String(num.value)
	})
	
	if(cardNum.length != 16) {
		document.querySelector("#paymentNotice").innerHTML = "값을 채워주세요"
		return
	}
	else {
		document.querySelector("#paymentNotice").innerHTML = ""
		
		if(cardPw.value.length != 4) {
			document.querySelector("#paymentNotice").innerHTML = "비밀번호를 입력해주세요"
			return
		}
		else {
			cardPassword = cardPw.value
			document.querySelector("#paymentNotice").innerHTML = ""
		}
	}
	// 모든 값 전송
	
	let ob = {}
	ob.movieName = movieName	// 영화이름
	ob.ticketingDate = ticketingDate	// 영화 시작 날짜
	ob.ticketingTime = ticketingTime
	ob.ticktingHallName = ticktingHallName
	ob.selectSeats = selectSeats
	ob.adultCnt = adultCnt
	ob.studentCnt = studentCnt
	ob.totalCost = totalCost
	ob.cardNum = cardNum
	ob.cardCompany = cardCompany
	ob.cardPassword = cardPassword
	ob.scheduleIdx = movieScheduleIdx
	

	let ticketingJson = JSON.stringify(ob)
	console.log(ticketingJson)
	const url = "ticketing/" + ticketingJson + "/"
	const opt = {
		method: "POST"
	}
	
	fetch(url, opt)
	.then(function(resp)  {return resp.text()})
	.then(function(text)  {
		console.log(text)
	})
}