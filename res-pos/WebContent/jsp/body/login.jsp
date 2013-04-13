<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
	<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
	<title>Restaurant_01</title>
</head>
<!-- http://localhost:8080/res-pos/index.jsp -->
<body>
<div class="container">
	<div class="row">
		<div class="span4 offset4">
			<p>RESTAURANT_01</p>
			<p>Login Page</p>
			<form:form method="post" action="authenticateLogin.html">
				<table>
					<tr>
						<td><form:label path="userName">Agent:</form:label></td>
						<td><form:input path="userName"/></td>
					</tr>
					<tr>
						<td><form:label path="agentPassword">Password:</form:label> </td>
						<td><form:input path="agentPassword"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login"/></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div> <!-- .row -->
</div> <!-- .container -->
</body>
</html>