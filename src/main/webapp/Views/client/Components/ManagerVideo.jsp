<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<form action="" method="">
			<div class="form-group">
					<label>Id:</label> <input type="text" name="id"
						class="form-control" value="${video.id }" />
				</div>
				<div class="form-group">
					<label>Title</label> <input type="text" name="title"
						class="form-control" value="${video.title }" />
				</div>
				<div class="form-group">
					<label>Href:</label> <input type="text" name="href"
						class="form-control" value="${video.href }" />
				</div>

				<div class="form-group">
					<label for="fullname">Description:</label> <input type="text"
						name="description" class="form-control"
						value="${video.description }" />
				</div>

				<div class="form-group">
					<button class="btn btn-primary"
						formaction="${pageContext.request.contextPath }/testCRUD/create">Create</button>
					<button class="btn btn-warning" formaction="${pageContext.request.contextPath }/testCRUD/update">Update</button>
					<button class="btn btn-danger"
						formaction="${pageContext.request.contextPath }/testCRUD/delete?id=${video.href}">Delete</button>
					<button class="btn btn-info" formaction="">Reset</button>
				</div>
			</form>
		</div>


	</div>
	<div class="row">
		<div class="col">
			<table class="table table-stripe">
				<tr>
					<th>Title</th>
					<th>Href</th>
					<th>Description</th>

				</tr>
				<c:forEach items="${videos}" var="video">
					<tr>
						<td>${video.title}</td>
						<td>${video.href }</td>
						<td>${video.description }</td>

						<td><a
							href="${pageContext.request.contextPath }/testCRUD/edit?id=${video.href}">Edit</a>
							<a
							href="${pageContext.request.contextPath }/testCRUD/delete?id=${video.href}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</main>
