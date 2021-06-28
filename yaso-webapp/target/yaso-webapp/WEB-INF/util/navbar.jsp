<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="../css/common.css" >
</head>
<body>


     <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style=" width:100%">
        <a class="navbar-brand" href="#">JASO</a>

           <ul class="navbar-nav ml-auto" >
             <c:if test= "${ empty sessionScope}" >
               <li class="nav-item">
                              <a class="nav-link" href="login">login</a>
                              </li>
             </c:if>

             <c:if test= "${not empty sessionScope}" >
              <li class="nav-item ">
                <a class="nav-link" href="dashboard"> Dash Board </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="add-question">+</a>
              </li>

                   <li class="nav-item">
                      <a class="nav-link" href="logout">logout</a>
                        </li>
                        	</c:if>



            </ul>

      </nav>


</body>
</html>