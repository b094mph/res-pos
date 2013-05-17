<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	var menuIDs = ${menuIDs};
</script>
<script type="text/javascript" src="js/submenu.js"></script>

<fieldset>
<legend>${foodCategoryName}</legend>
<table>
	<c:forEach items="${subCategories}" var="subCategory">
		<c:choose>
			<c:when test="${subCategory.spicy}">
				<button id="menu_${subCategory.menuId}"  
							type="button" 
							name="${subCategory.menuId}" 
							class="btn btn-danger btn1"
							value='<c:out value="${subCategory.menuId}"></c:out>'
					>
						${subCategory.food.foodShortName}
				</button>
			</c:when>
			<c:otherwise>
				<button id="menu_${subCategory.menuId}"  
							type="button" 
							name="${subCategory.menuId}" 
							class="btn btn-info btn1"
							value='<c:out value="${subCategory.menuId}"></c:out>'
					>
						${subCategory.food.foodShortName}
				</button>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>
</fieldset>