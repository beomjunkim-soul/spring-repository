/**
 * 
 */
async function startAjax(){
	//alert("fetch study");
	let userId =document.getElementById("userId").value;
	let resultDiv = document.getElementById("result");
	
	if(!userId){//falsy 유효하지 않은 값, null or 공란 or underfined 등일 때 false
		alert("사용자 아이디를 입력하시오");
		return;
	}
	//Ajax 요청 시작 전에 로딩이미지 표시
	resultDiv.innerHTML = "<img src=/images/working.gif>";
	// fetch 로 비동기 요청을 하고 서버가 응답할 때까지 대기(await)하다가 응답 완료되면(readyState==4) 실행 재개됨
	try{
		//Http Response 의 header 까지 분석되면 실행이 됨
	const response = await fetch(`/test-ajax3?userId=${userId}`);
	
	if(!response.ok){ // HttpResponse status code 가 200~299(정상수행) 가 아니면
		throw new Error(`Http error status: ${response.status}`);
	}
	//Http Response 의 body(응답 데이터)를 입력받음
	const data=await response.text();
	resultDiv.innerHTML = `ajax fetch 응답정보:${data}`;
	}catch(error){
		console.error("Fetch Error",error);
		resultDiv.innerHTML = `문제 발생`;
	}
}

console.log("다른 작업 진행...");