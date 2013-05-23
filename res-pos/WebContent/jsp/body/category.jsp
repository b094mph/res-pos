<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fieldset>
<legend>Category</legend>
<table>
	<% int count = 1; %>
	<c:forEach items="${foodCategories}" var="fc">
		<button id='fc_<%=count++%>'  
				type="button" 
				name="${fc.foodCategoryId}" 
				class="btn btn-info btn1"
				value='<c:out value="${fc.foodCategoryId}"></c:out>'
		>
			${fc.foodCategoryName}
		</button> 
	</c:forEach>
</table>
</fieldset>