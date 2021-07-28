const movieName = document.getElementById('movieName')
const movieNameButton = document.getElementById('movieNameButton')
const main = document.querySelector('.main')
let reviewMax = 10;

movieNameButton.onclick = function() {
	let movieNameParam = "movieName=" + movieName.value
	let maxParam = "&rowMax=" + reviewMax
	const url = cpath + "/master/masterReview/masterReviewList/masterGetReviewList?" + movieNameParam + maxParam
	console.log(url)
	const opt = {
		method : 'GET'
	}
	let reviewList = fetch(url,opt)
	.then(function(resp){
		return resp.json()
	})
	.then(function(json){
		console.log(json)

		main.innerHTML = ''
			for(let i = 0; i < json.length; i++){
				const div1 = document.createElement('div')
				const div2 = document.createElement('div')
				const div3 = document.createElement('div')
				const div4 = document.createElement('div')
				const span1 = document.createElement('span')
				const span2 = document.createElement('span')
				const deleteButton = document.createElement('button')

				div4.className = 'div4'
					div4.dataset.idx = json[i].review_idx
					div1.className = 'textArea'
						span1.className = 'areaDate'
							span1.innerText = json[i].reviewDay
							span2.innerText = '닉네임 : ' + json[i].userId
							deleteButton.innerText = '삭제'
								deleteButton.onclick = deleteReview

								div2.innerText = '내용 : ' + json[i].reviewContent
								div3.appendChild(deleteButton)        
								div1.appendChild(span1)
								div1.appendChild(span2)
								div1.appendChild(div2)

								div4.appendChild(div1)
								div4.appendChild(div3)

								main.appendChild(div4)

			}
	})
}

function deleteReview(event) {
	const target = event.target.parentNode.parentNode
	console.log(target.dataset.idx)

	const url = target.dataset.idx + '/'
	const opt = {
		method: 'DELETE'
	}
	fetch(url, opt).then(resp => resp.text())
	.then(text => {
		if(text == 1) {
			target.parentNode.removeChild(target)
		}
	})

}

document.onscroll = function() {
	let documentHeight = Math.max(
			document.body.scrollHeight, document.documentElement.scrollHeight,
			document.body.offsetHeight, document.documentElement.offsetHeight,
			document.body.clientHeight, document.documentElement.clientHeight
	)
	let scrollY	 = Math.round(window.pageYOffset)
	let scrollHeight = window.innerHeight + scrollY
	let movieNameParam = "movieName=" + movieName.value
	let maxParam = "&rowMax=" + reviewMax

	const reviewUrl = cpath + "/master/masterReview/masterReviewList/masterGetReviewList?" + movieNameParam + maxParam
	const opt = {
		method: "GET"
	}

	if(documentHeight <= scrollHeight){
		fetch(reviewUrl, opt)
		.then(resp => {
			return resp.json()
		})
		.then(json => {
			main.innerHTML = ''
				for(let i = 0; i < json.length; i++){
					const div1 = document.createElement('div')
					const div2 = document.createElement('div')
					const div3 = document.createElement('div')
					const div4 = document.createElement('div')
					const span1 = document.createElement('span')
					const span2 = document.createElement('span')
					const deleteButton = document.createElement('button')

					div4.className = 'div4'
						div4.dataset.idx = json[i].review_idx
						div1.className = 'textArea'
							span1.className = 'areaDate'
								span1.innerText = json[i].reviewDay
								span2.innerText = '닉네임 : ' + json[i].userId
								deleteButton.innerText = '삭제'
									deleteButton.onclick = deleteReview

									div2.innerText = '내용 : ' + json[i].reviewContent
									div3.appendChild(deleteButton)        
									div1.appendChild(span1)
									div1.appendChild(span2)
									div1.appendChild(div2)

									div4.appendChild(div1)
									div4.appendChild(div3)

									main.appendChild(div4)
					if(json != ''){
						reviewMax += 10
					}
				}
		})
	}
}

















