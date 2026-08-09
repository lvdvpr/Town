<%-- 모달창 --%>
<div class="black-bg">
    <div class="white-bg">
        <h4>문의하기</h4>
        <h6>문의전화 : 7777-7777</h6>
        <div class="text-end mt-3">
            <button class="btn btn-danger" id="close">닫기</button>
        </div>
    </div>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
    <div class="container-fluid">
        <a href="/post/list" class="navbar-brand mb-0" style="font-size: 25px;">우리동네 커뮤니티</a>
        <ul class="navbar-nav">
            <li class="nav-item"><a href="/post/list" class="nav-link" style="font-size: 20px;">게시판</a></li>
            <li class="nav-item"><a href="#" class="nav-link" style="font-size: 20px;">공지사항</a></li>
        </ul>
        <ul class="navbar-nav">
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item"><a href="#" class="nav-link" style="font-size: 20px;">
                    <sec:authentication property="principal.name"/>님</a></li>
                <li class="nav-item"><a href="/logout" class="nav-link" style="font-size: 20px;">로그아웃</a></li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item"><a href="/login" class="nav-link" style="font-size: 20px;">로그인</a></li>
                <li class="nav-item"><a href="/user/register" class="nav-link" style="font-size: 20px;">회원가입</a></li>
            </sec:authorize>
            <li class="nav-item" id="qa"><a href="#" class="nav-link" style="font-size: 20px;">문의하기</a></li>
        </ul>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
    $('#qa').on('click',function(){
        $('.black-bg').addClass('show-modal')
    })

    $('#close').on('click', function(){
        $('.black-bg').removeClass('show-modal')
    })
</script>