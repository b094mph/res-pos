<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="stylesheet" href="css/fixed-table-header.css">
<style>
	.fixed-table .table-content{
	  display:block;
	  position: relative;
	  height: 870px;
	  overflow-y: auto;
	}
</style>

<div class="row">
	<fieldset>
	<legend>Address</legend>
	</fieldset>
</div>
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
			<div class="fixed-table">
				<div class="table-content">
				<table class="table table-striped table-hover table-fixed-header">
					<thead class="header">
						<tr>
							<th>Street1</th>
							<th>Street2</th>
							<th>City</th>
							<th>State</th>
							<th>Zip Code</th>
							<sec:authorize ifAllGranted="ROLE_ADMIN">
								<th>delete</th>
							</sec:authorize>
						</tr>
					</thead>
					<tbody>
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
					</tbody>
				</table>
				</div>
			</div>
		</fieldset>
	</div>	
</div>

<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script type="text/javascript">
	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();
</script>