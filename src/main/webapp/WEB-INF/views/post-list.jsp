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

<div class="container-fluid">

    <h3 style="text-align:center; margin-top: 30px;">전체 글</h3>
    <a href="form" class="btn btn-primary" style="margin-left: 10px; font-size: 17px;">게시글 등록</a>

    <hr style="height: 5px; background-color: black;">

    <div style="margin: 15px; font-weight:bold; display: flex;">
        <div style="flex: 1;">
            총 100개
        </div>
        <div style="display: flex; gap: 10px;">
            <form id="search" class="row g-3">
                <div class="col row-cols-sm-auto">
                    <select class="form-select form-select-xs" name="opt">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                </div>
                <div class="col row-cols-sm-auto">
                    <input type="text" class="form-control form-control-xs" style="width: 250px;">
                </div>
                <div class="col-auto">
                    <button type="button" class="btn" style="background-color:cornflowerblue; color:white; width:70px;" id="btn-search">검색</button>
                </div>
            </form>
        </div>
    </div>

    <div style="text-align: center;">
        <table class="table border-top" style="width: 98%; margin-left: auto; margin-right: auto;">
            <colgroup>
                <col width="3%">
                <col width="9%">
                <col width="*">
                <col width="10%">
                <col width="12%">
                <col width="7%">
                <col width="7%">
            </colgroup>
            <thead>
                <tr class="bg-light">
                    <th><input type="checkbox" id="checkbox-all-toggle"></th>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>추천수</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
            <c:choose>
            	<c:when test="${empty postDtoList }">
	                <tr>
	                    <td class="text-center" colspan="7"> 게시글 정보가 없습니다. </td>
	                </tr>
	            </c:when>
	            <c:otherwise>
		            <c:forEach items="${postDtoList}" var="post">
		                <tr>
		                    <td><input type="checkbox" id="checkbox-all-toggle"></td>
		                    <td>${post.postNo }</td>
		                    <td>${post.title }</td>
		                    <td>으아아아아</td>
		                    <td>${post.postCreatedDate }</td>
		                    <td>${post.suggestionCount }</td>
		                    <td>${post.readCount }</td>
		                </tr>
		            </c:forEach>
		        </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</body>
</html>