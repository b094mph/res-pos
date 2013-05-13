<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<script type="text/javascript" src="js/menu.js"></script>
<script>
	var foodCategoriesSize = '<c:out value="${foodCategoriesSize}"></c:out>';
</script>

<body>
<div class="container">
	<fieldset>
	<legend><spring:message code="label.menu"/></legend>
		<div class="row">
			<div id="category" class="span5">
				<fieldset>
				<legend>Category</legend>
				<table>
					<% int count = 1; %>
					<c:forEach items="${foodCategories}" var="fc">
						<button id='fc_<%=count++%>'  
								type="button" 
								name="${fc.foodCategoryId}" 
								class="btn btn-info btn-large btn1"
								value='<c:out value="${fc.foodCategoryId}"></c:out>'
						>
							${fc.foodCategoryName}
						</button> 
					</c:forEach>
				</table>
				</fieldset>
			</div>
			<div id="subcategory" class="span7">
				<div id="subcategoryajax">

				</div>
			</div>
		</div>
		<br>
	</fieldset>
</div>
</body>
<br><br><br><br>