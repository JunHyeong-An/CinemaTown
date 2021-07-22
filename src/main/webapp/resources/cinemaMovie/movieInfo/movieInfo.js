let kmdbkey = "&ServiceKey=65TF8R843O8851911435"
let releaseDts = "&releaseDts=" + getParameterByName("releaseDts")
let title = "&title=" + getParameterByName("movieNm")
const kmdbUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2" + kmdbkey + releaseDts + title
const opt = {method:"GET"}

const moviePoster = document.querySelector("#movieInfoPoster")
const movieInfoTitle = document.querySelector("#title")
const engTitle = document.querySelector("#engTitle")
const director = document.querySelector("#director")
const actors = document.querySelector("#actors")
const nation = document.querySelector("#nation")
const prodYear = document.querySelector("#prodYear")
const runtime = document.querySelector("#runtime")
const rating = document.querySelector("#rating")
const genre = document.querySelector("#genre")
const moviePlot = document.querySelector("#moviePlot")
const stillCutBox = document.querySelector("#stillCutBox")
const video = document.querySelector("#video")

const stillCutMoveLeftBtn = document.querySelector("#stillCutMoveLeft")
const stillCutMoveRightBtn = document.querySelector("#stillCutMoveRight")

fetch(kmdbUrl, opt)
.then(resp => {
    return resp.json()
})
.then(json => {
	let data = json.Data[0].Result[0]
	let posters = data.posters.split("|")
	let title = data.title
	let directors = Array.from(data.directors.director)
	let actorsArr = Array.from(data.actors.actor)
	let directorsText = ""
	let actorsText = ""
	let stlls = data.stlls.split("|")
	let vod = data.vods.vod[0].vodUrl
		
	directors.forEach(direc => {
		directorsText += direc.directorNm + ","
	})
	
	actorsArr.forEach(ac => {
		actorsText += ac.actorNm + ", "
	})

	title = title.replaceAll("!HE", "")
	title = title.replaceAll("!HS", "")
	
    console.log(json.Data[0].Result[0])
    moviePoster.setAttribute("src", posters[0]) 
    movieInfoTitle.innerHTML = title
    engTitle.innerHTML = data.titleEng
    director.innerHTML = directorsText.substr(0, directorsText.length - 1)
    actors.innerHTML = actorsText.substr(0, actorsText.length - 2)
    nation.innerHTML = data.nation
    prodYear.innerHTML = data.prodYear
    runtime.innerHTML = data.runtime + "분"
    rating.innerHTML = data.rating
    genre.innerHTML = data.genre
    moviePlot.innerHTML = data.plots.plot[0].plotText
    
    stlls.forEach(stll => {
    	const img = document.createElement("img")
    	img.setAttribute("src", stll)
    	img.classList.add("movieStillCut")
    	stillCutBox.appendChild(img)
    })
    video.setAttribute("src", vod)
    // 스틸컷 슬라이드
    let leftPos = 0;
	stillCutBox.style.left = leftPos + "px"
	let limit = -(stlls.length - 2) * 610
    
    stillCutMoveLeftBtn.addEventListener("click", stillCutMoveLeft)
    stillCutMoveRightBtn.addEventListener("click", stillCutMoveRight)
    
    function stillCutMoveLeft() {
    	if(leftPos == 0) return
		leftPos += 610
		stillCutBox.style.left = leftPos + "px"
		stillCutBox.style.transition = 800 + "ms"
	}

	function stillCutMoveRight() {
		if(leftPos == limit) return	
		leftPos -= 610
		stillCutBox.style.left = leftPos + "px"
		stillCutBox.style.transition = 800 + "ms"
	}
})