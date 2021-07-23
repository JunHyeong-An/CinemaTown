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