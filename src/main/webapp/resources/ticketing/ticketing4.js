const ticketing4MovieName = document.querySelector("#ticketing4MovieName")
const ticketing4Date = document.querySelector("#ticketing4Date")
const ticketing4Time = document.querySelector("#ticketing4Time")
const ticketing4HallName = document.querySelector("#ticketing4HallName")
const paymentMethod = document.querySelector("#paymentMethod")
const ticketing4TotalCost = document.querySelector("#ticketing4TotalCost")
let ageLimits = document.querySelectorAll(".ageLimit")

const jsonData = document.querySelector("#ticketingJson").value
let json = JSON.parse(jsonData)
console.log(json)

let movieName = json.movieName
let ticketingDate = json.ticketingDate
let ticketingTime = json.ticketingTime
let ticktingHallName = json.ticktingHallName
let totalCost = json.totalCost

ticketingTime = ticketingTime.substr(0,2) + "시 " + ticketingTime.substr(2, 4) + "분"

let year = ticketingDate.substr(0, 4) + "년 "
let month = ticketingDate.substr(4, 2) + "월 "
let date = ticketingDate.substr(8, 2) + "일 "
	
ticketing4MovieName.innerHTML = movieName
ticketing4Date.innerHTML = year + month + date
ticketing4Time.innerHTML = ticketingTime
ticketing4HallName.innerHTML = ticktingHallName
ticketing4TotalCost.innerHTML = totalCost
document.querySelector("#ticketingMoviePoster").setAttribute("src", json.urlName)
document.querySelector("#paymentMethod").innerHTML = json.cardCompany

let ageNum = json.ageLimit
const div = document.querySelector(".ageLimit")
div.innerHTML = ageNum	

if(ageNum == '0') {
	div.innerHTML = "전체"
	div.style.fontSize = "5pt"
	div.style.backgroundColor = "#55C155"
}
else if(ageNum == '12') div.style.backgroundColor = "#45B9F3"
else if(ageNum == '15') div.style.backgroundColor = "#EFBB11"
else if(ageNum == '18') div.style.backgroundColor = "#CA1212"