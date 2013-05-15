<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
					<c:url var="deleteItem" value="deleteItem/${pageScope.idx.index}.html"/>
					<a href="${deleteItem}">x</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</fieldset>