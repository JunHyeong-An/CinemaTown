/**
 * 
 */
//메뉴 밑줄 표시 및 드롭다운
const li = document.querySelectorAll("#headerList li")
const dropDowns = document.querySelectorAll(".dropDownMenu")

li.forEach((l, i) => {
	l.onmouseover = function() {
		l.querySelector(".menuText").style.borderBottom = '2px solid black'
			dropDowns[i].style.display = 'flex'
	}
	dropDowns[i].onmouseover = function() {
		l.querySelector(".menuText").style.borderBottom = '2px solid black'
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


function getParameterByName(name) {
  name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
  var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
  results = regex.exec(location.search);
  return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}