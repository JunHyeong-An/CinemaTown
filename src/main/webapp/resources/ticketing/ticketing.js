// 1번에서 영화제목, 예매 날짜

//    showDay       
//    다 붙혀서
//    movieName
//    SEATNAMEALL   NOT NULL VARCHAR2(50) 
//    ADULTCOUNT             NUMBER
//    TEENAGERCOUNT          NUMBER
//    DELETED                   CHAR(1)
const changeArea = document.querySelector("#changeArea")
const ticketingSideList = Array.from(document.querySelectorAll("#ticketingSideList li"))
const changeElements = Array.from(document.querySelectorAll(".changeElements"))
const elementsHeader = Array.from(document.querySelectorAll(".ticketingHeader"))

const adultCost = 14000
const studentCost = 11000

// 보내줘야하는 변수들
let movieName = ""
let ticketingDate = ""
let ticketingTime = ""
let ticktingHallName = ""
let selectSeats = ""
let adultCnt = ""
let studentCnt = ""
let totalCost = ""
let cardNum = ""
let cardCompany = ""
let cardPassword = ""
let scheduleIdx = ""
let reservationSeat =""
	console.log(ticketingDate)
// ticketing2로 보내는 변수들
let movieEndTime = ""
let movieScheduleIdx = ""
let ageLimitBox = null

// 남은 좌석 배열
let remainSeatArr = null

let endTime = ""
let urlName = ""
let ageNum = ""

changeElements[0].classList.add("insertFlex")
elementsHeader[0].classList.remove("hidden")

//test
//ticketingSideList.forEach((li, i) => {
//    li.onclick = function() {
//        listInit()
//        headerInit()
//        elementsInit()
//
//        showElements(i)
//        showHeader(i)
//        li.classList.replace("listUnSelect", "listSelect")
//    }
//})
//
//function listInit() {
//    ticketingSideList.forEach(li => {
//        li.classList.replace("listSelect", "listUnSelect")
//    })
//}
//
//function showElements(i) {
//    changeElements[i].classList.remove("hidden")
//}
//
//function elementsInit() {
//    changeElements.forEach(e => {
//        e.classList.add("hidden")
//    })
//}
//
//function headerInit() {
//    elementsHeader.forEach(e => {
//        e.classList.add("hidden")
//    })
//}
//
//function showHeader(i) {
//    elementsHeader[i].classList.remove("hidden")
//}
///////////////////////////////////////////////////////