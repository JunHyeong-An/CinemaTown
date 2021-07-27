const historyList = document.querySelector("#historyList")

// 예매내역 불러오기
const historyUrl = cpath + "/cinemaUser/myPage/ticketingHistoryList"
const opt = {method : 'GET'}

fetch(historyUrl, opt)
.then(resp => {
	return resp.json()
})
.then(json => {
	for(i in json) {
//		console.log(json[i].TICKETING_IDX)
		const div1 = document.createElement("div")
		const div2 = document.createElement("div")
		const div3 = document.createElement("div")
		const div4 = document.createElement("div")
		
		const p1 = document.createElement("p")
		const p2 = document.createElement("p")
		const p3 = document.createElement("p")
		const p4 = document.createElement("p")
		const p5 = document.createElement("p")
		
		const input1 = document.createElement("input")
		const input2 = document.createElement("input")
		
		input1.setAttribute("type", "hidden")
		input1.setAttribute("value", json[i].TICKETING_IDX)
		input1.setAttribute("class", "idx")
		input2.setAttribute("type", "button")
		input2.setAttribute("class", "cancleBtn")
		input2.setAttribute("value", "예매취소")
		
		div1.setAttribute("class", "history")
		div2.setAttribute("class", "historyMovieNm")
		div3.setAttribute("class", "historyMore")
		div4.setAttribute("class", "historyCostBox")
		
		p1.setAttribute("class", "historyDate")
		p2.setAttribute("class", "historyTime")
		p3.setAttribute("class", "historyHallNm")
		p4.innerHTML = "결제 금액"
		p5.setAttribute("class", "historyCost")
		
		p1.innerHTML = json[i].START_TIME
		p3.innerHTML = json[i].HALLNAME
		p5.innerHTML = json[i].TOTALAMOUNT
		
		div2.innerHTML = json[i].MOVIENAME
		div3.appendChild(p1)
		div3.appendChild(p3)
		div4.appendChild(p4)
		div4.appendChild(p5)
		
		div1.appendChild(div2)
		div1.appendChild(div3)
		div1.appendChild(div4)
		div1.appendChild(input1)
		div1.appendChild(input2)
		
		historyList.appendChild(div1)
		
				// 예매 취소
		input2.onclick = function(event) {
			let idx = event.target.parentNode.querySelector(".idx").value
			let cancleUrl = cpath + "/cinemaMovie/ticketingHistoryCancel?idx=" + idx
			location.href = cancleUrl
//			location.href = cpath
//			console.log(event.target.parentNode.querySelector(".idx").value)
//			console.log(cpath + "/cinemaMovie/ticketingHistoryCancel")
		}
	}
})
