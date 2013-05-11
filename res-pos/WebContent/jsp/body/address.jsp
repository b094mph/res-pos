<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/address.js"></script>
</head>
<body>
<fieldset>
<legend>Address</legend>
	<div class="row">
		<div class="span3">
			<form method="get" action="addAddress.html">
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
						<td><button type="submit" class="btn"><spring:message code="label.addAddress"/></button></td>
					</tr>
				</table>
			</form>
		</div>
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
						<sec:authorize ifAllGranted="ROLE_ADMIN">
							<td>
								<c:url var="deleteUrl" value="deleteAddress/${address.addressId}.html"/>
								<a href="${deleteUrl}">delete</a>
							</td>
						</sec:authorize>
					</tr>
				</c:forEach>
				</table>
			</fieldset>
		</div>
	</div>
</fieldset>
<br><br><br><br><br><br><br><br><br><br>
</body>
</html>