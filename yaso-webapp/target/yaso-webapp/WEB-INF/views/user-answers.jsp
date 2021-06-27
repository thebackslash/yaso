<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>

</head>
<body>
<header>
<%@ include file="../util/navbar.jsp"%>
</header>
<section class =" d-flex flex-column" style="min-height:100vh">

<sap:forEach items="${requestScope.answers}" var="answer" varStatus="status" >

<form id="sendData${status.index}" method="post" action="answer">
    <input type="hidden" type= "text" name="answerId" id="inputVal" value="${answer.answerId}">
    <input type="hidden" type= "text" name="questionAuthor" id="inputVal" value="${answer.questionAuthor}">
    <input type="hidden" type= "text" name="answerAuthor" id="inputVal" value="${answer.answerAuthor}">
    <input type="hidden" type= "text" name="answerContent" id="inputVal" value="${answer.answerContent}">
    <input type="hidden" type= "text" name="questionContent" id="inputVal" value="${answer.questionContent}">
</form>

<a onclick=" document.getElementById('sendData${status.index}').submit();" style="text-decoration: none; color: black">
<div class ="d-flex flex-column container">

 <h3 class="mt-2">${answer.questionContent} </h3>
 <p> ${answer.answerContent} </p>
</div>
</a>
<hr>
</sap:forEach>

</section>
</body>
</html>