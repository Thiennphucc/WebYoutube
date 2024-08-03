<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>YouTube Grid Card Form</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
<!-- Custom CSS -->
<style>
/* Custom CSS */
.video-grid {
	position: relative;
}

.video-grid .btn-prev, .video-grid .btn-next {
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	z-index: 1;
}

.video-grid .btn-prev {
	left: 0;
}

.video-grid .btn-next {
	right: 0;
}
</style>
</head>
<body>


	<div class="container mt-4"></div>
	<h1 class="text-center ">Youtube Của Phúc</h1>
		<!-- Video Grid -->
		<div class="video-grid">
    <!-- Video Cards -->
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-3 mx-3 rounded overflow-hidden">
        <c:forEach items = "${videos }" var="video">
            <div class="col">
                <div class="card ">
                <img alt="" class="rounded " height="240px !important" src="http://img.youtube.com/vi/${video.href}/maxresdefault.jpg">
                                        <div class="card-body">
                        <h5 class="card-title">${video.title}</h5>
                        <p class="card-text">${video.description}</p>
                        <a href="<c:url value='/video?action=watch&id=${video.href }'/>" class="btn btn-primary">Watch</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- Next Button -->
</div>
	<div class="container">
    <div class="row justify-content-center">
        <ul class="nav tm-paging-links text-center d-flex justify-content-center">
        <c:forEach varStatus="i" begin="1" end="${maxPage }">
            <li class="nav-item " ><a href="GirdCardServlet?page=${i.index }" class="nav-link tm-paging-link ${currentPage == i.index ? 'active' : ''}" >${i.index}</a></li>
        </c:forEach>
         
        </ul>
    </div>
	</div>


	<!-- Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-Sx4e6r4WyzBIw0f0ofx/CqTCxCt6GG5bISzKa0fz+PLjhPy4eVrC7xRzHiDexLP1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-x5LhGx4g0SKwSWmtP14iak8OACQ7v3IjPT0Gl9AKFDK9KCmYZgIq1K4pFePM9RR/"
		crossorigin="anonymous"></script>
		
</body>
</html>
