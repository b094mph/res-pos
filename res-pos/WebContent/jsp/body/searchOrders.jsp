<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<input id="restaurantId" type="hidden" value='<c:out value="${restaurantId}"/>'>

<div class="row">
	<fieldset>
	<legend>Search Orders</legend>
	</fieldset>
</div>
<div class="row">
	<div id="searchOrder">

	</div>
</div>

<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script>
	$(document).ready(function(){	
		// make the header fixed on scroll
		$('.table-fixed-header').fixedHeader();

		viewOrdersDesc("2014-01-23");
	});

	function viewOrdersDesc(requestDate){
		var params = {restaurantId : $("#restaurantId").val(), 
				requestDate : requestDate};
		$.ajax({
			type: "GET",
			url: "viewOrdersDesc.json",
			data: params,
			success:
				function(data){
					$('#searchOrder').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful in order ajax...");
			}
		});
	}
</script>