<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<p>Enter Address Information</p>
<form:form method="post" action="addAddress.html">
	<table>
		<tr>
			<td><form:label path="street1"><spring:message code="label.street1"/></form:label></td>
			<td><form:input path="street1"/></td>
		</tr>
		<tr>
			<td><form:label path="street2"><spring:message code="label.street2"/></form:label></td>
			<td><form:input path="street2"/></td>
		</tr>
		<tr>
			<td><form:label path="city"><spring:message code="label.city"/></form:label></td>
			<td><form:input path="city"/></td>
		</tr>
		<tr>
			<td><form:label path="state"><spring:message code="label.state"/></form:label></td>
			<td><form:input path="state"/></td>
		</tr>
		<tr>
			<td><form:label path="zipCode"><spring:message code="label.zipCode"/></form:label></td>
			<td><form:input path="zipCode"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message code="label.addAddress"/>"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>