<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/customer.js"></script>
</head>
<body>
<fieldset>
<legend>Enter Customer Information</legend>
	<table>
		<tr>
		<td>
		<div class="span4">
		<form:form method="post" action="addCustomer.html">
			<table>
				<tr>
					<td><form:label path="firstName">First Name:</form:label></td>
					<td><form:input path="firstName"/></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last Name:</form:label></td>
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
		</div>
		</td>
		<td>
			<div id="showCustomerList" class="span7">
				<fieldset>
				<legend>Customer Information</legend>
				<table class="table table-striped table-hover">
					<tr>
						<th>Last Name, First Name</th>
						<th>Phone 1</th>
						<th>Phone 2</th>
						<th>Ext</th>
						<th>Email</th>
						<th>Note</th>
					</tr>
					<c:forEach items="${customerList}" var="customer">
						<tr>
							<td>${customer.lastName}, ${customer.firstName}</td>
							<td>${customer.phone1}</td>
							<td>${customer.phone2}</td>
							<td>${customer.ext}</td>
							<td>${customer.email}</td>
							<td>${customer.note}</td> 
						</tr>
					</c:forEach>
				</table>
				</fieldset>
				</div>
			</td>
		</tr>
	</table>
</fieldset>
</body>
</html>