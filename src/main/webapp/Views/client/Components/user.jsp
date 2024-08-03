<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<base href="/Java4-Lab5/">
<title>Them sua xoa User</title>
</head>
<body>
	<main class="container">
		<div class="row">
			<div class="col">
				<c:if test="${not empty message}">
					<div class="alert alert-success">${message }</div>
				</c:if>
				<c:if test="${not empty error}">
					<div class="alert alert-danger">${error }</div>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<form action="/UserServlet" method="GET">
					<input type="hidden" name="id" class="form-control"
						value="${user.id}" />	
					<div class="form-group">
						<label for="userId">Username:</label> <input type="text"
							name="username" class="form-control" value="${user.username }" />
					</div>

					<div class="form-group">
						<label for="fullname">Password:</label> <input type="text"
							name="password" class="form-control" value="${user.password }" />
					</div>
					<div class="form-group">
						<label for="email">Email Address:</label> <input type="email"
							name="email" class="form-control" value="${user.email }" />
					</div>
					<div class="form-group">
						<label>Role:</label> <label class="ml-5"><input
							type="radio" class="form-check-input" id="admin" name="admin"
							value="true" ${user.isAdmin? 'checked':'' } />Admin</label> <label
							class="ml-5"><input type="radio" class="form-check-input"
							id="user" name="admin" value="false"
							${!user.isAdmin? 'checked':'' } />user</label>
					</div>
					<div class="form-group">
						<button class="btn btn-primary"
							formaction="${pageContext.request.contextPath }/UserServlet/create">Create</button>
						<button class="btn btn-warning"
							formaction="${pageContext.request.contextPath }/UserServlet/update">Update</button>
						<button class="btn btn-danger"
							formaction="${pageContext.request.contextPath }/UserServlet/delete?id=${item.username }">Delete</button>
						<button class="btn btn-info"
							formaction="${pageContext.request.contextPath }/UserServlet/reset">Reset</button>
					</div>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-stripe">
					<tr>
						<th>User ID</th>
						<th>Username</th>
						<th>Emaill</th>
						<th>Role</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach var="item" items="${users }">
						<tr>
							<td>${item.id }</td>
							<td>${item.username }</td>
							<td>${item.email }</td>
							<td>${item.isAdmin? 'Admin' : 'User' }</td>
							<td><a
								href="${pageContext.request.contextPath }/UserServlet/edit?id=${item.username }">Edit</a>
								<a
								href="${pageContext.request.contextPath }/UserServlet/delete?id=${item.username }">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>