<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<link rel="stylesheet" href="css/fixed-table-header.css">

<jsp:include page="status.jsp"/>

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
		  
		var array = [];
		<c:forEach items="${phoneNumbers}" var="phoneNum">
			array.push("${phoneNum}");
		</c:forEach>	
		
		$('#phone1').typeahead({source: array});
		$('#phone2').typeahead({source: array});
		
		var array2 = [];
		<c:forEach items="${firstNames}" var="firstName">
			array2.push("${firstName}");
		</c:forEach>
		
		$('#firstName').typeahead({source: array2});
		
		var array3 = [];
		<c:forEach items="${lastNames}" var="lastName">
			array3.push("${lastName}");
		</c:forEach>
		
		$('#lastName').typeahead({source: array3});
		
		var array4 = [];
		<c:forEach items="${emails}" var="email">
			array4.push("${email}");
		</c:forEach>
		
		$('#email').typeahead({source: array4});
		
		var array5 = [];
		<c:forEach items="${notes}" var="note">
			array5.push("${note}");
		</c:forEach>
		
		$('#note').typeahead({source: array5});
	});
</script>

