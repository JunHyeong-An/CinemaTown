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

const posterSectionImg = document.querySelector("#posterSectionImg")
const posterCnt = document.querySelectorAll(".mainPoster").length
let posterPosition = 0
posterSectionImg.style.left = "0px"
	
function movePoster() {
	posterPosition -= 300
	posterSectionImg.style.transition = 800 + "ms"
	posterSectionImg.style.left = posterPosition + "px"
	console.log(posterPosition)
	if((-300 * posterCnt) == posterPosition - 1200) {
		posterPosition = 0
	}
}

setInterval(movePoster, 3000)
