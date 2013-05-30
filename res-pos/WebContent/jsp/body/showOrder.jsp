<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input id="orderListSize" type="hidden" value="${orderListSize}">
<input id="welcomeJsp" type="hidden" value='<%=request.getContextPath()%>/welcome.html'>

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
<legend>Order</legend>
	<div class="fixed-table">
		<div class="table-content">
			<table id="orderTable" class="table table-striped table-hover table-condensed table-fixed-header">
				<thead class="header">
					<tr>
						<th>&nbsp;</th>
						<th>Qty</th>
						<th>Size</th>
						<th>Name</th>
						<th>Unit</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="orderdetail" varStatus="idx">
						<tr>
							<td>	
								<button id="increaseQty_${pageScope.idx.index}"
										type="button"
										title="Increase quantity" 
										class="btn btn-success" 
										value='${pageScope.idx.index}'>+</button>
							&nbsp;
								<button id="decreaseQty_${pageScope.idx.index}"
										type="button"
										title="Decrease quantity" 
										class="btn btn-warning" 
										value='${pageScope.idx.index}'>-</button>
							&nbsp;
								<button id="deleteItem_${pageScope.idx.index}"
										type="button"
										title="Remove Item" 
										class="btn btn-danger" 
										value='${pageScope.idx.index}'>x</button>								
							</td>
							<td>${orderdetail.quantity}</td>
							<td>${orderdetail.size}</td>
							<td>${orderdetail.menu.food.foodShortName}</td>
							<td>$&nbsp;
								<c:choose>
									<c:when test="${orderdetail.size == 'Sm'}">
										${orderdetail.menu.small}
									</c:when>
									<c:when test="${orderdetail.size == 'Ln'}">
										${orderdetail.menu.lunch}
									</c:when>
									<c:when test="${orderdetail.size == 'Cm'}">
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
				<button id="walkin" type="button" class="btn btn-info btn2">Walk In</button>
				<button id="pickup" type="button" class="btn btn-info btn2">Pick Up</button>
				<button id="delivery" type="button" class="btn btn-info btn2">Delivery</button>
				<button id="eatin" type="button" class="btn btn-info btn2">Eat In</button>
			</td>
			<td><b>Sub Total:</b></td>
			<td><b>$ <c:out value="${subTotal}"></c:out></b></td>
		</tr>
		<tr>
			<td>
				<button id="small" type="button" class="btn btn-info btn2">Small</button>
				<button id="large" type="button" class="btn btn-info btn2">Large</button>
				<button id="lunch" type="button" class="btn btn-info btn2">Lunch</button>
				<button id="combo" type="button" class="btn btn-info btn2">Combo</button>
			</td>
			<td><b>Tax ${salesTax} %</b></td>
			<td><b>$ <c:out value="${tax}"></c:out></b></td>
		</tr>
		<tr>
			<td>
				<button id="new" type="reset" class="btn btn-info btn2" data-toggle="tooltip" data-placement="top">New</button>
				<button id="void" type="reset" class="btn btn-danger btn2" data-toggle="tooltip" data-placement="top">Void</button>
				<button id="save" type="button" class="btn btn-success btn2" data-toggle="tooltip" data-placement="top" data-loading-text="Saving...">Save</button>
				<button id="print" type="button" class="btn btn-success btn2" data-toggle="tooltip" data-placement="top" data-loading-text="Printing...">Print</button>
			</td>
			<td><b>Grand Total:</b></td>
			<td><b>$ <c:out value="${grandTotal}"></c:out></b></td>
			</tr>
	</table>
</fieldset>

<jsp:include page="../modal/showOrder-modal.jsp"/>

<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script type="text/javascript" src="js/order.js"></script>