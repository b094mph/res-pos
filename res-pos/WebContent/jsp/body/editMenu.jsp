<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<sec:authorize ifAnyGranted="ROLE_ADMIN">

<div class="row">
	<div class="span12">
	<fieldset>
	<legend>${restaurantName} / ${menu.foodCategory.foodCategoryName} / ${menu.food.foodShortName}</legend>
		<h3>Please enter new prices:</h3>
		<br>
		<form method="get" class="form-horizontal" action="saveMenu.html">
			<input type="hidden" name="menuid" value="${menu.menuId}">
			<div class="control-group">
				<div class="controls">
					<a id="back" type="button" class="btn btn-primary btn-large" href="wholeMenu.html">
						<spring:message code="label.back"/>
					</a>
					<button type="reset" class="btn btn-large" name="reset"><spring:message code="label.reset"/></button>
					<button type="submit" class="btn btn-success btn-large" name="submit"><spring:message code="label.save"/></button>
				</div>
			</div>
			<div class="control-group info">
				<label class="control-label" for="category">Category</label>
				<div class="controls">
					<input type="text" name="foodCategoryName" disabled value='<c:out value="${menu.foodCategory.foodCategoryName}"/>'>
				</div>
			</div>
			<div class="control-group info">
				<label class="control-label" for="categorych">Category Chinese</label>
				<div class="controls">
					<input type="text" name="foodCategoryCName" disabled value='<c:out value="${menu.foodCategory.foodCategoryCName}"/>'>
				</div>
			</div>
			<div class="control-group info">
				<label class="control-label" for="fooden">Food English</label>
				<div class="controls">
					<input type="text" name="foodShortName" disabled value='<c:out value="${menu.food.foodShortName}"/>'>
				</div>
			</div>
			<div class="control-group info">
				<label class="control-label" for="foodch">Food Chinese</label>
				<div class="controls">
					<input type="text" name="cFoodName" disabled value='<c:out value="${menu.food.cFoodName}"/>'>
				</div>
			</div>
			<div class="control-group info">
				<label class="control-label" for="descriptionen">Description English</label>
				<div class="controls">
					<input type="text" name="description" disabled value='<c:out value="${menu.food.description}"/>'>
				</div>
			</div>
			<div class="control-group info">
				<label class="control-label" for="descriptionch">Description Chinese</label>
				<div class="controls">
					<input type="text" name="cDescription" disabled value='<c:out value="${menu.food.cDescription}"/>'>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="small">Small</label>
				<div class="controls">
					<input type="text" name="small" placeholder="Small" value='<c:out value="${menu.small}"/>'>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="large">Large</label>
				<div class="controls">
					<input type="text" name="large" placeholder="Large" value='<c:out value="${menu.large}"/>'>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="lunch">Lunch</label>
				<div class="controls">
					<input type="text" name="lunch" placeholder="Lunch" value='<c:out value="${menu.lunch}"/>'>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="combo">Combo</label>
				<div class="controls">
					<input type="text" name="combo" placeholder="Combo" value='<c:out value="${menu.combo}"/>'>
				</div>
			</div>
		</form>
	</fieldset>
	</div>
</div>
</sec:authorize>