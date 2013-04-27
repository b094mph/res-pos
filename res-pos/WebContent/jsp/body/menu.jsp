<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<fieldset>
<legend><spring:message code="label.menu"/></legend>
	<div class="row">
		<div id="category" class="span5">
			<fieldset>
			<legend>Category</legend>
			<table>
				<c:forEach items="${foodCategories}" var="fc">
					<button id="fc_${fc.foodCategoryId}" 
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
			<fieldset>
			<legend>SubCategory</legend>
			</fieldset>
		</div>
	</div>
</fieldset>
</body>
</html>