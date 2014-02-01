<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<input id="orderListSize" type="hidden" value="${orderListSize}">
<input id="welcomeJsp" type="hidden" value='<%=request.getContextPath()%>/menu.html'>
<input id="lastRow" type="hidden" value="${lastRow}">
<input id="rowIndex" type="hidden" value="${rowIndex}">

<link rel="stylesheet" href="css/fixed-table-header.css">
<style>
	.fixed-table .table-content{
	  display:block;
	  position: relative;
	  height: 475px;
	  overflow-y: auto;
	}
</style>

<fieldset>
<legend><spring:message code="label.order"/></legend>
	<div class="fixed-table">
		<div class="table-content">
			<table id="orderTable" class="table table-striped table-hover table-condensed table-fixed-header">
				<thead id="header" class="header">
					<tr>
						<th>&nbsp;</th>
						<th><spring:message code="label.order.qty"/></th>
						<th><spring:message code="label.order.size"/></th>
						<th><spring:message code="label.order.name"/></th>
						<th><spring:message code="label.order.unit"/></th>
						<th><spring:message code="label.order.price"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="orderdetail" varStatus="idx">
						<c:set var="foodCategoryName" value="${orderdetail.menu.foodCategory.foodCategoryName}"/>
						<tr>
							<td>	
								<button id="increaseQty_${pageScope.idx.index}"
										type="button"
										title="Increase quantity" 
										class="btn btn-success"
										<c:if test='${orderdetail.price == "0.00"}' >
											disabled="true"
										</c:if>	
										value='${pageScope.idx.index}'>+</button>
							&nbsp;
								<button id="decreaseQty_${pageScope.idx.index}"
										type="button"
										title="Decrease quantity" 
										class="btn btn-warning"
										<c:if test='${orderdetail.price == "0.00"}' >
											disabled="true"
										</c:if>	 
										value='${pageScope.idx.index}'>-</button>
							&nbsp;
								<button id="deleteItem_${pageScope.idx.index}"
										type="button"
										title="Remove Item" 
										class="btn btn-danger" 
										value='${pageScope.idx.index}'>x</button>								
							</td>
						<c:choose>
						<c:when test='${fn:startsWith(foodCategoryName, "Extra") == false}'>
							<td>${orderdetail.quantity}</td>
							<td id="size" >
								<c:choose>
									<c:when test="${lang == 'zh'}">
										<c:choose>
											<c:when test="${orderdetail.size == 'Sm'}">
												小
											</c:when>
											<c:when test="${orderdetail.size == 'Ln'}">
												午
											</c:when>
											<c:when test="${orderdetail.size == 'Cb'}">
												盒饭
											</c:when>
											<c:otherwise>
												大
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										${orderdetail.size}
									</c:otherwise>
								</c:choose>
							</td>
						</c:when>
						<c:otherwise>
							<td></td>
							<td></td>
						</c:otherwise>
						</c:choose>	
							<td id="item">
								<c:choose>
									<c:when test="${lang == 'zh'}">
										<c:choose>
										<c:when test="${not empty orderdetail.modifyTaste.modifyTasteCName}">
											* ${orderdetail.modifyTaste.modifyTasteCName}&nbsp;${orderdetail.menu.food.cFoodName}
										</c:when>
										<c:otherwise>
											${orderdetail.menu.food.cFoodName}
										</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<c:choose>
										<c:when test="${not empty orderdetail.modifyTaste.modifyTasteName}">
											* ${orderdetail.modifyTaste.modifyTasteName}&nbsp;${orderdetail.menu.food.foodShortName}
										</c:when>
										<c:otherwise>
											${orderdetail.menu.food.foodShortName}
										</c:otherwise>
										</c:choose>					
									</c:otherwise>
								</c:choose>
							</td>
							<td>$&nbsp;
								<c:choose>
									<c:when test="${orderdetail.size == 'Sm'}">
										${orderdetail.menu.small}
									</c:when>
									<c:when test="${orderdetail.size == 'Ln'}">
										${orderdetail.menu.lunch}
									</c:when>
									<c:when test="${orderdetail.size == 'Cb'}">
										${orderdetail.menu.combo}
									</c:when>
									<c:otherwise>
										${orderdetail.menu.large}
									</c:otherwise>
								</c:choose>
							</td>
							<td>$ ${orderdetail.price}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<table class="table table-striped table-hover table-condensed">
		<tr>
			<td>
				<button id="walkin" type="button" class="btn btn-info btn2">
					<spring:message code="label.walkin"/>
				</button>
				<button id="pickup" type="button" class="btn btn-info btn2">
					<spring:message code="label.pickup"/>
				</button>
				<button id="delivery" type="button" class="btn btn-info btn2">
					<spring:message code="label.delivery"/>
				</button>
				<button id="extras" type="button" disabled="disabled" class="btn btn-primary btn2">
					<spring:message code="label.extras"/>
				</button>
			</td>
			<td><b><spring:message code="label.sub.total"/>:</b></td>
			<td><b>$ <c:out value="${subTotal}"></c:out></b></td>
		</tr>
		<tr>
			<td>
				<button id="small" type="button" disabled="disabled" class="btn btn-info btn2">
					<spring:message code="label.small"/>
				</button>
				<button id="large" type="button" disabled="disabled" class="btn btn-info btn2">
					<spring:message code="label.large"/>
				</button>
				<button id="lunch" type="button" disabled="disabled" class="btn btn-info btn2">
					<spring:message code="label.lunch"/>
				</button>
				<button id="combo" type="button" disabled="disabled" class="btn btn-info btn2">
					<spring:message code="label.combo"/>
				</button>
			</td>
			<td><b><spring:message code="label.tax"/>&nbsp;${salesTax} %</b></td>
			<td><b>$&nbsp;<c:out value="${tax}"/></b></td>
		</tr>
		<tr>
			<td>
				<button id="new" type="reset" class="btn btn-info btn2" data-toggle="tooltip" data-placement="top">
					<spring:message code="label.new"/>
				</button>
				<button id="void" type="reset" class="btn btn-danger btn2" data-toggle="tooltip" data-placement="top" disabled="disabled">
					<spring:message code="label.void"/>
				</button>
				<button id="save" type="button" class="btn btn-success btn2" data-toggle="tooltip" data-placement="top" data-loading-text="Saving..." disabled="disabled">
					<spring:message code="label.save"/>
				</button>
				<button id="print" type="button" class="btn btn-success btn2" data-toggle="tooltip" data-placement="top" data-loading-text="Printing..." disabled="disabled">
					<spring:message code="label.print"/>
				</button>
			</td>
			<td><b><spring:message code="label.grand.total"/>:</b></td>
			<td><b>$&nbsp;<c:out value="${grandTotal}"/></b></td>
			</tr>
	</table>
