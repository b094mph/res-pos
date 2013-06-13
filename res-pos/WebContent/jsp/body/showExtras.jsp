<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fieldset>
<legend>Extras</legend>
<div class="row-fluid">
	<div class="btn-group" data-toggle="buttons-radio">
		<c:forEach items="${extrasCategories}" var="extrasCategory">
			<button id="${extrasCategory.foodCategoryName}"
				type="button"
				class="btn btn-primary btn2"
				value="${extrasCategory.foodCategoryId}"
			>
				<c:choose>
					<c:when test="${lang == 'zh'}">
						${extrasCategory.foodCategoryCName}
					</c:when>
					<c:otherwise>
						${extrasCategory.foodCategoryName}
					</c:otherwise>
				</c:choose>
			</button>
		</c:forEach>
	</div>
</div>
<div class="row-fluid">
	<br>
</div>
<div class="row-fluid">
	<div class="btn-group" data-toggle="buttons-radio">
		<button id="add" type="button" class="btn btn-primary btn2">Add</button>
		<button id="no" type="button" class="btn btn-primary btn2">No</button>
		<button id="less" type="button" class="btn btn-primary btn2">Less</button>
		<button id="with" type="button" class="btn btn-primary btn2">With</button>
		<button id="only" type="button" class="btn btn-primary btn2">Only</button>
		<button id="want" type="button" class="btn btn-primary btn2">Want</button>
	</div>
</div>
<div class="row-fluid">
	<br>
</div>
<div class="row-fluid">
	<div id="extraMenu">
		
	</div>
</div>
</fieldset>

<script>
	var extraCategoryNames = new Array();
	<c:forEach items="${extrasCategories}" var="extrasCategory">
		extraCategoryNames.push("${extrasCategory.foodCategoryName}");
	</c:forEach>
</script>
<script type="text/javascript" src="js/showExtras.js"></script>