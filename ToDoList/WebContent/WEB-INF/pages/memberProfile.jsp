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
		<div class="row clearfix">
			<div class="col-md-8 column">
				<div class="tabbable" id="tabs-375055">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-1" data-toggle="tab">Section
								1</a></li>
						<li><a href="#panel-2" data-toggle="tab">Section 2</a></li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane active" id="panel-1">
							<form:form modelAttribute="memberProfile">
								<table>
									<thead>
										<tr>
											<th><br></th>
											<th></th>
										</tr>
									</thead>

									<tr>
										<td><form:label path="username">Username: </form:label></td>
										<td><form:input path="username" readonly="true" /></td>
									</tr>

									<tr>
										<td><form:label path="name">Name: </form:label></td>
										<td><form:input path="name" /></td>
									</tr>

									<tr>
										<td><form:label path="surname">Surname: </form:label></td>
										<td><form:input path="surname" /></td>
									</tr>

									<tr>
										<td><form:label path="email">Email: </form:label></td>
										<td><form:input path="email" /></td>
									</tr>

									<tr>
										<td><form:label path="status">Status: </form:label></td>
										<td><form:input path="status" /></td>
									</tr>

								</table>
							</form:form>
						</div>

						<div class="tab-pane" id="panel-2">
							<br>
							<form:form modelAttribute="memberPerformance">
								<table>

									<tr>
										<td><form:label path="performanceId">Performance Id: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="noOfTasks">Number of Tasks: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="completedTasks">Completed Tasks: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="notCompletedTasks">Incomplete Tasks: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="tasksToBeCompleted">Tasks Remaining: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="percentageCompletedTask">Completed Tasks %: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="percentageNotCompleted">Incomplete Tasks %: </form:label></td>
										<td></td>
									</tr>

									<tr>
										<td><form:label path="groupPerformance">Group Performance: </form:label></td>
										<td></td>
									</tr>

								</table>
							</form:form>
						</div>

					</div>
					<div class="col-md-2 column">
						<img alt="140x140" src="http://lorempixel.com/140/140/"
							class="img-thumbnail" />
					</div>
				</div>
			</div>
</body>
<c:import url="templates/javascripts.jsp"></c:import>
</html>