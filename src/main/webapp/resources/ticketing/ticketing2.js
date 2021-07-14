const adultCount = document.querySelector("#adultCount")
const studentCount = document.querySelector("#studentCount")

const adultPlusBtn = document.querySelector("#adultPlusBtn")
const adultMinusBtn = document.querySelector("#adultMinusBtn")
const studentPlusBtn = document.querySelector("#studentPlusBtn")
const studentMinusBtn = document.querySelector("#studentMinusBtn")

let totalCount = 0
let selectCnt = 0

window.addEventListener("load", printCount)

adultPlusBtn.addEventListener("click", function () { increaseCount(adultCount) }, true)
adultMinusBtn.addEventListener("click", function () { decreaseCount(adultCount), true })
studentPlusBtn.addEventListener("click", function () { increaseCount(studentCount) }, true)
studentMinusBtn.addEventListener("click", function () { decreaseCount(studentCount), true })

// 출력 함수
function printCount() {
    adultCount.innerHTML = 0
    studentCount.innerHTML = 0
}

function increaseCount(targetCount) {
    targetCount.innerHTML = ++targetCount.innerHTML
    getTotalCount()
    selectSeatInit()
}

function decreaseCount(targetCount) {
    if (targetCount.innerHTML != 0)
        targetCount.innerHTML = --targetCount.innerHTML
    getTotalCount()
    selectSeatInit()
}

function getTotalCount() {
    totalCount = Number(adultCount.innerHTML) + Number(studentCount.innerHTML)
}

// 좌석 출력

const seatsSection = document.querySelectorAll(".seatsSection")

// 좌석 출력 함수
function printSeatlayout(seatCnt, target, section) {
    const rowOfSeats = ['', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
    let rowCnt = 0
    let seatNumCnt = 0;

    // 좌석 번호 출력
    for (let i = 0; i < seatCnt; i++) {
        const div = document.createElement("div")
        div.setAttribute("class", "seat")

        if (section == 0) {
            let seatNum = i % 2 == 0 ? 1 : 2
            rowCnt = (i % 2 == 0) ? rowCnt + 1 : rowCnt
            div.innerHTML = rowOfSeats[rowCnt] + seatNum

        }

        else if (section == 1) {
            const seatNum = [3, 4, 5, 6, 7]
            rowCnt = (i % 5 == 0) ? rowCnt + 1 : rowCnt
            div.innerHTML = rowOfSeats[rowCnt] + seatNum[seatNumCnt]
            seatNumCnt++

            if (seatNumCnt == seatNum.length) seatNumCnt = 0

        }

        else {
            let seatNum = i % 2 == 0 ? 8 : 9
            rowCnt = (i % 2 == 0) ? rowCnt + 1 : rowCnt
            div.innerHTML = rowOfSeats[rowCnt] + seatNum
        }
        target.appendChild(div)
    }
}

seatsSection.forEach((seatSection, section) => {
    if (section == 0 || section == 2) printSeatlayout(16, seatSection, section)
    else printSeatlayout(40, seatSection, section)
})

const seats = Array.from(document.querySelectorAll(".seat"))

seats.forEach(seat => {
    seat.addEventListener("click", function() {selectSeat(seat)}, true)
})

function selectSeat(seat) {
    if(totalCount != selectCnt) {
        if(seat.classList.contains('seatSelect')) {
            seat.classList.remove('seatSelect')
            selectCnt--
        }
        else {
            seat.classList.add('seatSelect')
            selectCnt++
        }
    }
    else if(seat.classList.contains('seatSelect')) {
        seat.classList.remove('seatSelect')
        selectCnt--
    }

    if(selectCnt == totalCount && totalCount != 0) {
    	let arr = []
    	seats.forEach(seat => {
    		if(seat.classList.contains("seatSelect")){
    			arr.push(seat.innerHTML) 
    		}
    	})
    	
    	selectSeats = arr.join()
    	
    	coverBox.style.display = "block"
    	document.querySelector("#coverBoxInfo2").style.display = "block"
    	document.querySelector("#userSelectSeats").innerHTML = selectSeats
    	document.querySelector("#coverBoxInfo2").querySelector("#coverBoxExit").onclick = function() {
    		document.querySelector("#coverBoxInfo2").style.display = "none"
    		coverBox.style.display = "none"
    	}
    	
    	document.querySelector("#toPayment").onclick = function() {
    		changeElement(changeCnt++)
    		document.querySelector("#coverBoxInfo2").style.display = "none"
    		coverBox.style.display = "none"
    		
    		adultCnt = adultCount.innerHTML
    		studentCnt = studentCount.innerHTML
    		
    		document.querySelector("#t3TicketingDateInfo").innerHTML = 
    			ticketingDate.substring(0, 4) + "년 " + ticketingDate.substring(4, 6) + "월 " + ticketingDate.substring(6, 8) + "일"
    		document.querySelector("#t3TicketingTime").innerHTML = 
    			ticketingTime.substring(0, 2) + "시 " + ticketingTime.substring(2, 4) + "분"
    		document.querySelector("#t3TicketingHallName").innerHTML = ticktingHallName
    		document.querySelector("#t3MovieName").innerHTML = movieName
    		document.querySelector("#t3Age").appendChild(ageLimitBox)
    		document.querySelector("#t3TotalCost").innerHTML = 
    			(adultCnt * adultCost + studentCnt * studentCost) + "원"
    			
    		totalCost = adultCnt * adultCost + studentCnt * studentCost
    	}
    	
    }
}

function selectSeatInit() {
    selectCnt = 0
    seats.forEach(seat => {
        seat.classList.remove('seatSelect')
    })
}
