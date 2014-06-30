<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="templates/taglibs.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<c:import url="templates/head.jsp"></c:import>
</head>
<body>
 <c:import url="templates/navbar.jsp"></c:import>
 
	
  <div class="container col-md-4">
<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="alert alert-info">${msg}</div>
		</c:if>
 
		<c:url value="/login" var="loginUrl"/>
      <form action="${loginUrl}" class="form-signin" role="form" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Username" required autofocus name="j_username">
        <input type="password" class="form-control" placeholder="Password" required name="j_password">
     <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
      </form>

    </div> <!-- /container -->
 
</body>
<c:import url="templates/javascripts.jsp"></c:import>
</html>