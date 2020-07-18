<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link href="WebContent/WEB-INF/views/checkbox.css" rel="stylesheet"
	type="text/css" />
<link href="WebContent/WEB-INF/checkbox.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath}/resources/css/checkbox.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Edit Book</title>
</head>
<body>

	<div align="center">
		<h2>Edit Book</h2>
		<form:form action="save" onSubmit=" return validateForm();" method="post" modelAttribute="theBook">
			<table cellpadding="5" cellspacing="10">
				<tr>
					<td>ID:</td>
					<td>${theBook.id}<form:hidden path="id" />
					</td>
				</tr>
				<tr>
					<td>Title:</td>
					<td><form:input id="txtTitle" path="title" class="form-control" /></td>
				</tr>
				<tr>
					<td>Author:</td>
					<td><form:input id="txtAuthor" path="author" class="form-control" /></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><form:select path="category" id="selectCategory" class="form-control">
							<form:option class="form-control" value="null" label="Choose.." />
							<form:option class="form-control" value="Fiction" label="Fiction" />
							<form:option class="form-control" value="Fantasy" label="Fantasy" />
							<form:option class="form-control" value="Short Stories"
								label="Short Stories" />
							<form:option class="form-control" value="Mysetery"
								label="Mysetery" />
							<form:option class="form-control" value="Horror" label="Horror" />
							<form:option class="form-control" value="Poetry" label="Poetry" />
						</form:select></td>
					<%-- <td><form:input path="category" /></td> --%>
				</tr>
				<tr>
					<td><label class="containerCheck">Available <form:checkbox
								path="availability" /> <span class="checkmark"></span>
					</label></td>
				</tr>
				<tr>
					<td colspan="2"><button class="btn btn-success" type="submit">Save</button></td>
					<td>
						<div style="margin: 15px">
							<button type="button" class="btn btn-warning"
								onclick="window.location.href='list';">Back</button>
						</div>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
<script type="text/javascript">

	function validateForm(){
		var author=document.getElementById("txtAuthor").value
		var title=document.getElementById("txtTitle").value
		var category=document.getElementById("selectCategory").value

		if(title.length<1){
			alert("title cannot be empty");
			return false;
		}
		if(author.length<1){
			alert("author cannot be empty");
			return false;
		}
		if(category==="null"){
			alert("Please choose a category");
			return false;
		}
		return true;
	}
</script>
</html>