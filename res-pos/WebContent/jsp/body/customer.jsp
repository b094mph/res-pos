<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/customer.js"></script>
</head>
<body>
<form:form method="post" action="addCustomer.html">
	<table>
		<tr>
			<td><form:label path="firstName">FirstName:</form:label></td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td><form:label path="lastName">lastName:</form:label></td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td><form:label path="phone1">Phone1:</form:label></td>
			<td><form:input path="phone1"/></td>
		</tr>
		<tr>
			<td><form:label path="phone2">Phone2:</form:label></td>
			<td><form:input path="phone2"/></td>
		</tr>
		<tr>
			<td><form:label path="ext">Extension:</form:label></td>
			<td><form:input path="ext"/></td>
		</tr>
		<tr>
			<td><form:label path="email">Email:</form:label></td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td><form:label path="note">Note:</form:label></td>
			<td><form:input path="note"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Submit"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>