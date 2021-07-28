/**
 * 
 */
const form = document.forms[0]
form.onsubmit = function(event) {
	event.preventDefault()
	const showDay = document.querySelector('input[name="day"]').value.replace(/-/gi, '')
	const startTime = document.querySelector('input[name="time"]').value.replace(/:/, '')

	const startTimeReal = showDay + startTime
	const hallName = document.querySelector('select[name="hallName"]').value

	const url = 'check/' + startTimeReal + '/' + hallName + '/'
	const opt = {
		method : 'GET'
	}
	fetch(url, opt).then(function(resp) {
		return resp.text()
	}).then(function(text) {
		console.log(text)
		if (text == 0) {
			const dateTime1 = document.createElement('input')
			dateTime1.type = 'hidden'
			dateTime1.name = 'showDay'
			dateTime1.value = showDay
			event.target.appendChild(dateTime1)

			const dateTime2 = document.createElement('input')
			dateTime2.type = 'hidden'
			dateTime2.name = 'startTime'
			dateTime2.value = startTimeReal
			event.target.appendChild(dateTime2)
			event.target.submit()
		} else {
			event.target.reset()
			alert('이미 해당 상영관에 상영일정이 존재합니다.')	
		}
	})
}
const scheduleTable = document.querySelector('.scheduleTable')
const scheduleUrl = "scheduleList"
const method = {
		method : 'GET'
}
fetch(scheduleUrl, method).then(function(resp){
	return resp.json()
}).then(function(json){
	console.log(json)
	for(let i = 0; i < json.length; i++){
		const table = document.createElement('table')
		const tr1 = document.createElement('tr')
		const tr2 = document.createElement('tr')
		const tr3 = document.createElement('tr')
		const tr4 = document.createElement('tr')
		
		const th1 = document.createElement('th')
		const th2 = document.createElement('th')
		const th3 = document.createElement('th')
		const th4 = document.createElement('th')
		
		th1.innerText = '날짜'
		th2.innerText = '영화이름'
		th3.innerText = '상영관'
		th4.innerText = '시간'
		
		const td1 = document.createElement('td')
		const td2 = document.createElement('td')
		const td3 = document.createElement('td')
		const td4 = document.createElement('td')
		
		td1.innerText = json[i].SHOWDAY
		td2.innerText = json[i].MOVIENAME
		td3.innerText = json[i].HALLNAME
		td4.innerText = json[i].START_TIME + '~' + json[i].END_TIME
//		console.log(json[i].END_TIME)
		tr1.appendChild(th1)
		tr1.appendChild(td1)
		
		tr2.appendChild(th2)
		tr2.appendChild(td2)
		
		tr3.appendChild(th3)
		tr3.appendChild(td3)
		
		tr4.appendChild(th4)
		tr4.appendChild(td4)
		
		table.appendChild(tr1)
		table.appendChild(tr2)
		table.appendChild(tr3)
		table.appendChild(tr4)
		
		scheduleTable.appendChild(table)
	}
})


