<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<input id="restaurantId" type="hidden" value='<c:out value="${restaurantId}"/>'>

<div class="row">
	<fieldset>
	<legend>Management Information</legend>
	</fieldset>
</div>
<div class="row">
	<input id="datepicker" type="text" name="datepicker" placeholder="<spring:message code="label.request.date"/>">
</div>
<div class="row">
	<ul class="nav nav-pills">
	  <li class="active"><a id="totalAllOrder">View All Orders</a></li>
	  <li><a id="totalWalkInOrder">View Orders By Walk-In</a></li>
	  <li><a id="totalPickUpOrder">View Orders By Pick Up</a></li>
	  <li><a id="totalDeliveryOrder">View Orders By Delivery</a></li>
	</ul>
</div>
<div class="row">
	<div id="viewTotalOrder">

	</div>
</div>

<style>
	div.ui-datepicker{
	 font-size:30px;
	}
</style>
<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script>
	$(document).ready(function(){	
		// make the header fixed on scroll
		$('.table-fixed-header').fixedHeader();

		$( "#datepicker" ).datepicker({
			  dateFormat: 'yy-mm-dd', 
		});

		var requestDate = null;

		$('#totalAllOrder').click(function(){
			requestDate = $("#datepicker").val();
			viewTotalOrder(null, requestDate);
		});

		$('#totalWalkInOrder').click(function(){
			requestDate = $("#datepicker").val();
			viewTotalOrder('Walk In', requestDate);
		});

		$('#totalPickUpOrder').click(function(){
			requestDate = $("#datepicker").val();
			viewTotalOrder('Pick Up', requestDate);
		});

		$('#totalDeliveryOrder').click(function(){
			requestDate = $("#datepicker").val();
			viewTotalOrder('Delivery', requestDate);
		});

		function viewTotalOrder(orderType, requestDate){
			var params = {restaurantId : $("#restaurantId").val(), 
					requestDate : requestDate, 
					orderType : orderType};
			$.ajax({
				type: "GET",
				url: "viewTotalOrder.json",
				data: params,
				success:
					function(data){
						$('#viewTotalOrder').html(data).show();
				},
				error:
					function(data){
						alert("unsuccessful in order ajax...");
				}
			});
		}

	});
</script>