const movieTop10 = document.querySelector("#movieTop10 ol")
let currDate = new Date()
let year = currDate.getFullYear()
let month = currDate.getMonth()+1 < 10 ? '0' + (currDate.getMonth() + 1) : currDate.getMonth() + 1
let date = currDate.getDate()-1 < 10 ? '0' + (currDate.getDate() - 1) : currDate.getDate() - 1
		
// 영화진흥원 키
var officekey = "?key=5e8a22d1d31b39c318121c8b84fa519d" // key 앞에 <?key=>를 붙여야함 : prameter
let officeTargetDate = "&targetDt=" + String(year) + String(month) + String(date)
// 영화 kmdb 키
var kmdbkey = "&ServiceKey=65TF8R843O8851911435"

const officeUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json" + officekey + officeTargetDate
const officeopt = {method:"GET"}

//const kmdbUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2" + kmdbkey + title

fetch(officeUrl, officeopt)
.then(resp => {
	return resp.json()
})
.then(json => {
	for(let i = 0; i < 10; i++) {
		const li = document.createElement("li")
		const a = document.createElement("a")
		
		a.innerHTML = json.boxOfficeResult.dailyBoxOfficeList[i].movieNm
		li.appendChild(a)
		movieTop10.appendChild(li)
	}
})

///////////////////////////////////////////////////////////

const listUrl = "list"
const listOpt = {method:"GET"}
const movieNameList = document.querySelector(".movieNameList ul")
const movieSchedule = document.querySelector("#movieSchedule")
const movieScheduleDate = document.querySelector(".currentDate")
let scheduleDate = new Date()

movieScheduleDate.innerHTML = scheduleDate.getFullYear() + "년 " + (scheduleDate.getMonth() + 1) + "월 "
							 + scheduleDate.getDate() + "일"
fetch(listUrl, listOpt)
.then(resp => {
	return resp.json()
})
.then(json => {
	for(i in json) {
		// 영화 이름 추가
		const movieSelect = document.createElement("div")
		movieSelect.classList.add("movieSelect")
		const li = document.createElement("li")
		const div = document.createElement("div")
		div.classList.add("movieName")
		div.innerHTML = json[i].movieName
		li.appendChild(div)
		movieNameList.appendChild(li)
		
		// 
		for(j in json[i].hallName) {
			const div2 = document.createElement("div")
			const a2 = document.createElement("a")
			a2.style.color = "black"
			div2.classList.add("movieSelectBox")
			
			a2.innerHTML = json[i].hallName[j] + "<br>" + json[i].start_time[j]
			div2.appendChild(a2)
			movieSelect.appendChild(div2)
		}
		movieSchedule.appendChild(movieSelect)
	}
})
