<!--  /**
 * @Author: Akhil
 * 
 */-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">

</head>
<body>
	<form action="create-question" method="get">
		<div class="container">
			
		   <input type = "hidden" name="userId" value="${requestScope.user }">
			
			<div class="form-group">
				<label for="uname">Content </label> 
				<input type="text" class="form-control" id="uname" name="content"> 
			</div>
			
				<div class="form-group">
				<label for="password">Status</label> 
				<input type="text" class="form-control" id="password" name="status"> 
			</div>
			
			
			 <button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</body>
</html>