<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="../common/bootstrap.jsp"/>
	<jsp:include page="../common/jquery.jsp"/>
	<title>Restaurant_01</title>
</head>
<!-- http://localhost:8080/res-pos/index.jsp -->
<body>
<div class="container">
	<fieldset>
	<legend>Restaurant_01</legend>
		<div class="row">
			<div class="span4 offset3">
				<form class="form-horizontal" method="post" action="authenticateLogin.html">
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" id="username" name="userName" placeholder="Username">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="password" name="agentPassword" placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div> <!-- .row -->
	</fieldset>
</div> <!-- .container -->
</body>
</html>