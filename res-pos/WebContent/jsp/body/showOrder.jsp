<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input id="orderListSize" type="hidden" value="${orderListSize}">

<script>
var screenHeight = screen.height;

$(document).ready(function(){
	$('#screenHeight').css("height", screenHeight);
});
</script>

<fieldset>
<legend>Order</legend>
	<div id="screenHeight">
		<div class="scroll">
			<table class="table table-striped table-hover table-condensed">
				<tr>
					<th>Qty</th>
					<th>Size</th>
					<th>Name</th>
					<th>Unit</th>
					<th>Price</th>
				</tr>
				<c:forEach items="${orderList}" var="orderdetail" varStatus="idx">
					<tr>
						<td>${orderdetail.quantity}</td>
						<td>L</td>
						<td>${orderdetail.menu.food.foodShortName}</td>
						<td>$ ${orderdetail.menu.large}</td>
						<td>$ ${orderdetail.price}</td>
						<td>
							<button id="increaseQty_${pageScope.idx.index}" 
									class="btn btn-success" 
									value='${pageScope.idx.index}'>+</button>
						&nbsp;
							<button id="decreaseQty_${pageScope.idx.index}" 
									class="btn btn-warning" 
									value='${pageScope.idx.index}'>-</button>
						&nbsp;
							<button id="deleteItem_${pageScope.idx.index}" 
									class="btn btn-danger" 
									value='${pageScope.idx.index}'>x</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
			<table class="table table-striped table-hover table-condensed">
					<tr class="padding">
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><b>Sub Total:</b></td>
						<td><b>$ ${subTotal}</b></td>
						<td></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><b>Tax ${salesTax} %</b></td>
						<td><b>$ ${tax}</b></td>
						<td></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><b>Grand Total:</b></td>
						<td><b>$ ${grandTotal}</b></td>
						<td>
							<button id="void" class="btn btn-danger">Void</button>
							<button id="send" class="btn btn-success">Send</button>
						</td>
					</tr>
			</table>
	</div>
</fieldset>

<script type="text/javascript" src="js/order.js"></script>