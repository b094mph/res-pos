<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<input id="rowIndex" type="hidden" value="${rowIndex}">

<table>
	<c:forEach items="${extrasSubCategories}" var="extrasSubCategory">
		<button id="extra_${extrasSubCategory.menuId}"
			type="button"
			name="extraSubMenuBtn"
			class="btn btn-primary btn1"
			<c:choose>
				<c:when test="${lang == 'zh'}">
					title="<c:out value="${extrasSubCategory.food.cDescription}"></c:out>"	
				</c:when>
				<c:otherwise>
					title="<c:out value="${extrasSubCategory.food.description}"></c:out>"
				</c:otherwise>
			</c:choose>
			value="${extrasSubCategory.menuId}"
		>
			<c:choose>
				<c:when test="${lang == 'zh'}">
					${extrasSubCategory.food.cFoodName}
				</c:when>
				<c:otherwise>
					${extrasSubCategory.food.foodShortName}
				</c:otherwise>
			</c:choose>
		</button>
	</c:forEach>
</table>

<script type="text/javascript">
	var lang = "<c:out value='${lang}'/>";
	var extraIDs = new Array();
	
	if(lang == 'zh'){
		$("button[name='extraSubMenuBtn']").css("font-size", "22px");
	}
	
	<c:forEach items="${extrasSubCategories}" var="extrasSubCategory">
		extraIDs.push("${extrasSubCategory.menuId}");
	</c:forEach>
</script>
<script type="text/javascript" src="js/extras.js"></script>