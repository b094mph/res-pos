<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<link rel="stylesheet" href="css/fixed-table-header.css">
<div class="row">
	<div class="span2">
		<h6><b>AGENT:</b> <c:out value="${agentName}"/></h6>
	</div>
	<div class="span3">
		<h6><b>RESTAURANT:</b> <c:out value="${restaurantName}"/></h6>	
	</div>
	<div class="span2 offset5">
		<h6><%= new java.util.Date() %></h6>
	</div>
</div>
<div class="row">
	<div class="span6">
		<jsp:include page="customerInfo.jsp"/>
	</div>
	<div class="span6">
		<div id="category">
			<jsp:include page="category.jsp"/>
		</div>
	</div>
</div>
<div class="row">
	<div id="orderList" class="span6">
		<div id="orderListAjax">
			<jsp:include page="showOrder.jsp"/>
		</div>
	</div>
	<div class="span6">
		<div id="subcategory">
			<div id="subcategoryajax">
	
			</div>
		</div>
	</div>
</div>


<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script>
	var foodCategoriesSize = '<c:out value="${foodCategoriesSize}"></c:out>';
	
	$(document).ready(function(){	
		  // make the header fixed on scroll
		  $('.table-fixed-header').fixedHeader();
	});
</script>

