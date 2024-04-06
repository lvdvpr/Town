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
    <div class="row mb-3">
    	<h4 class="border bg-light p-2">회원가입</h4>
    </div>
    <div class="row mb-3">
        <div class="col-12 border bg-light p-4">
            <form:form modelAttribute="userRegisterForm" id="form-register" method="post" action="register">
            	<div class="mb-1" style="text-align: right;">
            		(<span style="color:red;">*</span>)표시는 필수입력항목입니다.
            	</div>
                <div class="mb-3">
                	<div class="col-12">
                    	<label for="id" class="form-label">아이디</label>
                    	<span style="color:red;">*</span>
                    </div>
                    <div style="display: flex;">
	                    <form:input class="form-control" style="flex:15;" path="id" id="id" placeholder="영문(소문자), 숫자를 이용하여 3~12자리로 공백없이 입력 (단, 시작은 영소문자만 가능하며, 숫자로만 이루어진 아이디는 불가)" maxLength="12"/>
	                    <span style="width:30px;"></span>
	                    <button type="button" onclick="registerCheck()" class="btn" style="background-color:cornflowerblue; color:white; min-width:90px; flex:1.5;">중복체크</button>
                    </div>
	                    <form:errors path="id" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">비밀번호</label>
                    <span style="color:red;">*</span>
                    <form:password class="form-control" path="password" id="password" placeholder="영문(대/소문자), 숫자, 특수문자를 조합하여 공백없이 8~16자리로 입력"  maxLength="16"/>
                    <form:errors path="password" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label for="passwordConfirm" class="form-label">비밀번호 재입력</label>
                    <span style="color:red;">*</span>
                    <form:password class="form-control" path="passwordConfirm" id="passwordConfirm" placeholder="영문(대/소문자), 숫자, 특수문자를 조합하여 공백없이 8~16자리로 입력"  maxLength="16"/>
                    <form:errors path="passwordConfirm" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">닉네임</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="name" id="name" placeholder="영문(대/소문자), 한글을 이용하여 공백없이 2~12자리로 입력" maxLength="12"/>
                    <form:errors path="name" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">이메일</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="email" id="email" placeholder="이메일 입력" maxLength="100"/>
                    <form:errors path="email" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">연락처</label>
                    <span style="color:red;">*</span>
                    <form:input class="form-control" path="phone" id="phone" placeholder="연락처 입력" onkeyup="autoHyphen()" maxLength="45"/>
                    <form:errors path="phone" cssClass="text-danger" />
                </div>
                <div class="mb-3">
                	<div class="col-12">
	                    <label for="zipcode" class="form-label">우편번호</label>
                	</div>
                	<div style="display: flex;">
	                    <button type="button" onclick="searchAddress()" class="btn" style="background-color:cornflowerblue; color:white; min-width:90px; flex:1.5;">주소찾기</button>
	                    <span style="width:30px;"></span>
		                <input type="text" class="form-control" style="flex:15;" id="zipcode" name="zipcode" placeholder="주소찾기를 이용하여 입력"/>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="basicAddress" class="form-label">기본주소</label>
                    <input type="text" class="form-control" id="basicAddress" name="basicAddress" placeholder="주소찾기를 이용하여 입력"/>
                </div>
                <div class="mb-3">
                    <label for="detailAddress" class="form-label">상세주소</label>
                    <input type="text" class="form-control" id="detailAddress" name="detailAddress" placeholder="상세 주소 입력" maxLength="100"/>
                </div>
                <div class="mb-3" style="display:none;">
                	<label for="roleName" class="form-check-lavel">권한설정</label>
					<div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" name="roleName" id="roleName1" value="ROLE_USER" checked />
							<label class="form-check-label">사용자</label>
						</div>
						<div class="form-check form-check-inline">
							<input type="radio" class="form-check-input" name="roleName" id="roleName2" value="ROLE_ADMIN" onclick="return(false);"/>
							<label class="form-check-label">관리자</label>
						</div>
					</div>
                </div>
                <div class="text-center mt-5">
                	<button type="submit" id="registerBtn" class="btn btn-lg btn-outline-primary">회원가입</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
// 아이디 중복여부 및 유효성검사 기능
function registerCheck() {
	const id = document.getElementById("id").value;
	const idRegex = /^[a-z][a-z0-9]{2,11}$/;

    if (id.trim() === "") {
        alert("아이디를 입력해주세요");
    } else if (id.includes(" ")) {
        alert("아이디에 공백을 넣을 수 없습니다.");
    } else if (!idRegex.test(id)) {
		alert("아이디를 3~12자리 영문(소문자), 숫자로 입력하세요. 단, 시작은 영소문자만 가능하며, 숫자로만 이루어진 아이디는 사용할 수 없습니다.");
    } else {
		$.ajax ({
			type : "POST",
			url : "/user/checkUserId",
			data : {userId : id},
			success : function() {
				alert(id+"는 사용가능한 아이디입니다.");
			},
			error : function() {
				alert(id+"는 이미 사용중인 아이디입니다.");
			}
		})
	}
}

//비밀번호 일치 여부 확인
document.getElementById("registerBtn").addEventListener('click', function(){
	let password = document.getElementById("password").value;
	let passwordConfirm = document.getElementById("passwordConfirm").value;
	if (password != passwordConfirm) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	return true;
})

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