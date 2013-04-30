<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${subCategories}" var="subCategory">
	<c:choose>
		<c:when test="${subCategory.spicy}">
			<button id="food_${subCategory.food.foodId}" 
				type="button" 
				name="${subCategory.food.foodId}" 
				class="btn btn-danger btn-large btn1"
				value='<c:out value="${subCategory.food.foodId}"></c:out>'
			>
				${subCategory.food.foodShortName}
			</button>	
		</c:when>
		<c:otherwise>
			<button id="food_${subCategory.food.foodId}" 
				type="button" 
				name="${subCategory.food.foodId}" 
				class="btn btn-info btn-large btn1"
				value='<c:out value="${subCategory.food.foodId}"></c:out>'
			>
				${subCategory.food.foodShortName}
			</button>	
		</c:otherwise>
	</c:choose>

</c:forEach>