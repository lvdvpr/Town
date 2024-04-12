<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
	<title>우리동네 커뮤니티</title>
</head>
<body>
<sec:authentication property="principal" var="loginUser" />
<%@ include file="common/navbar.jsp" %>
<div class="container">
	<div class="row mb-3">
		<h4 class="border bg-light p-2">게시글 상세</h4>
	</div>

	<div class="row mb-3">
		<table class="table table-bordered col-12 border bg-light p-4">
			<colgroup>
				<col width="15%">
				<col width="35%">
				<col width="15%">
				<col width="35%">
			</colgroup>
			<tbody>
				<tr>
					<th class="text-center bg-light">번 호</th>
					<td style="background-color:white;">${postDto.postNo }</td>
					<th class="text-center bg-light">작성일시</th>
					<td style="background-color:white;"><fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${postDto.postCreatedDate }"/></td>
				</tr>
				<tr>
					<th class="text-center bg-light">제 목</th>
					<td style="background-color:white;">${postDto.title }</td>
					<th class="text-center bg-light">추천수</th>
					<td style="background-color:white;">${postDto.suggestionCount }</td>
				</tr>
				<tr>
					<th class="text-center bg-light">작성자</th>
					<td style="background-color:white;">${postDto.name }</td>
					<th class="text-center bg-light">조회수</th>
					<td style="background-color:white;">${postDto.readCount }</td>
				</tr>
				<tr>
					<th class="text-center bg-light">내 용</th>
					<td colspan="3"><textarea rows="7" class="form-control border-0" disabled style="background-color:white;">${postDto.content }</textarea> </td>
				</tr>
				<tr>
					<th class="text-center bg-light">첨부파일</th>
					<td colspan="3" style="background-color:white;">
						<c:choose>
							<c:when test="${empty postFile }">
								등록된 첨부파일이 없습니다.
							</c:when>
							<c:otherwise>
								<c:forEach var="file" items="${postFile }">
									<a href="download?originalFileName=${file.originalFileName}" class="btn btn-outline-dark btn-sm">${file.originalFileName }<i class="bi bi-download ms-2"></i></a>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
		<div>
		<sec:authorize access="hasRole('USER')">
		<c:if test="${postDto.writerNo eq loginUser.userNo}">
			<span>
				<button class="btn btn-warning btn-xs" data-bs-toggle="modal" data-bs-target="#modal-form-posts">수정</button>
				<button onclick="deleteFn()" class="btn btn-danger btn-xs">삭제</button>
			</span>
		</c:if>
		</sec:authorize>

		<sec:authorize access="hasRole('ADMIN')">
		<c:if test="${postDto.writerNo eq loginUser.userNo}">
				<button class="btn btn-warning btn-xs" data-bs-toggle="modal" data-bs-target="#modal-form-posts">수정</button>
		</c:if>
		<c:choose>
			<c:when test="${postDto.postDeleted eq 'N' }">
				<button onclick="deleteFn()" class="btn btn-danger btn-xs">삭제</button>
			</c:when>
			<c:otherwise>
				<span class="text-danger">이미 삭제된 게시글입니다.</span>
			</c:otherwise>
		</c:choose>
		</sec:authorize>
			<span class='float-end'>
				<a href="addSuggestion.jsp?postNo=&empNo=" class="btn btn-outline-primary btn-xs">추천</a>
			</span>
		</div>
	</div>

		<div class="col-12 mb-1">
			<form method="post" action="addComment.jsp" onsubmit="return checkForm();">
				<!-- 게시글의 글 번호을 value에 설정 -->
				<input type="hidden" name="postNo" value=""/>
				<div class="row mt-5">
					<div class="col-12 mb-3">
						<span>0개의 댓글</span>
					</div>
					<div style="margin-top:3px; display: flex;">
						<input type="text" style="flex:15;" class="form-control" name="content" placeholder="댓글을 남겨주세요">
						<span style="width:30px;"></span>
						<button type="submit" class="btn btn-secondary btn-xs" style="flex:1;">댓글 등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">

const deleteFn = () => {
	const postNo = '${postDto.postNo}';
	location.href = "/post/delete?postNo=" + postNo;
}

</script>
</body>
</html>