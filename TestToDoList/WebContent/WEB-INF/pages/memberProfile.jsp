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
							<table>
								<thead>
									<tr>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tr>
									<td>dummy data</td>
									<td>This is dummy data until populated</td>
								</tr>

							</table>
						</div>
						<div class="tab-pane" id="panel-2">
							<table>
								<thead>
									<tr>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tr>
									<td>Performance dummy data</td>
									<td>This is performance dummy data until populated</td>
								</tr>

							</table>
						</div>
					</div>
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