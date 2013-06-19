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
				name="extraCategoryRdo"
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
	<div id="tasteModifierDiv" class="btn-group" data-toggle="buttons-radio">
		<c:forEach items="${tasteModifiers}" var="modifier">
			<button id="${modifier.modifyTasteName}" 
					type="button"
					name="tasteModifierRdo" 
					class="btn btn-primary btn2" 
					value="${modifier.modifyTasteId}">
				<c:choose>
					<c:when test="${lang == 'zh'}">
						${modifier.modifyTasteCName}
					</c:when>
					<c:otherwise>
						${modifier.modifyTasteName}
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