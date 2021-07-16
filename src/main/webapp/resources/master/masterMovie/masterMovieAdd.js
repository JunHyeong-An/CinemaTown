const searchName = document.getElementById('searchName')
const EmoticonImg = document.getElementById('EmoticonImg')
const ulList = document.querySelector('.ulList')
const movieInfo = document.querySelector('.movieInfo')
const urlName = document.getElementById('urlName')
const movieNameText = document.getElementById('movieNameText')
const ageLimit = document.getElementById('ageLimit')
const runningTime = document.getElementById('runningTime')
const movieSeq = document.getElementById('movieSeq')

// 영화진흥원 키
var key = "?key=5e8a22d1d31b39c318121c8b84fa519d" // key 앞에 <?key=>를 붙여야함 : prameter
	// 영화 kmdb 키
	var kkey = "65TF8R843O8851911435"
		var itemPerPage = "&itemPerPage=10" // 10개정도 영화리스트를 가져올거임

			const kmdbUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2&detail=Y&ServiceKey="
				+ kkey      //kmdb url입니다
				//+ targetDt
				var item_int = 10
				const officeUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json"
					+ key
					+ itemPerPage
					//영화진흥원 -무비리스트 url입니다 

					EmoticonImg.onclick = function(event) {
	movieInfo.style.display = 'flex'
		let office = fetch(officeUrl + "&movieNm=" + searchName.value)
		.then(response => response.json())
		.then(function (msg){
			return msg 
		})
		//영화 진흥원 movieList fetch 
		office.then(value => {
			//영화 진흥원
			const movieList1 = value.movieListResult.movieList
			ulList.innerHTML = ''
				for(let i = 0; i < movieList1.length; i++){ // 영화개수길이만큼 반복
					let name = movieList1[i].movieNm    // name = 영화진흥원의 영화이름들
					let movieList = fetch(kmdbUrl + "&title=" + name + "&createDts=2021") // kmdb 영화 리스트에 영화진흥원 영화이름을 접목시켜서 가져옴
					.then(response => response.json())
					.then(function (json) {
						return json
					});
					movieList.then(value2 => {

						console.log(value2)
						//kmdb 영화 리스트
						const li = document.createElement('li')
						const span = document.createElement('span')

						li.className = 'liList'
							const liList = document.querySelector('.liList')
							const movieNm1 = document.createTextNode(name) // 영화이름
							const rating = value2['Data'][0]['Result'][0].rating //영화 등급
							const runtime = value2['Data'][0]['Result'][0].runtime //영화 상영시간
							const movieSeqNum = value2['Data'][0]['Result'][0].movieSeq //영화 seq
							let posters = value2['Data'][0]['Result'][0].posters    //영화 포스터
							let arr = posters.split("|") // 포스터 url이 많아서 |로 나눔

							const img = document.createElement('img')
							img.id = 'movieImg'
								img.setAttribute("src", arr[0]) // 나눈거에 0번째 포스터를 가져와서 img에 넣었음
								span.appendChild(img)

								if(searchName.value == '') {    // 검색하지 않고 클릭을하면 
									ul.innerHTML = ''           // ul을 비워라
								}
						li.appendChild(span)
						li.appendChild(movieNm1)        //li안에 이름을 넣어서 보여준다

						ulList.appendChild(li)


						li.onclick = function() {       //검색해서 나온 이름을 클릭하면 

							if(rating == "전체관람가" || rating == "모두관람가"){   // 등급이 전체 , 모두면 0으로 보내라
								ageLimit.value = '0'
							}else {
								ageLimit.value = rating.substring(0,2)              // 등급은 앞에 2글자만따옵니다
							}
							urlName.value = arr[0]        //포스터 url 받기
							movieNameText.value = name    //이름 받기
							runningTime.value = runtime   // 상영시간받기
							movieCode.value = movieSeqNum
						}
					})
				}

		})

}
