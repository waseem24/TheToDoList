<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="templates/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="templates/head.jsp"></c:import>
</head>
<body>
	<div class="container">
	<c:import url="templates/navbar.jsp"></c:import>
		<div class="jumbotron">
			<h1>Hello, world!</h1>
			<p>This is a JumboTron Test</p>
			</div>
			
		</div>
		
	
</body>
<c:import url="templates/javascripts.jsp"></c:import>
<script>
  $(function () {
    $('#myTab a:first').tab('show')
  })
</script>
</html>