<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link rel="stylesheet" href="css/fixed-header.css">
<div>
	<c:choose>
		<c:when test="${not empty orderList}">
			<table class="table table-striped table-hover table-fixed-header">
				<thead class="header">
					<tr>
						<th>Order #</th>
						<th>Name</th>
						<th>Street 1</th>
						<th>Street 2</th>
						<th>City</th>
						<th>Phone</th>
						<th>Order Type</th>
						<th>Order Time</th>
						<th>Sub Total</th>
						<th>Tax</th>
						<th>Grand Total</th>
						<th>Agent</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="list">
						<tr>
							<td>${list.customerOrderId}</td>
							<td>${list.customer.firstName} ${list.customer.lastName}</td>
							<td>${list.customer.address.street1}</td>
							<td>${list.customer.address.street2}</td>
							<td>${list.customer.address.city}</td>
							<td>${list.customer.phone1}</td>
							<td>${list.orderOption}</td>
							<td>${list.orderTime}</td>
							<td>$ ${list.subTotal}</td>
							<td>$ ${list.tax}</td>
							<td>$ ${list.grandTotal}</td>
							<td>${list.username}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger">
				<h3>No Orders found.</h3>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<div class="pull-right">
	<h2>Total: $ ${total}</h2> 
</div>
<script type="text/javascript" src="js/fixed-header.js"></script>
<script type="text/javascript">
	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();
</script>