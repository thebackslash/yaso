<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Answer</title>

</head>
<body>
<header>

<%@ include file="../util/navbar.jsp"%>

</header>
<section class =" d-flex flex-column" style="min-height:100vh">
<div class = "container d-flex flex-column">
<h2> ${requestScope.answer.questionContent} </h2>
<small>By - ${requestScope.answer.questionAuthor} </small>
<form action="update-ans" class="d-flex flex-column" method="post">
<input type="hidden" name ="answerId" value = ${requestScope.answer.answerId}>
<textarea class="mt-2 form-control" name = "content" rows = "12"  >${requestScope.answer.answerContent} </textarea>
<div class = "d-flex mt-2 justify-content-center">
<button type = "submit" name="update" class="btn btn-success m-2">Update</button>

<button name="delete" class="btn btn-danger m-2">Delete</button>
 </div>
</form>


<div class="d-flex flex-row">
</div>
</div>
</section>
</body>
</html>