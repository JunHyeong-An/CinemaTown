/**
 * 
 */
const allDate = document.querySelector('.all')
const weekDay = document.querySelector('.weekDay')
const dayList = document.querySelector('.dayList')

var nowDate = new Date();
var todayDate = new Date(2021,6);
const year = todayDate.getFullYear();
const month = todayDate.getMonth() + 1;
const date =  todayDate.getDate();

const userYear = nowDate.getFullYear();
const userMonth = nowDate.getMonth() + 1;
console.log(userMonth-1)
const userDate =  nowDate.getDate();
const days = ["일", "월", "화", "수", "목", "금", "토"] 
const dayName = days[nowDate.getDay()];
const userDayName = days[todayDate.getDay()];
// 오늘 날짜 등록
const DateAll = userYear + '년' + userMonth + '월' + userDate + '일' + '(' + userDayName + ')'
allDate.innerText = DateAll

//일자 누르면 변동
for(let i = userDate; i < userDate + 12; i++) {
	todayDate.setDate(i) 
	const dateDiv = document.createElement('div')
	console.log(dateDiv)
	dateDiv.classList.add('divDate')
	if(i < 32){
		dateDiv.innerText = todayDate.getDate()
		dayList.appendChild(dateDiv)
	}
	const DateAll2 = year + '년' + month + '월' + todayDate.getDate() + '일' + "(" + days[todayDate.getDay()] + ")"
	let newMonth = month < 10 ? '0' + month : month  
	const DateAllJson = String(year) + newMonth + String(todayDate.getDate())
	
	dateDiv.onclick = function(event) {
		console.log(dateDiv.innerText)
		console.log(i)
		allDate.innerText = DateAll2
		console.log(DateAllJson)
		let tosDate = {
			date : DateAllJson
		}
		console.log(tosDate.date)
		let tosDateJson = JSON.stringify(tosDate)
		console.log()
		const url = "schedule/list/" + tosDateJson+"/" 
		const opt = {
			method : 'GET'
		}
		fetch(url,opt)
		.then(resp => {
			return resp.json()
		})
		.then(json => {
			console.log(json)
		})

	}
}