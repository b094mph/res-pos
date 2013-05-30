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
	<legend>Customer</legend>
	</fieldset>
</div>
<div class="row">
	<div class="span3">
		<form method="get" action="addCustomer.html">
			<table>
				<tr><td><input type="text" name="firstName" placeholder="First Name"></td></tr>
				<tr><td><input type="text" name="lastName" placeholder="Last Name"></td></tr>
				<tr><td><input type="text" name="phone1" placeholder="Phone 1"></td></tr>
				<tr><td><input type="text" name="phone2" placeholder="Phone 2"></td></tr>
				<tr><td><input type="text" name="ext" placeholder="Extention"></td></tr>
				<tr><td><input type="text" name="email" placeholder="Email"></td></tr>
				<tr><td><input type="text" name="note" placeholder="Note"></td></tr>
				<tr><td><button type="submit" class="btn">Add Customer</button></td></tr>
			</table>
		</form>
	</div>
	<div id="showCustomerList" class="span7">
		<fieldset>
		<legend>Customer Information</legend>
			<div class="fixed-table">
				<div class="table-content">
					<table class="table table-striped table-hover table-fixed-header">
						<thead class="header">
						<tr>
							<th>Last Name, First Name</th>
							<th>Phone 1</th>
							<th>Phone 2</th>
							<th>Ext</th>
							<th>Email</th>
							<th>Note</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach items="${customerList}" var="customer">
								<tr>
									<td>
										<c:choose>
											<c:when test="${not empty customer.lastName && customer.firstName}">
												${customer.lastName}, ${customer.firstName}
											</c:when>
											<c:when test="${not empty customer.lastName}">
												${customer.lastName}
											</c:when>
											<c:when test="${not empty customer.firstName}">
												${customer.firstName}
											</c:when>
										</c:choose>
									</td>
									<td>${customer.phone1}</td>
									<td>${customer.phone2}</td>
									<td>${customer.ext}</td>
									<td>${customer.email}</td>
									<td>${customer.note}</td> 
									<sec:authorize ifAllGranted="ROLE_ADMIN">
										<td>
											<c:url var="deleteUrl" value="deleteCustomer/${customer.personId}.html"/>							
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
<br><br><br><br><br>

<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script type="text/javascript">
	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();
</script>