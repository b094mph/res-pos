<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/address.js"></script>
</head>
<body>
<fieldset>
<legend>Address</legend>
<table>
	<tr>
		<td>
			<div class="span4">
				<form method="post" action="addAddress.html">
					<table>
						<tr>
							<td><input type="text" name="street1" placeholder="<spring:message code="label.street1"/>"></td>
						</tr>
						<tr>
							<td><input type="text" name="street2" placeholder="<spring:message code="label.street2"/>"></td>
						</tr>
						<tr>
							<td><input type="text" name="city" placeholder="<spring:message code="label.city"/>"></td>
						</tr>
						<tr>
							<td><input type="text" name="state" placeholder="<spring:message code="label.state"/>"></td>
						</tr>
						<tr>
							<td><input type="text" name="zipCode" placeholder="<spring:message code="label.zipCode"/>"></td>
						</tr>
						<tr>
							<td><button type="submit"><spring:message code="label.addAddress"/></button></td>
						</tr>
					</table>
				</form>
			</div>
		</td>
		<td>
			<div id="showAddressList" class="span6">
				<fieldset>
				<legend>Address Information</legend>
					<table class="table table-striped table-hover">
						<tr>
							<th>Street1</th>
							<th>Street2</th>
							<th>City</th>
							<th>State</th>
							<th>Zip Code</th>
						</tr>
					<c:forEach items="${addressList}" var="address">
						<tr>
							<td>${address.street1}</td>
							<td>${address.street2}</td>
							<td>${address.city}</td>
							<td>${address.state}</td>
							<td>${address.zipCode}</td>
							<td><a href="delete/${address.addressId}">delete</a></td>
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