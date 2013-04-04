<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>

<%@ page import="com.restaurant.model.Menu" %>
<%@ page import="java.util.List" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>
<p><spring:message code="label.menu"/></p>

<jsp:useBean id="menuBean" class="com.restaurant.model.Menu" scope="session"/>

<%
	List<Menu> menuList1 = (List<Menu>) request.getAttribute("menuList");
	out.println("menuList size is: " + menuList1.size());
	String item = menuList1.get(10).getName();
	out.println(item);
%>
<table>
<c:forEach items="${menuList}" var="menu">
	<c:out value="${menu.name}"></c:out>
	<br>
</c:forEach>
</table>

</body>
</html>