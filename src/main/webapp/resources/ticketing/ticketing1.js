// 달력관련
const currDate = new Date()
const selectDate = new Date()
const days = ["일", "월", "화", "수", "목", "금", "토"]

const showSelectMonth = document.querySelector("#showSelectMonth")
const monthBox = document.querySelector("#month")
const headerMonthBox = document.querySelector("#headerMonth")

const selectDateBox = document.querySelector("#selectDate")
const showSelectDate = document.querySelector("#showSelectDateValue")
const headerDate = document.querySelector("#headerDate")

const monthIncBtn = document.querySelector("#monthIncBtn")
const monthDreBtn = document.querySelector("#monthDreBtn")
const dateIncBtn = document.querySelector("#dateIncBtn")
const dateDcrBtn = document.querySelector("#dateDcrBtn")

const showingMovieList = Array.from(document.querySelectorAll("#showingMovieList li"))
const dateSection = document.querySelector("#dateSection")



// 달과 날짜를 출력해줌
function insertMonthAndDate() {
    selectDateBox.innerHTML = ''
    let month = selectDate.getMonth() + 1 < 10 ? '0' + (selectDate.getMonth() + 1) : selectDate.getMonth() + 1

    monthBox.innerHTML = month
    headerMonthBox.innerHTML = month
    showSelectMonth.innerHTML = month

    blockMonthBtn(monthIncBtn, monthDreBtn)
    blockDateBtn(dateIncBtn, dateDcrBtn)
    insertDate()
    
    let ageLimits = Array.from(document.querySelectorAll(".ageLimit"))
    ageLimits.forEach(limit => {
    	if(limit.innerHTML == 0) {
    		limit.innerHTML = "전체"
    		limit.style.fontSize = "5pt"
    		limit.style.backgroundColor = "#55C155"
    	}
    	else if(limit.innerHTML == 12) limit.style.backgroundColor = "#45B9F3"
    	else if(limit.innerHTML == 15) limit.style.backgroundColor = "#EFBB11"
    	else if(limit.innerHTML == 18) limit.style.backgroundColor = "#CA1212"
    })

}

//영화버튼 누르면 그 영화에 배당된 시간 출력

let movieName = ""
let ticketingDate = ""

movieListInit()
showingMovieList.forEach(li => {
	dateSection.classList.add("hidden")
	li.onclick = function() {
		movieListInit()
		li.style.backgroundColor = "#707070"
		li.style.color = "white"
		dateSection.classList.remove("hidden")
		ticketingDate = document.querySelector("#headerYear").innerHTML
						+ document.querySelector("#headerMonth").innerHTML
						+ document.querySelector("#headerDate").innerHTML
		
		movieName = li.querySelector(".movieName").innerHTML
		getMovieList()
	}
})

function movieListInit() {
	showingMovieList.forEach(li => {
		li.style.backgroundColor = "inherit"
		li.style.color = "gray"
	})
}

// 날짜 출력 함수
function insertDate() {
    for(let i = 0; i < 7; i++) {
        // 각 달의 마지막 날에는 1 더해주면 안됨
        let plusDate = 0

        if(i == 0) plusDate = 0
        else plusDate = 1

        if(selectDate.getDate() == getLastDate()) plusDate = 0
        selectDate.setDate(selectDate.getDate() + plusDate)
        
        const li = document.createElement("li")
        const div1 = document.createElement("div")
        const div2 = document.createElement("div")
        
        div1.innerHTML = selectDate.getDate()
        div2.innerHTML = days[selectDate.getDay()]
        div2.setAttribute("class", "day")
    
        li.appendChild(div1)
        li.appendChild(div2)
        li.setAttribute("class", "dates")
        selectDateBox.appendChild(li)
    }
    let date = selectDate.getDate() - 6 < 10 ? '0' + (selectDate.getDate() - 6) : selectDate.getDate() - 6

    showSelectDate.innerHTML = date
    headerDate.innerHTML = date

    // 각 날짜를 눌렀을 때 이벤트
    const dates = Array.from(document.querySelectorAll(".dates"))
   
    
    dates[0].style.backgroundColor = 'gray'
    dates.forEach(element => {
        element.onclick = function() {
            for(let i = 0; i < dates.length; i++) {
                dates[i].style.backgroundColor = 'inherit'
            }
            element.style.backgroundColor = 'gray'

            let userSelectDate = element.querySelector("div").innerHTML < 10 ? '0' + (element.querySelector("div").innerHTML) : element.querySelector("div").innerHTML
            showSelectDate.innerHTML = userSelectDate
            headerDate.innerHTML = userSelectDate
            
            ticketingDate = document.querySelector("#headerYear").innerHTML
			+ document.querySelector("#headerMonth").innerHTML
			+ document.querySelector("#headerDate").innerHTML
			getMovieList()
        }
    })
}

function getMovieList() {
	const url = "ticketing/" + movieName +"/" + ticketingDate + "/"
	const opt = {
		method: "GET"
	}
	
	fetch(url, opt)
	.then(resp => {
		console.log(resp)
	})
}

// 달 증가
function increaseMonth() {
    selectDate.setDate(selectDate.getDate() - 1)
    selectDate.setMonth(selectDate.getMonth() + 1)
    resetDate()
    insertMonthAndDate()
}

// 달 감소
function decreaseMonth() {   
    selectDate.setMonth(selectDate.getMonth() - 1)
    resetDate()
    insertMonthAndDate()
}
// 현재 달이 아닐때 해당 달의 1일로 초기화
function resetDate() {
    if(selectDate.getMonth() == currDate.getMonth())
        selectDate.setDate(currDate.getDate())
    else
        selectDate.setDate(1)
}

// 날짜 증가
function increaseDate() {
    selectDate.setDate(selectDate.getDate() - 5)
    insertMonthAndDate()
}

// 날짜 감소
function decreaseDate() {
    selectDate.setDate(selectDate.getDate() - 7)
    insertMonthAndDate()
}

// 해당 달의 마지막날 구하기
function getLastDate() {
    let date = new Date(currDate.getFullYear(), selectDate.getMonth() + 1, 0)
    return date.getDate()
}

// 첫번째 달 혹은 첫 번째날 혹은 마지막 달 혹은 마지막 날에는 다음 혹은 이전으로 넘어가는 버튼 막기
function blockMonthBtn(increaseBtn, decreaseBtn) {
    if(selectDate.getMonth() == 0 || selectDate.getMonth() == currDate.getMonth())
        decreaseBtn.style.display = 'none'
    else
        decreaseBtn.style.display = 'flex'
    
    if(selectDate.getMonth() == 11)
        increaseBtn.style.display = 'none'
    else
        increaseBtn.style.display = 'flex'
}

function blockDateBtn(increaseBtn, decreaseBtn) {
    if(selectDate.getDate() == 1 || (selectDate.getDate() == currDate.getDate() && selectDate.getMonth() == currDate.getMonth()))
        decreaseBtn.style.display = 'none'
    else 
        decreaseBtn.style.display = 'flex'

    if(selectDate.getDate() + 6 == getLastDate())
        increaseBtn.style.display = 'none'
    else  
        increaseBtn.style.display = 'flex' 
}

// 처음 페이지가 로딩 되었을때, 달과 날짜를 출력해줌
window.onload = insertMonthAndDate

monthIncBtn.onclick = increaseMonth
monthDreBtn.onclick = decreaseMonth

dateIncBtn.onclick = increaseDate
dateDcrBtn.onclick = decreaseDate

// 달력 관련 끝


