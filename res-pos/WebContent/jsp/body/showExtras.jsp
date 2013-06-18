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
		<c:forEach items="${tasteModifiers}" var="modifier">
			<c:choose>
				<c:when test="${lang == 'zh'}">
					<button id="${modifier.modifyTasteCName}" 
							type="button" 
							class="btn btn-primary btn2" 
							value="${modifier.modifyTasteCName}">
						${modifier.modifyTasteCName}
					</button>
				</c:when>
				<c:otherwise>
					<button id="${modifier.modifyTasteName}" 
							type="button" 
							class="btn btn-primary btn2" 
							value="${modifier.modifyTasteName}">
						${modifier.modifyTasteName}
					</button>
				</c:otherwise>
			</c:choose>
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