/**
 * 
 */
//폰넘버 합치기
        makePhnumber = function() {
            const userPh1 = document.querySelector('select[name="userPh1"]')
            const userPh2 = document.querySelector('input[name="userPh2"]')
            const userPh3 = document.querySelector('input[name="userPh3"]')
            const userPhHidden = document.getElementById('userPhHidden')
            const userPh = userPh1.value +'-'+ userPh2.value+'-' + userPh3.value
            userPhHidden.value = userPh
            
        }
        // 주소합치기
        makeAddressAdd = function() {
        	   const postcode = document.querySelector('input[name="postcode"]')
        	   const userAddr1 = document.querySelector('input[name="userAddr1"]')
        	   const userAddr2 = document.querySelector('input[name="userAddr2"]')
        	   const userAddrHidden = document.getElementById('userAddrHidden')
        	   const userAddr = postcode.value+'/'+ userAddr1.value + ',' + userAddr2.value
        	   userAddrHidden.value = userAddr
        	   
        	}
        
      //주소 api
        function sample6_execDaumPostcode() {
           new daum.Postcode({
              oncomplete: function (data) {
                 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                 // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                 var addr = ''; // 주소 변수
                 var extraAddr = ''; // 참고항목 변수

                 //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                 if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                 } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                 }

                 

                 // 우편번호와 주소 정보를 해당 필드에 넣는다.
                 document.getElementById('sample6_postcode').value = data.zonecode;
                 document.getElementById("sample6_address").value = addr;
                 // 커서를 상세주소 필드로 이동한다.
                 document.getElementById("sample6_detailAddress").focus();
              }
           }).open();
        }
        // 필수 값 체크
        const submitBtn = document.querySelector("#submitModify")
        const checkJoinText = Array.from(document.querySelectorAll('input[type="text"]'))
    
        const totalArr = checkJoinText
        const modifyMsg = document.querySelector("#modifyMsg")
        
        totalArr.forEach(ar => {
            ar.onblur = function() {
                if(ar.value == '') modifyMsg.innerHTML = "필수값을 입력해주세요"
                else modifyMsg.innerHTML = ''
            }
        })
        submitBtn.onclick = function(event) {
       
            makePhnumber()
            makeAddressAdd()
            totalArr.forEach(ar => {
                if(ar.value == ''){
                    modifyMsg.innerHTML = "필수값을 입력해주세요"
                    event.preventDefault()
                }
            })
        }