<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input id="orderListSize" type="hidden" value="${orderListSize}">

<link rel="stylesheet" href="css/fixed-table-header.css">

<fieldset>
<legend>Order</legend>
	<div class="fixed-table">
		<div class="table-content">
			<table class="table table-striped table-hover table-condensed table-fixed-header">
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
										title="Increase quantity" 
										class="btn btn-success" 
										value='${pageScope.idx.index}'>+</button>
							&nbsp;
								<button id="decreaseQty_${pageScope.idx.index}"
										title="Decrease quantity" 
										class="btn btn-warning" 
										value='${pageScope.idx.index}'>-</button>
							&nbsp;
								<button id="deleteItem_${pageScope.idx.index}"
										title="Remove Item" 
										class="btn btn-danger" 
										value='${pageScope.idx.index}'>x</button>								
							</td>
							<td>${orderdetail.quantity}</td>
							<td>L</td>
							<td>${orderdetail.menu.food.foodShortName}</td>
							<td>$ ${orderdetail.menu.large}</td>
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
				<button id="walkin" class="btn btn-info btn2">Walk In</button>
				<button id="pickup" class="btn btn-info btn2">Pick Up</button>
				<button id="delivery" class="btn btn-info btn2">Delivery</button>
				<button id="eatin" class="btn btn-info btn2">Eat In</button>
			</td>
			<td><b>Sub Total:</b></td>
			<td><b>$ <c:out value="${subTotal}"></c:out></b></td>
		</tr>
		<tr>
			<td>
				<button id="small" class="btn btn-info btn2">Small</button>
				<button id="large" class="btn btn-info btn2">Large</button>
				<button id="lunch" class="btn btn-info btn2">Lunch</button>
				<button id="combo" class="btn btn-info btn2">Combo</button>
			</td>
			<td><b>Tax ${salesTax} %</b></td>
			<td><b>$ <c:out value="${tax}"></c:out></b></td>
		</tr>
		<tr>
			<td>
				<button id="new" type="reset" class="btn btn-info btn2" data-toggle="tooltip" data-placement="top">New</button>
				<button id="void" class="btn btn-danger btn2" data-toggle="tooltip" data-placement="top">Void</button>
				<button id="save" class="btn btn-success btn2" data-toggle="tooltip" data-placement="top">Save</button>
				<button id="print" class="btn btn-success btn2" data-toggle="tooltip" data-placement="top">Print</button>
			</td>
			<td><b>Grand Total:</b></td>
			<td><b>$ <c:out value="${grandTotal}"></c:out></b></td>
			</tr>
	</table>
</fieldset>


<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script type="text/javascript" src="js/order.js"></script>