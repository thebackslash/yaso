
<!--  /**
 * @Author: Akhil
 * 
 */-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.css">

</head>
<body>
	<form action="update-question" method="get">
		<div class="container">
			
			<input type="hidden" name="questionId" value="${requestScope.questionId}" />
			
			<div class="form-group">
				<label for="uname">Content </label> 
				<input type="text" class="form-control" id="uname" name="content" value="${requestScope.content }"> 
			</div>
			
				<div class="form-group">
				<label for="password">Status</label> 
				<input type="text" class="form-control" id="password" name="status" value="${requestScope.status }"> 
			</div>
			
			
			 <button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</body>
</html>