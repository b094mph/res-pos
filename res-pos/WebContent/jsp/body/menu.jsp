<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<input id="foodCategoryId" type="hidden" value='<c:out value="${foodCategoryId}"/>'>
<input id="isEdit" type="hidden" value="${isEdit}">
<input id="orderNum" type="hidden" value="${orderNum}">
<input id="orderType" type="hidden" value="${orderType}">

<link rel="stylesheet" href="css/fixed-table-header.css">

<jsp:include page="status.jsp"/>

<div class="row-fluid">
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
			
			</div>
		</div>
		<div class="span6">
			<div id="subcategory">
				<div id="subcategoryajax">
	
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script>
	var foodCategoryIDs = new Array();
	<c:forEach items="${foodCategories}" var="foodCategory">
		foodCategoryIDs.push("${foodCategory.foodCategoryId}");
	</c:forEach>
	
	$(document).ready(function(){	
		// make the header fixed on scroll
		$('.table-fixed-header').fixedHeader();
		  
		$.ajax({
			type: "GET",
			url: "showOrder.html",
			success:
				function(data){
					$('#orderListAjax').html(data).show();
			},
			error:
				function(data){
					alert("unsuccessful in order ajax...");
			}
		});
		  
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
		
		var array6 = [];
		<c:forEach items="${street1s}" var="street1">
			array6.push("${street1}");
		</c:forEach>
		
		$('#street1').typeahead({source: array6});
		
		var array7 = [];
		<c:forEach items="${street2s}" var="street2">
			array7.push("${street2}");
		</c:forEach>
		
		$('#street2').typeahead({source: array7});
		
		var array8 = [];
		<c:forEach items="${cities}" var="city">
			array8.push("${city}");
		</c:forEach>
		
		$('#city').typeahead({source: array8});
		
		var array9 = [];
		<c:forEach items="${states}" var="state">
			array9.push("${state}");
		</c:forEach>
		
		$('#state').typeahead({source: array9});
		
		var array10 = [];
		<c:forEach items="${zipCodes}" var="zipCode">
			array10.push("${zipCode}");
		</c:forEach>
		
		$('#zipCode').typeahead({source: array10});
	});
</script>

