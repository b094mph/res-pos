<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Address Information</title>
</head>
<body>
<h1>Enter Address Information</h1>
<form:form method="post" action="addAddress.html">
	<table>
		<tr>
			<td><form:label path="street1">Street1</form:label></td>
			<td><form:input path="street1"/></td>
		</tr>
		<tr>
			<td><form:label path="street2">Street2</form:label></td>
			<td><form:input path="street2"/></td>
		</tr>
		<tr>
			<td><form:label path="city">City</form:label></td>
			<td><form:input path="city"/></td>
		</tr>
		<tr>
			<td><form:label path="state">State</form:label></td>
			<td><form:input path="state"/></td>
		</tr>
		<tr>
			<td><form:label path="zipCode">Zip Code</form:label></td>
			<td><form:input path="zipCode"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Add Address"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>