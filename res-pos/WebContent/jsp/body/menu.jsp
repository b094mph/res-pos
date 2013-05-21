<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<script type="text/javascript" src="js/menu.js"></script>
<script>
	var foodCategoriesSize = '<c:out value="${foodCategoriesSize}"></c:out>';
	$(document).ready(function(){
		$('#screenHeight').css("height", SCREEN_HEIGHT);
	});
</script>

<div class="row">
	<div id="orderList" class="span6">
		<div id="orderListAjax">
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
				</table>
				</div>
				<table class="table table-striped table-hover table-condensed">
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><b>Sub Total:</b></td>
						<td><b>$ 0.00</b></td>
						<td></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><b>Tax:</b></td>
						<td><b>$ 0.00</b></td>
						<td></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td><b>Grand Total:</b></td>
						<td><b>$ 0.00</b></td>
						<td>
							<button id="void" class="btn btn-danger">Void</button>
							<button id="send" class="btn btn-success">Send</button>
						</td>
					</tr>
				</table>
				</div>
			</fieldset>
		</div>
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
		<div id="subcategory">
			<div id="subcategoryajax">
	
			</div>
		</div>
	</div>
</div>
