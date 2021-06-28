<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>question</title>

</head>
<body>
<header>
<%@ include file="../util/navbar.jsp"%>
</header>
<section class =" d-flex flex-column" style="min-height:100vh">
<div class="container d-flex flex-column mt-2">
<h3>${questionData.questionContent}</h3>
<small class = "ml-auto"> ${questionData.questionAuthor} </small>
<div class = "d-flex flex-column mt-2">
<sap:forEach items="${requestScope.questionData.answerContent}" var="answer" varStatus= "status">

<p class="mt-2"> ${answer} </p>
<small class = "ml-auto"> ${questionData.answerAuthor[status.index]} </small>

</sap:forEach>
</div>
</div>
<form class="container" action="add-answer" method="post">
<div class = "form-group">
<label for="add-answer">Add Your answer</label>
<input type="hidden" name="questionId" value = ${requestScope.id}>
<textarea name="content" class = "form-control" id="add-answer" rows="7" placeholder = "Enter your answer here"> </textarea>
</div>
<button type = "submit" class="btn btn-primary"> Submit </button>
</form>

</section>
</body>
</html>