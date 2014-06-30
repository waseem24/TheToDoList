<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="templates/head.jsp"></c:import>
</head>
<body>
	<c:import url="templates/navbar.jsp"></c:import>
	<br>
	<div class="container">

		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="#tables" data-toggle="tab">Groups</a></li>
			<li><a href="#table" data-toggle="tab">All Members</a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane fade in active" id="tables">
				<div class="panel-group" id="accordion">
				
					<%-- <c:forEach items="allGroups" var="group">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="# ${group.name}"> ${group.name } </a>
								</h4>
							</div>
							<div id="# ${group.name}" class="panel-collapse collapse">
								<table class="table">
									<thead>
										<tr>
											<th>Name</th>
											<th>Surname</th>
											<th>User Name</th>
											<th>E-Mail</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${group.member}" var="member">
										<tr>
											<td>${member.name}</td>
											<td>${member.surname}</td>
											<td>${member.username}</td>
											<td>${member.email}</td>
										</tr>
										</c:forEach>
									</tbody>
								</table>

							</div>

						</div>
					</c:forEach> --%>
				</div>

			</div>

		</div>

	</div>
	<div id="table" class="tab-pane fade">
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Surname</th>
						<th>User Name</th>
						<th>E-Mail</th>
						<th>Group</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="allMembers" var="member">
						<tr>
							<td>${member.name}</td>
							<td>${member.surname}</td>
							<td>${member.username}</td>
							<td>${member.email}</td>
							<td>${member.group.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
<c:import url="templates/javascripts.jsp"></c:import>
</html>