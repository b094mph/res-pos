<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	var menuIDs = ${menuIDs};
</script>
<script type="text/javascript" src="js/submenu.js"></script>

<input id="foodLegend" type="hidden" value="${foodCategoryName}">

<fieldset>
<legend>
	<c:choose>
		<c:when test="${lang == 'zh'}">
			${foodCategoryCName}
		</c:when>
		<c:otherwise>
			${foodCategoryName}		
		</c:otherwise>
	</c:choose>
</legend>
<table>
	<c:forEach items="${subCategories}" var="subCategory">
		<c:choose>
			<c:when test="${subCategory.spicy}">
				<button id="menu_${subCategory.menuId}"  
							type="button" 
							name="${subCategory.menuId}" 
							class="btn btn-danger btn1"
							<c:choose>
								<c:when test="${lang == 'zh'}">
									title="<c:out value="${subCategory.food.cDescription}"></c:out>"	
								</c:when>
								<c:otherwise>
									title="<c:out value="${subCategory.food.description}"></c:out>"
								</c:otherwise>
							</c:choose>
							value='<c:out value="${subCategory.menuId}"></c:out>'
				>
					<c:choose>
						<c:when test="${lang == 'zh'}">
							${subCategory.food.cFoodName}
						</c:when>
						<c:otherwise>
							${subCategory.food.foodShortName}
						</c:otherwise>
					</c:choose>
				</button>
			</c:when>
			<c:otherwise>
				<button id="menu_${subCategory.menuId}"  
							type="button" 
							name="${subCategory.menuId}" 
							class="btn btn-info btn1"
							<c:choose>
								<c:when test="${lang == 'zh'}">
									title="<c:out value="${subCategory.food.cDescription}"></c:out>"	
								</c:when>
								<c:otherwise>
									title="<c:out value="${subCategory.food.description}"></c:out>"
								</c:otherwise>
							</c:choose>
							value='<c:out value="${subCategory.menuId}"></c:out>'
				>
					<c:choose>
						<c:when test="${lang == 'zh'}">
							${subCategory.food.cFoodName}
						</c:when>
						<c:otherwise>
							${subCategory.food.foodShortName}
						</c:otherwise>
					</c:choose>				
				</button>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>
</fieldset>