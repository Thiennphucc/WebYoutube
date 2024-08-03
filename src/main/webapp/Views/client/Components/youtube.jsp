<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${video.title }</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<!-- Content -->
	<div class="container mt-4">
		<div class="row">
			<div class="col-md-8">
				<!-- Video Player -->
				<div class="embed-responsive embed-responsive-16by9">
					
					<iframe id="tm-video" 
						src="https://www.youtube.com/embed/${video.href }?si=r5AMshc9oIZQlus7"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

				</div>
				<!-- Video Title -->
				<h2 class="mt-2">${video.title }</h2>
				<!-- Video Description -->
				<p>${video.title }</p>
				
				
			</div>
			<div class="col-md-4">
				<!-- Sidebar -->
				<h3>Các video liên quan</h3>
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
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
