
paymentMethods.forEach((method, i) => {
    method.addEventListener('click', function() {selectPaymetMethod(method, i)})
})


function selectPaymetMethod(method, i) {
    if(i == 0) {
        methodBox[0].classList.remove("hidden")
        methodBox[1].classList.add("hidden")
    }
    else {
        methodBox[1].classList.remove("hidden")
        methodBox[0].classList.add("hidden")
        table.classList.add("hidden")
        cardBackInit()
    }

    if(method.classList.contains('methodUnSelect')) {
        method.classList.replace('methodUnSelect', 'methodSelect')
        
        if(method.nextElementSibling != null) {
            method.nextElementSibling.classList.replace('methodSelect', 'methodUnSelect')
        }
        else if(method.previousElementSibling != null) {
            method.previousElementSibling.classList.replace('methodSelect', 'methodUnSelect')
        }
    }
}

cards.forEach(card => {
    card.addEventListener("click", function() {showPayment(card)})
})

function showPayment(card) {
    cardBackInit()
    card.style.backgroundColor = "gray"

    let cardName = card.innerHTML
    const tableCardName = document.querySelector("#cardName")

    if(table.classList.contains("hidden")) {
        table.classList.remove("hidden")
    }
    else {
        tableCardName.innerHTML = cardName
    }
    tableCardName.innerHTML = cardName
}

function cardBackInit() {
    cards.forEach(card => {
        card.style.backgroundColor = "white"
    })
}