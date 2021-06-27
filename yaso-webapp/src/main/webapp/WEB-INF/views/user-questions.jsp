
<!--  /**
 * @Author: Akhil
 * 
 */-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sap"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Question by User</title>
</head>
<body>
	<h1>All Questions By user...</h1>
	<table>

		<thead>
			<tr>
				<th> Description</th>
				<th> Status</th>
				<th> Update</th>
				<th>Delete</th>
			<tr>
		</thead>
		<tbody>
			
			<sap:forEach items="${requestScope.questions}" var="question" >
				
				     <sap:url var="updateLink" value="load-question">
						
						<sap:param name="questionId" value="${question.id }" />
					
					</sap:url>
					
					 <sap:url var="deleteLink" value="delete-question">
						
						<sap:param name="questionId" value="${question.id }" />
					
					</sap:url>
				
				<tr>
					<td>${question.content }</td>
					<td>${question.status }</td>
					
					<td><a href="${updateLink}">Update</a> </td>
					  <td><a href="${deleteLink}">Delete</a> </td>

				</tr>
			</sap:forEach>
		
		</tbody>
	</table>
</body>
</html>

