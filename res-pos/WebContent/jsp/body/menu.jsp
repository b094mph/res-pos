<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<script type="text/javascript" src="js/menu.js"></script>
<script>
	var foodCategoriesSize = '<c:out value="${foodCategoriesSize}"></c:out>';
</script>

<div class="row">
	<div class="span6">
	<fieldset>
	<legend>Customer Information</legend>
		<form method="get" action="addCustomer2.html">
			<table>
				<tr>
					<td>
						<input type="text" name="firstName" placeholder="First Name">
						<input type="text" name="lastName" placeholder="Last Name">
						<input type="text" name="phone1" placeholder="Phone 1">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="phone2" placeholder="Phone 2">
						<input type="text" name="ext" placeholder="Extention">
						<input type="text" name="email" placeholder="Email">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="street1" placeholder="<spring:message code="label.street1"/>">
						<input type="text" name="street2" placeholder="<spring:message code="label.street2"/>">
						<input type="text" name="city" placeholder="<spring:message code="label.city"/>">
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="state" placeholder="<spring:message code="label.state"/>">
						<input type="text" name="zipCode" placeholder="<spring:message code="label.zipCode"/>">
						<input type="text" name="note" placeholder="Note">
					</td>
				</tr>
				<tr>
					<td>
<!-- 						<button type="submit" class="btn">Add Customer</button> -->
					</td>
				</tr>
			</table>
		</form>
	</fieldset>
	</div>
	<div class="span6">
		<div id="category">
			<fieldset>
			<legend>Category</legend>
			<table>
				<% int count = 1; %>
				<c:forEach items="${foodCategories}" var="fc">
					<button id='fc_<%=count++%>'  
							type="button" 
							name="${fc.foodCategoryId}" 
							class="btn btn-info btn1"
							value='<c:out value="${fc.foodCategoryId}"></c:out>'
					>
						${fc.foodCategoryName}
					</button> 
				</c:forEach>
			</table>
			</fieldset>
		</div>
	</div>
</div>
<div class="row">
	<div id="orderList" class="span6">
		<div id="orderListAjax">
			<fieldset>
			<legend>Order</legend>
				<div id="screenHeight">
				<div class="scroll">
				<table class="table table-striped table-hover table-condensed">
					<tr>
						<th>&nbsp;</th>
						<th>Qty</th>
						<th>Size</th>
						<th>Name</th>
						<th>Unit</th>
						<th>Price</th>
					</tr>
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
						<td><b>$ 0.00</b></td>
					</tr>
					<tr>
						<td>
							<button id="small" class="btn btn-info btn2">Small</button>
							<button id="large" class="btn btn-info btn2">Large</button>
							<button id="lunch" class="btn btn-info btn2">Lunch</button>
							<button id="combo" class="btn btn-info btn2">Combo</button>
						</td>
						<td><b>Tax:</b></td>
						<td><b>$ 0.00</b></td>
					</tr>
					<tr>
						<td>
							<button id="new" class="btn btn-info btn2">New</button>
							<button id="void" class="btn btn-danger btn2">Void</button>
							<button id="send" class="btn btn-success btn2">Save</button>
							<button id="print" class="btn btn-success btn2">Print</button>
						</td>
						<td><b>Grand Total:</b></td>
						<td><b>$ 0.00</b></td>
					</tr>
				</table>
				</div>
			</fieldset>
		</div>
	</div>
	<div class="span6">
		<div id="subcategory">
			<div id="subcategoryajax">
	
			</div>
		</div>
	</div>
</div>

