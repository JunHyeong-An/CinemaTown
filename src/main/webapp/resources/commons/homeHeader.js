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
////////////////////////////////////////////////////////
// 슬라이더
const posterSectionImg = document.querySelector("#posterSectionImg")
let cnt = 0
let posterCnt = 0
let pCnt = 4;
let posterPosition = 0
posterSectionImg.style.left = "0px"
function movePoster() {
//	console.log('posterCnt : ' + posterCnt)
//	console.log('cnt : ' + cnt)
//	console.log('pCnt : ' + pCnt)
	if(pCnt == posterCnt) {
		posterPosition = 0
		posterSectionImg.style.transition = 800 + "ms"
		posterSectionImg.style.left = posterPosition + "px"
		posterCnt = cnt
		pCnt = 3	
	}
	else {
		posterPosition -= 320
		posterSectionImg.style.transition = 800 + "ms"
		posterSectionImg.style.left = posterPosition + "px"
	}
	pCnt++
//	console.log(pCnt)
}
setInterval(movePoster, 3000)
/////////////////////////////////////////////////////////

const movieCodeList = Array.from(document.querySelectorAll(".movieCodes"))
//const posterSectionImg = document.querySelector("#posterSectionImg")

movieCodeList.forEach(code => {
	const kmdbkey = "&ServiceKey=65TF8R843O8851911435"
	let movieSeq = "&movieSeq=" + code.value
	let releaseDts = "&releaseDts=20210101"
	const kmdbUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2"
		+ kmdbkey + movieSeq + releaseDts
	const opt = {method:"GET"}
	
	fetch(kmdbUrl, opt)
	.then(resp => {
		return resp.json()
	})
	.then(json => {
		let data = json.Data[0].Result[0]
		let posters = data.posters.split("|")
		const posterImg = document.createElement("img")
		const posterA = document.createElement("a")
		console.log(data)
		let releaseDts = "?releaseDts=" + data.repRlsDate
		let movieNm = "&movieNm=" + data.title
		posterA.setAttribute("href", cpath + "/cinemaMovie/movieInfo" + releaseDts + movieNm)
		posterImg.setAttribute("class", "mainPoster")
		posterImg.setAttribute("src", posters[0])
		posterA.appendChild(posterImg)
		posterSectionImg.appendChild(posterA)
		cnt++
		posterCnt = cnt
	})	
})











