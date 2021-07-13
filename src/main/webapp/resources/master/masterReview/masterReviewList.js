//const listArticle = document.getElementById('listArticle')
//        	        		
//	        	const url = '${cpath}/phonebook/'  
//	        	const opt = {
//	        			method : 'GET'
//	        	}
//	        	fetch(url, opt)
//	        	.then(function(resp){
//	        		return resp.json()
//	        	})
//	        	.then(function(json){
//	        		listArticle.innerHTML = ''
//	        		for(ph in json){
//	        		const table = document.createElement('table') 
//	        			for(key in json[ph]){
//	        				const value = json[ph][key]
//	        				const td = document.createElement('td')
//	        				
//	        				td.innerText = value
//	        				table.appendChild(td)
//	        		}
//	        		 listArticle.appendChild(table)
//	        	}	
//
//	        	})
const movieNameId1 = document.getElementById('movieNameId1')
const movieNameId2 = document.getElementById('movieNameId2')

console.log(movieNameId1)
console.log(movieNameId2)

const url = '${cpath}/master/masterReview/masterReviewList/ ' + movieNameId2 + '/'
const opt = {
		method : 'GET'
}
fetch(url,opt)
.then(function(resp){
	return resp.json()
})
.then(function(json){
	console.log(json)
})
for(let i = 0; i <= 10; i++){
	const main = document.querySelector('.main')
	const div1 = document.createElement('div')
	const div2 = document.createElement('div')
	const div3 = document.createElement('div')
	const div4 = document.createElement('div')
	const span1 = document.createElement('span')
	const span2 = document.createElement('span')
	const deleteButton = document.createElement('button')
	
	div4.className = 'div4'
		div1.className = 'textArea'
			span1.className = 'areaDate'
				span1.innerText = '날짜: 2021년 7월 10일 19:08'
					span2.innerText = '닉네임 : 아이유'
						deleteButton.innerText = '삭제'
							div2.innerText = '내용 : '
								div3.appendChild(deleteButton)        
								div1.appendChild(span1)
								div1.appendChild(span2)
								div1.appendChild(div2)

								div4.appendChild(div1)
								div4.appendChild(div3)

								main.appendChild(div4)

}