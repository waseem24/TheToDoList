<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="templates/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="templates/head.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="templates/navbar.jsp"></c:import>
	<div class="container">
	<form:form class="form-horizontal" commandName="member" enctype="multipart/form-data" action="saveMember">
		<fieldset>

			<!-- Form Name -->
			<legend >Member Details</legend>

			<!-- Prepended text-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">Name:</label>
				<div class="col-md-6">
					<form:input path="name" name="name" class="form-control" placeholder="Name" />
				
					
					<p class="help-block">help</p>
				</div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="username">Username:</label>
				<div class="col-md-6">
			
						<form:input path="Username" name="username" class="form-control" placeholder="Username" />
				
					<p class="help-block">help</p>
				</div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">E-Mail:</label>
				<div class="col-md-6">
					
					 <form:input path="email" name="email" class="form-control" placeholder="E-Mail" />
				
					<p class="help-block">help</p>
				</div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">Password:</label>
				<div class="col-md-6">
					
						<form:password path="password" name="password" class="form-control" placeholder="Password" />
			
					<p class="help-block">help</p>
				</div>
			</div>

			<!-- Prepended text-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="confirmPassword">Confirm Password</label>
				<div class="col-md-6">
				
					 <input
							id="confirmPassword" name="confirmPassword" class="form-control"
							placeholder="Confirm Password" type="password"
							required="required">
					
					<p class="help-block">help</p>
				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="image">Profile Image</label>
				<c:import url="templates/imagechooser.jsp"></c:import>

			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4">
					<button id="submit" name="submit" class="btn btn-info">Submit</button>
				</div>
			</div>

		</fieldset>
	</form:form>
</div>
</body>
<c:import url="templates/javascripts.jsp"></c:import>
</html>