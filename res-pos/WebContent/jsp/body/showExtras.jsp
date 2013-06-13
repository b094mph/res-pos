<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend><spring:message code="label.extras"/></legend>
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
		<button id="add" type="button" class="btn btn-primary btn2" value="add">Add</button>
		<button id="no" type="button" class="btn btn-primary btn2" value="no">No</button>
		<button id="less" type="button" class="btn btn-primary btn2" value="less">Less</button>
		<button id="with" type="button" class="btn btn-primary btn2" value="with">With</button>
		<button id="only" type="button" class="btn btn-primary btn2" value="only">Only</button>
		<button id="want" type="button" class="btn btn-primary btn2" value="want">Want</button>
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