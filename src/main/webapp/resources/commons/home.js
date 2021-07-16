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

fetch(listUrl, listOpt)
.then(resp => {
	return resp.json()
})
.then(json => {
	console.log(json)
})
