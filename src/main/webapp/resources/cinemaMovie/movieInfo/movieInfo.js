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

const reviewContainer = document.querySelector("#reviewContainer")
let reviewMin = 1
let reviewMax = 3

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
//	let vod = data.vods.vod[0].vodUrl
		
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

// 리뷰
let movieNm = getParameterByName("movieNm")
console.log(movieNm.substr(0,1))
if(movieNm.substr(0,1) == ' ')
	movieNm = movieNm.replace(" ", "")

document.onscroll = function() {
	let documentHeight = Math.max(
		document.body.scrollHeight, document.documentElement.scrollHeight,
		document.body.offsetHeight, document.documentElement.offsetHeight,
		document.body.clientHeight, document.documentElement.clientHeight
	)
	let scrollY	 = Math.round(window.pageYOffset)
	let scrollHeight = window.innerHeight + scrollY
	
	let movieNmParam = "movieNm=" + movieNm
	let maxParam = "&rowMax=" + reviewMax

	const reviewUrl = cpath + "/cinemaMovie/movieInfo/list?" + movieNmParam + maxParam
	const method = {
		method: "GET"
	}
	
	if(documentHeight <= scrollHeight) {
		fetch(reviewUrl, opt)
		.then(resp => {
			return resp.json()
		})
		.then(json => {
			const div1 = document.querySelector("#reviewList")
			div1.innerHTML = ""
			
			for(i in json) {
				const div2 = document.createElement("div")
				const p = document.createElement("p")
				const div3 = document.createElement("div")
				
				div2.setAttribute("class", "review")
				p.setAttribute("class", "reviewUserId")
				div3.setAttribute("class", "reviewValue")
				
				p.innerHTML = json[i].userId
				div3.innerHTML = json[i].reviewContent
				
				div2.appendChild(p)
				div2.appendChild(div3)
				div1.appendChild(div2)
				
				reviewContainer.appendChild(div1)
			}
			if(json != '') {
				reviewMax += 3					
			}
		})
	}
}

const reviewBtn = document.querySelector("#reviewBtn")
const reviewText = document.querySelector("#reviewText")

reviewBtn.onclick = function(event) {
	if(document.querySelector("#userId").value == '') {
//		console.log("\'" + cpath + "/cinemaUser/login?url=" + location.href +"\'")
		location.href = cpath + "/cinemaUser/login?url=" + location.href
	}
	
	let ob = {}
	ob.reviewContent = reviewText.value
	ob.movieNm = movieNm

	const reviewAddUrl = cpath + "/cinemaMovie/movieInfo/reviewAdd"
	const opt = {
		method: "POST",
		headers: {
			'Content-Type': 'application/json'
		},
		body : 	JSON.stringify(ob)
	}
	
	if(!reviewText.value == '') {
		fetch(reviewAddUrl, opt)
		.then(resp => {
			return resp.json()
		})
		.then(json => {
			console.log(json)
			reviewText.value = ''
			location.reload()
		})
	}
}

// 예고편 받아오기

const vodUrl = cpath + "/cinemaMovie/movieInfo/teaserUrl/" + getParameterByName("movieNm") + "/"
const vodOpt = {method : 'GET'}

fetch(vodUrl, vodOpt)
.then(resp => {
	return resp.text()
})
.then(json => {
	console.log(1)
	video.setAttribute("src", json)
})
