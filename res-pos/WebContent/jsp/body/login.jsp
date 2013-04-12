<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant_01</title>
</head>
<!-- http://localhost:8080/res-pos/index.jsp -->
<body>
	<p>RESTAURANT_01</p>
	<p>Login Page</p>
	<form:form method="post" action="address.html">
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
</body>
</html>