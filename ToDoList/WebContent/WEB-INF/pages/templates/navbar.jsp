<%@include file="taglibs.jsp" %>
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">Home</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Link</a></li>
						<li><a href="otherPage">Other Page</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Manage Members <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">View Members</a></li>
								<li><a href="sendMessage">Send Message To Member</a></li>
								<li class="divider"></li>
								<li><a href="addMember">Add Member</a></li>
								<li><a href="#">Delete Member</a></li>
							</ul></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Manage Tasks <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="fgh">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search Member">
						</div>
						<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href='<c:url value="/login"></c:url>' >Sign in</a></li>
						<security:authorize ifAnyGranted="ROLE_LEAD_PROGRAMMER,ROLE_GROUP_LEADER,ROLE_PROGRAMMER"><li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Profile<b class="caret"></b></a>
							<ul class="dropdown-menu">
							
								<li><a href="showProfile/<security:authentication property="name"/>">View Profile</a></li>
								<li class="divider"></li>
								<li><a href='<c:url value="/login?logout"></c:url>' >Log Out</a></li>
							</ul></li></security:authorize>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
