<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<fieldset>
<legend><spring:message code="label.menu"/></legend>
<div>
	<table>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>
				<table>
					<c:forEach items="${foodCategories}" var="foodCategory">
						<button type="button" class="btn" >${foodCategory.foodCategoryName}</button> 
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</div>
</fieldset>
</body>
</html>