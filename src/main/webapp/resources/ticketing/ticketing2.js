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
    		changeElement(changeCnt)
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
    		document.querySelector("#ticketingMoviePoster").setAttribute("src", urlName)
    		totalCost = adultCnt * adultCost + studentCnt * studentCost
    		console.log('totalCost : ' + totalCost)
    	}
    	
    }
}

function selectSeatInit() {
    selectCnt = 0
    seats.forEach(seat => {
        seat.classList.remove('seatSelect')
    })
}
