<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fieldset>
<legend>Category</legend>
<table>
	<% int count = 1; %>
	<c:choose>
		<c:when test="${not empty foodCategories}">
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
		</c:when>
		<c:otherwise>
			<div id="noMenu" class="alert alert-danger">
				<a class="close" data-dismiss="alert">x</a>
				<h3>No menu found.</h3>
			</div>
		</c:otherwise>
	</c:choose>
</table>
</fieldset>