<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.Properties" %>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="com.restaurant.model.Category" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 3.0 MVC series - contact manager</title>
</head>
<body>
<h2>Contact Manager</h2>

<jsp:useBean id="categoryBean" class="com.restaurant.model.Category" scope="request"/>

<h6>FROM SCRIPTLET</h6>
<% Category category = (Category) request.getAttribute("category");
  String name = category.getName();
  out.println("The value entered is: " + category.getId());
  out.println("we get: " + category.getName());
%>

<h6>FROM JSP TAG</h6>
<h1>jsp:setProperty</h1>
<jsp:setProperty property="name" name="categoryBean" value="<%=name %>"/>
<h1>jsp:getProperty</h1>
<jsp:getProperty property="name" name="categoryBean"/>
<br>

<h6>FROM C TAG</h6>
<c:out value="name"></c:out>

<h6>FROM FORM:</h6>
<form name="hForm" id="hform" method="get" action="/jsp/footer.jsp">
	<input type="text" name="name" value=name />
	<input type="submit" name="submit"/>
</form>

</body>
</html>