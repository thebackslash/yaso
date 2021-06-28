<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login Form</title>

</head>
<body>
<header>
<%@ include file="../util/navbar.jsp"%>
</header>

<section class =" d-flex" style="height:100vh">
    <form action="login" method="post">
		<div class="container">

            <div class="form-group">
				<label for="uname">Email</label> 
				<input type="text" class="form-control" id="email" name="email" placeholder="Enter Name"> 
			</div>
			
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="password" class="form-control" id="password" name="password" placeholder="Enter Password"> 
			</div>
				
			<button type="submit" class="btn btn-primary">Submit</button>

		</div>
	</form>
</section>

</body>
</html>