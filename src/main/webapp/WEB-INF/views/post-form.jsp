<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" >
    <title>우리동네 커뮤니티</title>
</head>
<body>
<%@ include file="common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<h4 class="border bg-light p-2">게시글 등록</h4>
	</div>
	<div class="row mb-3">
		<div class="col-12 border bg-light p-4">
			<form id="form-post" method="post" action="form" enctype="multipart/form-data">
				<div class="mb-3 mt-3">
					<label for="title" class="form-label">제목</label>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요">
				</div>
				<div class="mb-3">
					<label for="content" class="form-label">내용</label>
					<textarea class="form-control" id="content" name="content" rows="10" placeholder="내용을 입력하세요"></textarea>
				</div>
				<div class="mb-3">
				    <label for="attachedFile" class="form-label">첨부파일</label>
				    <input type="file" class="form-control" id="file" name="file" multiple>
				</div>
				<div class="text-center mt-5">
					<a href="list" class="btn btn-outline-secondary mx-1">목록</a>
					<button type="submit" class="btn btn-outline-primary mx-1" id="btnCreate">등록</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function() {
	$('#form-post').submit(function() {
		const title = $('#title').val().trim();
		const content = $('#content').val().trim();

		if(title == "") {
			alert("제목을 입력하세요");
			return false;
		}
		if(content == "") {
			alert("내용을 입력하세요");
			return false;
		}
		return true;
	});
})
</script>
</body>
</html>