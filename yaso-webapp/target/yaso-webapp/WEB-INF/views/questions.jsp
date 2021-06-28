<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>questions</title>

</head>
<body>
<header>
<%@ include file="../util/navbar.jsp"%>
</header>
<section class =" d-flex flex-column" style="min-height:100vh">

<sap:forEach items="${requestScope.questions}" var="question" varStatus="status" >


<a href="question?id=${question.id}" style="text-decoration: none; color: black">
<div class ="d-flex flex-column container">

 <h3 class="mt-2">${question.content} </h3>
<hr>
</div>

</a>

</sap:forEach>

</section>
</body>
</html>