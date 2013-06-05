<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<link rel="stylesheet" href="css/fixed-header.css">

<div class="row">
	<fieldset>
	<legend>Complete Menu: <c:out value="${restaurantName}"/></legend>
	<c:choose>
		<c:when test="${not empty menuList}">
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
						<sec:authorize ifAnyGranted="ROLE_ADMIN">
							<th>edit</th>
						</sec:authorize>
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
							<sec:authorize ifAnyGranted="ROLE_ADMIN">
								<td>
									<c:url var="editMenuUrl" value="editMenu.html?restaurantId=${restaurantId}&menuId=${menu.menuId}"/>
									<a href="${editMenuUrl}">edit</a>
								</td>
							</sec:authorize>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="alert alert-danger">
				<h3>No menu found.</h3>
			</div>
		</c:otherwise>
	</c:choose>
	</fieldset>
</div>

<script type="text/javascript" src="js/fixed-header.js"></script>
<script type="text/javascript">
	//make the header fixed on scroll
	$('.table-fixed-header').fixedHeader();
</script>