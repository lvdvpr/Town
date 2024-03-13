<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>회원가입</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1 class="border bg-light p-2 fs-4">회원가입</h1>
        </div>
    </div>
    <div class="row mb-3">
        <div class="col-12">
            <form:form modelAttribute="userRegisterForm" id="form-register" method="post" action="register">
            	<div class="mb-1" style="text-align: right;">
            		(<span style="color:red;">*</span>)표시는 필수입력항목입니다.
            	</div>
                <div class="mb-3">
                    <label class="form-label">아이디</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="id" placeholder="3~12자리 영문(소문자), 숫자로 입력 (단, 시작은 영소문자만 가능)" maxLength="12"/>
                    <form:errors path="id" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label class="form-label">비밀번호</label>
                    <span style="color:red;">*</span>
                    <form:password class="form-control" path="password" placeholder="8~16자리 영문(대/소문자), 숫자, 특수문자 조합하여 입력"  maxLength="16"/>
                    <form:errors path="password" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label class="form-label">닉네임</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="name" placeholder="2~12자리 영문(대/소문자), 한글로 입력" maxLength="12"/>
                    <form:errors path="name" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label class="form-label">이메일</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="email" placeholder="이메일 입력" maxLength="100"/>
                    <form:errors path="email" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label class="form-label">연락처</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="phone" id="phone" placeholder="연락처 입력" onkeyup="autoHyphen()" maxLength="45"/>
                    <form:errors path="phone" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                	<div class="col-12">
	                    <label class="form-label">우편번호</label>
                	</div>
                	<div style="display: flex;">
	                    <button type="button" onclick="searchAddress()" class="btn" style="background-color:cornflowerblue; color:white; min-width:90px; flex:1.5;">주소찾기</button>
	                    <span style="width:30px;"></span>
		                <input type="text" class="form-control" style="flex:15;" id="zipcode" name="zipcode" placeholder="주소찾기를 이용하여 입력"/>
                    </div>
                </div>
                <div class="mb-3">
                    <label class="form-label">기본주소</label>
                    <input type="text" class="form-control" id="basicAddress" name="basicAddress" placeholder="주소찾기를 이용하여 입력"/>
                </div>
                <div class="mb-3">
                    <label class="form-label">상세주소</label>
                    <input type="text" class="form-control" id="detailAddress" name="detailAddress" placeholder="상세 주소 입력" maxLength="100"/>
                </div>
                <div class="text-center">
                	<button type="submit" class="btn btn-lg btn-outline-primary" style="margin-top: 25px;">회원가입</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

// 연락처 입력시 자동 하이픈 삽입 기능
function autoHyphen() {
    let phone = document.getElementById("phone");
    	phone.value = 								// 가공된 결과를 다시 mobileTel 엘리먼트의 값으로 할당
    		phone.value
    		.replace(/[^0-9]/g, "")
            .replace(/(^02|^050[0-9]|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/, "$1-$2-$3")
            .replace("--", "-");
}

// 주소찾기 api
function searchAddress() {
	new daum.Postcode({
		oncomplete: function(data) {
			document.getElementById('zipcode').value = data.zonecode;
			document.getElementById("basicAddress").value = data.roadAddress;
		}
	}).open();
}

</script>
</body>
</html>