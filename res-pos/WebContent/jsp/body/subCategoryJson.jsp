<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>

<script>
	var subCategoriesSize = <c:out value="${subCategoriesSize}"></c:out>;
	var subCategoryStartIndex = <c:out value="${subCategories[0].id}"></c:out>;
</script>

<script type="text/javascript" src="js/subCategoryJson.js"></script>


<c:forEach items="${subCategories}" var="subCategory">
	<c:choose>
		<c:when test="${subCategory.spicy}">
			<button id="subcategory${subCategory.id}" class="button1 red" type="button" name="<c:out value='${subCategory.shortName}'/>" value="<c:out value='${subCategory.id}'/>">
				<c:out value='${subCategory.shortName}'/>
			</button>
		</c:when>
		<c:otherwise>
			<button id="subcategory${subCategory.id}" class="button1" type="button" name="<c:out value='${subCategory.shortName}'/>" value="<c:out value='${subCategory.id}'/>">
				<c:out value='${subCategory.shortName}'/>
			</button>
		</c:otherwise>
	</c:choose>
</c:forEach>
