const ticketing4MovieName = document.querySelector("#ticketing4MovieName")
const ticketing4Date = document.querySelector("#ticketing4Date")
const ticketing4Time = document.querySelector("#ticketing4Time")
const ticketing4HallName = document.querySelector("#ticketing4HallName")
const paymentMethod = document.querySelector("#paymentMethod")
const ticketing4TotalCost = document.querySelector("#ticketing4TotalCost")
let ageLimits = document.querySelectorAll(".ageLimit")

const jsonData = document.querySelector("#ticketingJson").value
console.log(jsonData)
let json = JSON.parse(jsonData)
console.log(json)

let movieName = json.movieName
let ticketingDate = json.ticketingDate
let ticketingTime = json.ticketingTime
let ticktingHallName = json.ticktingHallName
let totalCost = json.totalCost
	
ticketing4MovieName.innerHTML = movieName
ticketing4Date.innerHTML = ticketingDate
ticketing4Time.innerHTML = ticketingTime
ticketing4HallName.innerHTML = ticktingHallName
ticketing4TotalCost.innerHTML = totalCost