<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input id="orderListSize" type="hidden" value="${orderListSize}">

<script type="text/javascript" src="js/order.js"></script>

<fieldset>
<legend>Order</legend>
	<table class="table table-striped table-hover">
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
				<td></td>
				<td>${orderdetail.menu.large}</td>
				<td>
					<button id="addQty_${pageScope.idx.index}" 
							class="btn btn-success" 
							value='${pageScope.idx.index}'>+</button>
				&nbsp;
					<button id="minusQty_${pageScope.idx.index}" 
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
</fieldset>