let kmdbkey = "&ServiceKey=65TF8R843O8851911435"
let movieSeq = "&movieSeq=53228"
const kmdbUrl = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp?collection=kmdb_new2" + kmdbkey + movieSeq
const opt = {method:"GET"}
        
fetch(kmdbUrl, opt)
.then(resp => {
    return resp.json()
})
.then(json => {
    console.log(json)
})