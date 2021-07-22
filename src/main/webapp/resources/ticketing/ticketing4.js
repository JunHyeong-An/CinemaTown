//const ticketing4MovieName = document.querySelector("#ticketing4MovieName")
const ticketing4Date = document.querySelector("#ticketing4Date")
const ticketing4Time = document.querySelector("#ticketing4Time")
const ticketing4HallName = document.querySelector("#ticketing4HallName")
const paymentMethod = document.querySelector("#paymentMethod")
const ticketing4TotalCost = document.querySelector("#ticketing4TotalCost")
const ticketingMoviePoster = document.querySelector("#ticketingMoviePoster")
let ageLimits = document.querySelectorAll(".ageLimit")

const jsonData = document.querySelector("#ticketingJson").value
let json = JSON.parse(jsonData)
console.log(json)

let movieName = json.movieName
let ticketingDate = json.ticketingDate
let ticketingTime = json.ticketingTime
let ticktingHallName = json.ticktingHallName
let totalCost = json.totalCost

let tYear = ticketingDate.substr(0, 4)
let tMonth = ticketingDate.substr(4, 2)
let tDate = ticketingDate.substr(6, 2)

ticketingMoviePoster.setAttribute("src", json.urlName)
ageLimits.innerHTML = json.ageLimit
ticketing4MovieName.innerHTML = movieName
ticketing4Date.innerHTML = tYear + "년 " + tMonth + "월 " + tDate + "일"
ticketing4Time.innerHTML = ticketingTime.substr(0, 2) + "시 " + ticketingTime.substr(2,2) + "분"
ticketing4HallName.innerHTML = ticktingHallName
ticketing4TotalCost.innerHTML = totalCost + "원"