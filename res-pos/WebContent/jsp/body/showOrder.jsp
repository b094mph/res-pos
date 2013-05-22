<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input id="orderListSize" type="hidden" value="${orderListSize}">

<fieldset>
<legend>Order</legend>
		<div class="scroll">
			<table class="table table-striped table-hover table-condensed">
				<thead id="theadOrder">
					<tr>
						<th>Qty</th>
						<th>Size</th>
						<th>Name</th>
						<th>Unit</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody id="tbodyOrder">
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
				</tbody>
			</table>
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
						<td><b>$ ${subTotal}</b></td>
					</tr>
					<tr>
						<td>
							<button id="small" class="btn btn-info btn2">Small</button>
							<button id="large" class="btn btn-info btn2">Large</button>
							<button id="lunch" class="btn btn-info btn2">Lunch</button>
							<button id="combo" class="btn btn-info btn2">Combo</button>
						</td>
						<td><b>Tax ${salesTax} %</b></td>
						<td><b>$ ${tax}</b></td>
					</tr>
					<tr>
						<td>
							<button id="void" class="btn btn-danger btn2">Void</button>
							<button id="send" class="btn btn-success btn2">Send</button>
						</td>
						<td><b>Grand Total:</b></td>
						<td><b>$ ${grandTotal}</b></td>
					</tr>
			</table>
</fieldset>

<script type="text/javascript" src="js/order.js"></script>