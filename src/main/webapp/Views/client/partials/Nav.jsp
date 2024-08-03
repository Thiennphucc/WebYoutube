<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-white py-3">
	<div class="container px-5">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/index"><span
			class="fw-bolder text-primary">Administration Tool</span></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0 small fw-bolder">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index">Welcome!${sessionScope.currentUser.username}</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/GirdCardServlet">Videos</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/UserServlet">Users</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/testCRUD">ManagerVideos</a></li>
				<li class="dropdown nav-item"><span
					class=" dropdown-toggle nav-link" data-bs-toggle="dropdown">Account
						</span>	
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="${pageContext.request.contextPath}/RegisterServlet">Register</a></li>
						<li><a class="dropdown-item" href="${pageContext.request.contextPath}/LoginServlet">Login
								</a></li>
						<li><a class="dropdown-item" href="${pageContext.request.contextPath}/ForgotPassServlet">Forgot Password</a></li>
						<li><a class="dropdown-item" href="/_Assignment/inforaccoutn">Information</a></li>
						<li><a class="dropdown-item" href="${pageContext.request.contextPath}/ChangePassServlet">Change Password</a></li>
						<li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a></li>


						<hr />
						<li><a class="dropdown-item" href="${pageContext.request.contextPath}/history">History</a></li>

					</ul></li>
			</ul>
		</div>
	</div>
</nav>