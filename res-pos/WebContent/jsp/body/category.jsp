<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/category.js"></script>
</head>
<body>

<script>
	var categoriesSize = '<c:out value="${categoriesSize}"></c:out>';
</script>
<table>
	<tr>
		<td valign="top">
			<table id="category" title="Category">
				<tr>
					<td>
					<fieldset>
					<legend>Category</legend>
						<div id="divCategory" class="sectionA" >
							<c:forEach items="${categories}" var="category">
								<button id="category${category.id}" class="button1" type="button" name="<c:out value='${category.name}'/>" value="<c:out value='${category.id}'/>" >
									<c:out value='${category.name}'/>
								</button>	
							</c:forEach>
						</div>
					</fieldset>
					</td>
				</tr>
			</table>
			<jsp:include page="subCategory.jsp"/>
			<jsp:include page="supportButtons.jsp"/>
		</td>
		<td valign="top">
			<jsp:include page="customerInformation.jsp"/>
			<jsp:include page="order.jsp"/>
		</td>
	</tr>
</table>		
<input id="test" type="button" value="hide"/>
</body>
</html>