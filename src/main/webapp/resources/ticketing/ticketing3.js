const paymentMethods = Array.from(document.querySelectorAll(".paymentMethod"))
const methodBox = document.querySelectorAll(".methodBox")
const cards = document.querySelectorAll(".card")
const table = document.querySelector("#paymentPersonalInfoTable")
const kakaoPayBtn = document.querySelector("#kakaoPayBtn")

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
        kakaoPayBtn.classList.remove("hidden")
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
	ob.scheduleIdx = scheduleIdx
	ob.reservationSeat = reservationSeat
	ob.urlName = urlName
	ob.ageLimit = ageNum
	ob.cardCompany = cardCompany
	ob.cardPassword = cardPassword
	
	console.log('snum')
	console.log(scheduleIdx)
	
	console.log('selectSeats')
	console.log(selectSeats)

	let ticketingJson = JSON.stringify(ob)

	const url = cpath + '/cinemaMovie/ticketing/'
	const opt = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json',
		},
		body: ticketingJson
	}
	
	console.log(ob)
	fetch(url, opt)
	.then(function(resp)  {return resp.text()})
	.then(function(text)  {
		if(text == 1) {
			location.href = cpath + "/cinemaMovie/ticketingSuccess/"
		}
	})
}

kakaoPayBtn.onclick = function() {
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
	ob.scheduleIdx = scheduleIdx
	ob.reservationSeat = reservationSeat
	ob.urlName = urlName
	ob.ageLimit = ageNum
	ob.cardCompany = cardCompany
	ob.cardPassword = cardPassword
	
	let ticketingJson = JSON.stringify(ob)

	const url = cpath + "/cinemaMovie/kakaoPay/"
	const opt = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json',
		},
		body: ticketingJson
	}
	fetch(url, opt)
	.then(function(resp)  {return resp.text()})
	.then(function(text)  {
		location.href = text
		
	})
}