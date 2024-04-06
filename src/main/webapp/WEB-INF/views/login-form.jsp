<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <title>로그인</title>
</head>
<body>
<c:set var="menu" value="login" />
<%@ include file="common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<h4 class="border bg-light p-2">로그인</h4>
	</div>
	<div class="row mb-3">
		<div class="col-12 border bg-light p-4">
			<form id="form-login" method="post" action="/loginProc">
				<div class="mb-3 mt-3">
					<label for="id" class="form-label">아이디</label>
					<input type="text" class="form-control" id="id" name="id" maxLength="12"/>
				</div>
				<div class="mb-3">
					<label for="password" class="form-label">비밀번호</label>
					<input type="password" class="form-control" id="password" name="password" maxLength="16"/>
				</div>
				<div class="text-center mt-5">
	 				<a href="/post/list" class="btn btn-outline-secondary mx-1">취소</a>
					<button type="submit" id="loginBtn" class="btn btn-outline-primary mx-1">로그인</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>