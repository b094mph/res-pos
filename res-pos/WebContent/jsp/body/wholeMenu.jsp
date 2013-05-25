<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="css/fixed-table-header.css">

<div class="row">
	<fieldset>
	<legend>Restaurant Menu </legend>
	<div class="fixed-table">
		<div class="table-content">
			<table class="table table-striped table-hover table-fixed-header">
				<thead class="header">
					<tr>
						<th>#</th>
						<th>Category</th>
						<th>Category Chinese</th>
						<th>Food English</th>
						<th>Food Chinese</th>
						<th>Description</th>
						<th>Small</th>
						<th>Large</th>
						<th>Lunch</th>
						<th>Combo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${menuList}" var="menu">
						<tr>
							<td>${menu.menuNum}</td>
							<td>${menu.foodCategory.foodCategoryName}</td>
							<td>${menu.foodCategory.foodCategoryCName}</td>
							<td>${menu.food.foodShortName}</td>
							<td>${menu.food.cFoodName}</td>
							<td>${menu.food.description}</td>
							<td>${menu.small}</td>
							<td>${menu.large}</td>
							<td>${menu.lunch}</td>
							<td>${menu.combo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</fieldset>
</div>

<script type="text/javascript" src="js/fixed-table-header.js"></script>
<script type="text/javascript">
	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();
</script>