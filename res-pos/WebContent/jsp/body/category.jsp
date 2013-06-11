<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend><spring:message code="label.category"/></legend>
<table>
	<c:choose>
		<c:when test="${not empty foodCategories}">
			<c:forEach items="${foodCategories}" var="fc">
				<button id="fc_${fc.foodCategoryId}"  
						type="button" 
						name="${fc.foodCategoryId}" 
						class="btn btn-info btn1"
						value='<c:out value="${fc.foodCategoryId}"></c:out>'
				>
					<c:choose>
						<c:when test="${lang == 'zh'}">
							${fc.foodCategoryCName}
						</c:when>
						<c:otherwise>
							${fc.foodCategoryName}
						</c:otherwise>
					</c:choose>	
				</button> 
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div id="noMenu" class="alert alert-danger">
				<h3><spring:message code="label.no.menu.found"/></h3>
			</div>
		</c:otherwise>
	</c:choose>
</table>
</fieldset>