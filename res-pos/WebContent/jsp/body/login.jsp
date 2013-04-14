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
						<td><form:password path="agentPassword"/></td>
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