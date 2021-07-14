/**
 * 
 */
// header.js 랑 다를거 없음
// 메뉴 밑줄 표시 및 드롭다운
const li = document.querySelectorAll("#headerList li")
const dropDowns = document.querySelectorAll(".dropDownMenu")
li.forEach((l, i) => {
	l.onmouseover = function() {
		l.querySelector(".menuText").style.borderBottom = '2px solid white'
			dropDowns[i].style.display = 'flex'
	}
	dropDowns[i].onmouseover = function() {
		l.querySelector(".menuText").style.borderBottom = '2px solid white'
			dropDowns[i].style.display = 'flex'
	}
	l.onmouseleave = function() {
		l.querySelector(".menuText").style.borderBottom = 'none'
			dropDowns[i].style.display = 'none'
	}
	dropDowns[i].onmouseleave = function() {
		l.querySelector(".menuText").style.borderBottom = 'none'
			dropDowns[i].style.display = 'none'
	}
})
////////////////////////////////////////////////////////////////////
const bannerCloseBtn = document.querySelector("#bannerCloseBtn")
const headerBanner = document.querySelector("#headerBanner")

bannerCloseBtn.onclick = function() {
	headerBanner.style.display = "none"
}
/////////////////////////////////////////////////////////////////////
const movieNames = Array.from(document.querySelectorAll(".movieNames"))
let currDate = new Date()
let year = currDate.getFullYear()
let month = currDate.getMonth() < 10 ? '0' + currDate.getMonth() : currDate.getMonth()
let date = currDate.getDate() < 10 ? '0' + currDate.getDate() : currDate.getDate()

// 영화진흥원 키
var officekey = "?key=5e8a22d1d31b39c318121c8b84fa519d" // key 앞에 <?key=>를 붙여야함 : prameter
let officeTargetDate = "&targetDt=" + String(year) + String(month) + String(date)
// 영화 kmdb 키
var kmdbkey = "&ServiceKey=65TF8R843O8851911435"

const officeUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json" + officekey + officeTargetDate
const officeopt = {method:"GET"}

movieNames.forEach(name => {
	const title = "&title=" + name.value
	const kmdbUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2" + kmdbkey + title
	const kmdbOpt = {method:"GET"}
	
	fetch(kmdbUrl, kmdbOpt)
	.then(reps => {
		return reps.json()
	})
	.then(json => {
		console.log(json)
		let arr = json.Data[0].Result[1].posters.split("|")
		console.log(arr)
		
		const posterSectionImg = document.querySelector("#posterSectionImg")
		
		const img = document.createElement("img")
		img.classList.add("mainPoster")
		img.setAttribute("src", arr[0])
		
		posterSectionImg.appendChild(img)
	})
	
})