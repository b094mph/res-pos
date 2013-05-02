<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="row">
		<h1>Welcome <c:out value="${username}"/> </h1>
		
		<a href='<c:url value="/j_spring_security_logout" />'>Logout</a>
	</div>
</body>
</html>