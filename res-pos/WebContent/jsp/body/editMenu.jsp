<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link rel="stylesheet" href="css/bootstrap-select.css">

<style>
label{
	max-width: 100%;
}
</style>

<sec:authorize ifAnyGranted="ROLE_ADMIN">

<input id="spicy" type="hidden" value='<c:out value="${menu.spicy}"/>'>
<input id="rice" type="hidden" value='<c:out value="${menu.rice}"/>'>
<input id="sauce" type="hidden" value='<c:out value="${menu.sauce}"/>'>
<input id="noodle" type="hidden" value='<c:out value="${menu.noodle}"/>'>
<input id="appetizerCombo" type="hidden" value='<c:out value="${menu.appetizerCombo}"/>'>

<div class="row">
	<div class="span12">
	<fieldset>
	<legend>${restaurantName} / ${menu.foodCategory.foodCategoryName} / ${menu.food.foodShortName}</legend>
		<h3>Please enter new prices:</h3>
		<br>
		<form method="get" action="saveMenu.html">
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
			<div class="span3">
				<div class="control-group info">
					<label class="control-label" for="category">Category</label>
					<div class="controls">
						<input type="text" name="foodCategoryName" disabled value='<c:out value="${menu.foodCategory.foodCategoryName}"/>'>
					</div>
					<label class="control-label" for="fooden">Food English</label>
					<div class="controls">
						<input type="text" name="foodShortName" disabled value='<c:out value="${menu.food.foodShortName}"/>'>
					</div>
					<label class="control-label" for="descriptionen">Description English</label>
					<div class="controls">
						<input type="text" name="description" disabled value='<c:out value="${menu.food.description}"/>'>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="menunum">Menu Num</label>
					<div class="controls">
						<input type="text" name="menunum" placeholder="Enter menu num here" value='<c:out value="${menu.menuNum}"/>'>
					</div>
					<label class="control-label">&nbsp;</label>
					<div class="controls">
						<input type="text" class="visibility-hidden" disabled>
					</div>
					<label class="control-label" for="lunchnum">Lunch Num</label>
					<div class="controls">
						<input type="text" name="lunchnum" placeholder="Enter lunch num here" value='<c:out value="${menu.lunchNum}"/>'>
					</div>
					<label class="control-label" for="combonum">Combo Num</label>
					<div class="controls">
						<input type="text" name="combonum" placeholder="Enter combo num here" value='<c:out value="${menu.comboNum}"/>'>
					</div>
				</div>
			</div>
			<div class="span3">
				<div class="control-group info">
					<label class="control-label" for="categorych">Category Chinese</label>
					<div class="controls">
						<input type="text" name="foodCategoryCName" disabled value='<c:out value="${menu.foodCategory.foodCategoryCName}"/>'>
					</div>
					<label class="control-label" for="foodch">Food Chinese</label>
					<div class="controls">
						<input type="text" name="cFoodName" disabled value='<c:out value="${menu.food.cFoodName}"/>'>
					</div>
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
					<label class="control-label" for="large">Large</label>
					<div class="controls">
						<input type="text" name="large" placeholder="Large" value='<c:out value="${menu.large}"/>'>
					</div>
					<label class="control-label" for="lunch">Lunch</label>
					<div class="controls">
						<input type="text" name="lunch" placeholder="Lunch" value='<c:out value="${menu.lunch}"/>'>
					</div>
					<label class="control-label" for="combo">Combo</label>
					<div class="controls">
						<input type="text" name="combo" placeholder="Combo" value='<c:out value="${menu.combo}"/>'>
					</div>
				</div>
			</div>
			<div class="span3">
				<div class="control-group">
					<label class="control-label" for="spicy">Is it spicy?</label>
					<div class="controls">
						<select id="selectspicy" name="spicy" class="selectpicker">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</div>
					<label class="control-label" for="rice">Includes rice?</label>
					<div class="controls">
						<select id="selectrice" name="rice" class="selectpicker">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</div>
					<label class="control-label" for="sauce">Includes sauce?</label>
					<div class="controls">
						<select id="selectsauce" name="sauce" class="selectpicker">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</div>
					<label class="control-label" for="noodle">Includes noodle?</label>
					<div class="controls">
						<select id="selectnoodle" name="noodle" class="selectpicker">
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</div>
					<label class="control-label" for="pieces">How many pieces?</label>
					<div class="controls">
						<input type="text" name="pieces" placeholder="Enter a number here" value='<c:out value="${menu.pieces}"/>'>
					</div>
					<label class="control-label" for="appetizerCombo">Appetizer Combo dish?</label>
					<div class="controls">
						<select id="selectappetizercombo" name="appetizerCombo" class="selectpicker">
							<option value="">n/a</option>
							<option value="true">Yes</option>
							<option value="false">No</option>
						</select>
					</div>
				</div>
			</div>
		</form>
	</fieldset>
	</div>
</div>
</sec:authorize>

<script type="text/javascript" src="js/bootstrap-select.js"></script>
<script type="text/javascript" src="js/editMenu.js"></script>