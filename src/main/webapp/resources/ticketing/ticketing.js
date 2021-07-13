// 1번에서 영화제목, 예매 날짜

//    showDay       
//    다 붙혀서
//    movieName
//    SEATNAMEALL   NOT NULL VARCHAR2(50) 
//    ADULTCOUNT             NUMBER
//    TEENAGERCOUNT          NUMBER
//    DELETED                   CHAR(1)

const ticketingSideList = Array.from(document.querySelectorAll("#ticketingSideList li"))
const changeElements = Array.from(document.querySelectorAll(".changeElements"))
const elementsHeader = Array.from(document.querySelectorAll(".ticketingHeader"))

changeElements[0].classList.add("insertFlex")
elementsHeader[0].classList.remove("hidden")

//test
ticketingSideList.forEach((li, i) => {
    li.onclick = function() {
        listInit()
        headerInit()
        elementsInit()

        showElements(i)
        showHeader(i)
        li.classList.replace("listUnSelect", "listSelect")
    }
})

function listInit() {
    ticketingSideList.forEach(li => {
        li.classList.replace("listSelect", "listUnSelect")
    })
}

function showElements(i) {
    changeElements[i].classList.remove("hidden")
}

function elementsInit() {
    changeElements.forEach(e => {
        e.classList.add("hidden")
    })
}

function headerInit() {
    elementsHeader.forEach(e => {
        e.classList.add("hidden")
    })
}

function showHeader(i) {
    elementsHeader[i].classList.remove("hidden")
}
///////////////////////////////////////////////////////