<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
    <div class="container-fluid">
        <a href="/post/list" class="navbar-brand mb-0" style="font-size: 25px;">우리동네 커뮤니티</a>

		<ul class="navbar-nav">
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item"><a href="#" class="nav-link" style="font-size: 20px;">
				<sec:authentication property="principal.name"/>님</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item"><a href="/logout" class="nav-link" style="font-size: 20px;">로그아웃</a></li>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
          	  	<li class="nav-item"><a href="/login" class="nav-link" style="font-size: 20px;">로그인</a></li>
	            <li class="nav-item"><a href="/user/register" class="nav-link" style="font-size: 20px;">회원가입</a></li>
	        </sec:authorize>
            <li class="nav-item"><a href="#" class="nav-link" style="font-size: 20px;">문의하기</a></li>
        </ul>
    </div>
</nav>