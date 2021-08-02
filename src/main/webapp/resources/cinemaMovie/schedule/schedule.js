//변수
const allDate = document.querySelector('.all')
const weekDay = document.querySelector('.weekDay')
const dayList = document.querySelector('.dayList')
const Alltable = document.querySelector('.Alltable')
//오늘 날짜 변수
var nowDate = new Date();
var todayDate = new Date();
const year = todayDate.getFullYear();
const month = todayDate.getMonth() + 1;
const date =  todayDate.getDate();

const userYear = nowDate.getFullYear();
const userMonth = nowDate.getMonth() + 1;

const userDate =  nowDate.getDate();
const days = ["일", "월", "화", "수", "목", "금", "토"] 
const dayName = days[nowDate.getDay()];
const userDayName = days[todayDate.getDay()];
let ageValue = ''
//오늘 날짜 등록
const DateAll = userYear + '년' + userMonth + '월' + userDate + '일' + '(' + userDayName + ')'
allDate.innerText = DateAll
		//오늘날짜부터 길이 12까지 반복해라
		for(let i = userDate; i < userDate + 12; i++) {
			//i만큼 날짜일수가 바뀐다
			todayDate.setDate(i) 
			const dateDiv = document.createElement('div')
			
			dateDiv.classList.add('divDate')
			//i가 32가 안넘으면 담아라
			if(i < 32){
				dateDiv.innerText = todayDate.getDate()
				dayList.appendChild(dateDiv)
			}
			//변하는 날짜변수
			const DateAll2 = year + '년' + month + '월' + todayDate.getDate() + '일' + "(" + days[todayDate.getDay()] + ")"
			// 달,일 00,01 맞춰주기
			let newMonth = month < 10 ? '0' + month : month  
			let newDate = todayDate.getDate() < 10 ? '0' + todayDate.getDate() : todayDate.getDate()
			//json으로 변환
			const DateAllJson = String(year) + newMonth + String(newDate)
			let tosDate = {
				date : DateAllJson
			}
			let tosDateJson = JSON.stringify(tosDate)
			console.log(tosDateJson)
			const url = "schedule/list/" + tosDateJson+ "/" 
			const opt = {
				method : 'GET'
			}
			
			
			// 날짜를 선택하면 발생하는 이벤트
			const cb = function(event) {
				document.querySelectorAll('.divDate').forEach(e => e.style.color = 'white')
				Alltable.innerHTML = ''
				allDate.innerText = DateAll2
				
				const target = event.target == null ? document.querySelector('.divDate') : event.target
				target.style.color = 'red'
				
				fetch(url,opt)
				.then(resp => {
					return resp.json()
				})
				.then(movieAllInfo => {
					console.log(movieAllInfo)
					
					for(let j = 0; j < movieAllInfo.length; j++) {
						let divAge = document.createElement('div')
						let divName = document.createElement('div')
						let movieInfo =document.createElement('div')
						let oneSpace = document.createElement('div')
						let twoSpace = document.createElement('div')
						let threeSpace = document.createElement('div')
						let fourSpace = document.createElement('div')
						let fiveSpace = document.createElement('div')
						let sixSpace = document.createElement('div')
						
						divAge.className = 'ageLimit'
						divName.className = 'movieName'
						movieInfo.className = 'movieInfo'
						oneSpace.className = 'oneSpace'
						twoSpace.className = 'twoSpace'
						threeSpace.className = 'threeSpace'
						fourSpace.className = 'fourSpace'
						fiveSpace.className = 'fiveSpace'
						sixSpace.className = 'sixSpace'
							
						
						divAge.innerText = movieAllInfo[j].ageLimit
						ageValue = movieAllInfo[j].ageLimit
						divName.innerText = movieAllInfo[j].movieName
						movieInfo.appendChild(divAge)
						movieInfo.appendChild(divName)
						Alltable.appendChild(movieInfo)
						if(movieAllInfo[j].ageLimit == 0) {
							divAge.innerHTML = "전체"
							divAge.style.fontSize = "10pt"
							divAge.style.backgroundColor = "#55C155"
						}
						else if(movieAllInfo[j].ageLimit == '12'){
							divAge.style.backgroundColor = "#45B9F3"
						}
						else if(movieAllInfo[j].ageLimit == '15'){
							divAge.style.backgroundColor = "#EFBB11"
						}
						else if(movieAllInfo[j].ageLimit == '18') {
							divAge.style.backgroundColor = "#CA1212"
						}
							
							
						// 6만큼 증가를 시키는데 movieAllInfo[j][a]가 undefined면 멈춰라
						for(let a = 0; a < 6; a++){
							if(movieAllInfo[j][a] == undefined){
								break;
							}
							//끝나는 시간 길이만큼 정보들을 출력시켜라
							for(let q = 0;  q < movieAllInfo[j][a].end_time.length; q++){
								let divInfo = document.createElement('div')
								let spanRed = document.createElement('spanRed')
								let aTag = document.createElement('a')
								
								divInfo.className = 'movieInfoDetail'
								let start_time = movieAllInfo[j][a].start_time[q]
								let end_time = movieAllInfo[j][a].end_time[q]
								let seatCountRemain = movieAllInfo[j][a].seatCountRemain[q]
								let hallName = movieAllInfo[j][a].hallName
								//오늘 시간을 받아서
								let compareDate = new Date();
								let hour = compareDate.getHours();
								let minute = compareDate.getMinutes();
								let starttime = parseInt(start_time.split(':')[0]);
								let starttimeM = parseInt(start_time.split(':')[1]);
								
							    let nowT = hour * 100 + minute
							    let startT = starttime * 100 + starttimeM
							    
							    console.log(minute)
							    console.log(starttimeM)
							    
							    console.log(nowT)
							    console.log(startT)
								//지금 시간이 시작시간보다 작으면 a태그사용하도록 해라
								if(nowT < startT){
									aTag.setAttribute("href", cpath + "/cinemaMovie/ticketing?movieNm=" 
											+ movieAllInfo[j].movieName + "&hallName=" + hallName 
											+ "&startTime=" + start_time
											+ "&endTime=" + end_time
											+ "&schedule=" + movieAllInfo[j][a].schedule_idx[q]
									+ "&urlName=" + movieAllInfo[j].urlName
									+ "&ageNum=" + movieAllInfo[j].ageLimit
									+ "&resToken=1")
									aTag.innerText = start_time + '~' + end_time + '\t' + seatCountRemain + '/72' + '\t' + hallName
									divInfo.appendChild(aTag)										
									
								}else {
									divInfo.innerText = start_time + '~' + end_time + '\t' + seatCountRemain + '/72' + '\t' + hallName
									divInfo.style.backgroundColor = '#dadada'
								}
								
								aTag.onclick = function(event){
									const age = document.getElementById('userAge').value;
																
									if(age < ageValue){  
										event.preventDefault()
										alert(ageValue+'세 관람가입니다!!')
									}
											
								}
								// 관이 다르면 다른 div에 넣어라
								if(hallName == "1관"){
									oneSpace.appendChild(divInfo)							
									Alltable.appendChild(oneSpace)
								}
								if(hallName == "2관"){
									twoSpace.appendChild(divInfo)
									Alltable.appendChild(twoSpace)
								}
								if(hallName == "3관"){
									threeSpace.appendChild(divInfo)
									Alltable.appendChild(threeSpace)
								}
								if(hallName == "4관"){
									fourSpace.appendChild(divInfo)
									Alltable.appendChild(fourSpace)
								}
								if(hallName == "5관"){
									fiveSpace.appendChild(divInfo)
									Alltable.appendChild(fiveSpace)
								}
								if(hallName == "6관") {
									sixSpace.appendChild(divInfo)
									Alltable.appendChild(sixSpace)
								}
							}
							
							
						}
					}
					if(Alltable.innerText == ''){
						const divNo = document.createElement('div')
						divNo.className = 'noDiv'
						divNo.innerText = '상영시간이 정해지지않았습니다.'
						Alltable.appendChild(divNo)
					}
				})

			}
			dateDiv.onclick = cb
			
			if(userDate == i) {
				const customEvent = new Event('click')
				dateDiv.onclick(customEvent)
			}
			
			
		}


	