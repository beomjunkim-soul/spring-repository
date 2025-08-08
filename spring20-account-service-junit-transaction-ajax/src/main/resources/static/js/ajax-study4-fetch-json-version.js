/**
 *  ajax, fetch, async, await, json
 */
//성공, 에러 공통 메서드 
// 성공 메시지
function showSuccess(message) {
	const resultDiv = document.getElementById('result');
	resultDiv.innerHTML = message;
}

// 에러 메시지
function showError(message) {
	const resultDiv = document.getElementById('result');
	resultDiv.innerHTML = `<p>${message}</p>`;
}

async function getAccountByNumber() {
	const accountNumber = document.getElementById("accountNumber").value;
	if (!accountNumber) {
		alert("계좌 번호를 입력하세요");
		return;
	}
	try {
		const response = await fetch(`/api/accounts/${accountNumber}`);
		if (!response.ok) {
			const errorData = await response.json();
			throw new Error(errorData.message);
		}
		const account = await response.json();// text 가 아니라 json 으로 응답받는다
		showSuccess(`
		                    <p><strong>계좌번호:</strong> ${account.accountNumber}</p>
		                    <p><strong>계좌유형:</strong> ${account.accountType}</p>
		                    <p><strong>잔액:</strong> ${account.balance.toLocaleString()}원</p>   
		                   <p><strong>계좌주명:</strong> ${account.customer.name} </p>
		                `);

		//alert(account);
	} catch (error) {
		console.log(`Error`, error);
		showError(error.message);
	}
}

async function getAccountsByCustomer() {
	const customerId = document.getElementById("customerId").value;
	if (!customerId) {
		showError("고객 ID를 입력하세요");
		return;
	}
	try {
		const response = await fetch(`/api/accounts/customer/${customerId}`)
		if (!response.ok) {
			const errorData = await response.json(); // 에러 메세지 JSON Object 로 반환
			throw new Error(errorData.message);
		}
		//정상 수행일 때
		const accounts = await response.json();// 특정 고객의 계좌들을 리스트로 반환받음 JSON Array
		if (accounts.length === 0) {
			showSuccess("<p>해당 고객의 계좌가 없습니다</p>")//오류는 아니라서 showError 가 아니고 shoSuccess 에서 출력
			return;
		}

		//화면에 JSONArray르 표현한다
		let accountListHtml = `
						    <h3>계좌 목록 (총 ${accounts.length}개)</h3>
						    <table class="table table-bordered">
						        <thead>
						            <tr><th>계좌번호</th><th>계좌유형</th><th>잔액</th><th>개설일</th></tr>
						        </thead>
						        <tbody>
						`;
		accounts.forEach(account => {
			accountListHtml += `
						        <tr>
						            <td>${account.accountNumber}</td>
						            <td>${account.accountType}</td>
						            <td>${account.balance.toLocaleString()}원</td>
						            <td>${new Date(account.createdAt).toLocaleDateString()}</td>
						        </tr>
						    `;
		});
		accountListHtml += `</tbody></table>`;

		showSuccess(accountListHtml);
	} catch (error) {
		console.error(`Error`, error)
		showError(`${error.message}`);
	}
}








