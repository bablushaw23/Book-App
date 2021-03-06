<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath}/resources/css/checkbox.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Search Result</title>
</head>
<body>
	<div align="center">
		<h2>Search result</h2>

		<div style="float: left; margin: 15px">
			<button type="button" class="btn btn-warning"
				onclick="window.location.href='list';">Back</button>
		</div>
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Category</th>
				<th>Availability</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${result}" var="book">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.category}</td>
					<td>${book.availability?"YES":"NO"}</td>
					<td>
						<button type="button" class="btn btn-info"
							onclick="window.location.href='edit?id=${book.id}';">Edit</button>
						<button type="button" class="btn btn-secondary"
							onclick="if( !confirm('Sure to delete ${book.id}?')) return false; window.location.href='delete?id=${book.id}'";">Delete</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>