</fieldset>

<jsp:include page="../modal/showOrder-modal.jsp"/>

<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script type="text/javascript" src="js/order.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var lang = "<c:out value='${lang}'/>";
	
	if(lang == 'zh'){
		$("thead[id='header']").css("font-size", "18px");
		$("td[id='size']").css("font-size", "18px");
		$("td[id='item']").css("font-size", "18px");
		$("#walkin").css("font-size", "20px");
		$("#pickup").css("font-size", "20px");
		$("#delivery").css("font-size", "20px");
		$("#eatin").css("font-size", "20px");
		$("#small").css("font-size", "20px");
		$("#large").css("font-size", "20px");
		$("#lunch").css("font-size", "20px");
		$("#combo").css("font-size", "20px");
		$("#extras").css("font-size", "20px");
		$("#new").css("font-size", "20px");
		$("#void").css("font-size", "20px");
		$("#save").css("font-size", "20px");
		$("#print").css("font-size", "20px");
	}
	
	determineAvailableFoodSize();
});

function determineAvailableFoodSize(){
	var rowIndex = $('#orderTable tbody tr.highlight').index();
	var sizes = [];
	<c:forEach items="${orderList}" var="orderdetail" varStatus="idx">
		var currentIndex = '<c:out value="${idx.index}"></c:out>';
		if(currentIndex == rowIndex){
			var small = '<c:out value="${orderdetail.menu.small}"></c:out>';
			sizes.push(small);
			var large = '<c:out value="${orderdetail.menu.large}"></c:out>';
			sizes.push(large);
			var lunch = '<c:out value="${orderdetail.menu.lunch}"></c:out>';
			sizes.push(lunch);
			var combo = '<c:out value="${orderdetail.menu.combo}"></c:out>';
			sizes.push(combo);
		}
	</c:forEach>

	if(sizes.length > 0){
		if(sizes[0] == '0.00')
			$('#small').attr("disabled", "disabled");
		else
			$('#small').removeAttr("disabled");
		if(sizes[1] == '0.00')
			$('#large').attr("disabled", "disabled");
		else
			$('#large').removeAttr("disabled");
		if(sizes[2] == '0.00')
			$('#lunch').attr("disabled", "disabled");
		else
			$('#lunch').removeAttr("disabled");
		if(sizes[3] == '0.00')
			$('#combo').attr("disabled", "disabled");
		else
			$('#combo').removeAttr("disabled");
	}
}
</script>
