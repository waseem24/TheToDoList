<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="templates/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="templates/head.jsp"></c:import>
</head>
<body>
	<div class="container">
		<c:import url="templates/navbar.jsp"></c:import>
		<div class="jumbotron">
			<security:authorize
				ifAnyGranted="ROLE_LEAD_PROGRAMMER,ROLE_PROGRAMMER,ROLE_GROUP_LEADER,ROLE_GUEST">
				<h1>
					Hello,
					<security:authentication property="name" />
					!
				</h1>
				<security:authorize
					ifAnyGranted="ROLE_LEAD_PROGRAMMER,ROLE_PROGRAMMER,ROLE_GROUP_LEADER">
					<p>Below is the Top Five programmers of the week. If your name
						is not below, try harder! you can do it! :).</p>
				</security:authorize>
			</security:authorize>
			<p>
				<security:authentication property="name" />
			</p>
		</div>

	</div>
	<div>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Member</th>
					<th># of Tasks</th>
					<th># of Completed Tasks</th>
					<th># of Tasks Not Completed</th>
					<th># of Tasks To Be Completed</th>
					<th>% of Completed Tasks</th>
					<th>% Not Completed</th>
					<th>Group Performance</th>
				</tr>
			</thead>

			<tbody>
			<c:forEach items="${topFive}" var="tpm">
				<tr class="clickable_row" data-url="/showProfile/${tmp.member.name}">
					<td>${tpm.member.name}</td>
					<td>${tpm.noOfTasks}</td>
					<td>${tpm.completedTasks}</td>
					<td>${tpm.notCompletedTasks}</td>
					<td>${tpm.tasksToBeCompleted}</td>
					<td>${tpm.percentageCompletedTask}</td>
					<td>${tpm.percentageNotCompleted}</td>
					<td>${tpm.groupPerformance}</td>
				</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
</body>
<c:import url="templates/javascripts.jsp"></c:import>
<script>
$(document).ready(function(){
	 $(".clickable_row").click(function() {
         window.document.location = $(this).data('url');
   });
});
	
</script>
</html>