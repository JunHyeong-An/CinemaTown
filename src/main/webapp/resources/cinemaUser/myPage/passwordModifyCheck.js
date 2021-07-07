/**
 * 
 */
const li = document.querySelectorAll("#headerList li")

li.forEach(l => {
	l.onmouseover = function() {
		l.querySelector(".menuText").style.borderBottom = '2px solid black'
	}
	l.onmouseleave = function() {
		l.querySelector(".menuText").style.borderBottom = 'none'
	}
})
