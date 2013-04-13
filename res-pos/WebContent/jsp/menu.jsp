<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="common/headerimport.jsp"/>
</head>
<body>
<div class="container">
	
	<div class="btn-group row">
		<button class="btn">Home</button>
		<button class="btn"><spring:message code="label.menu"/></button>
		<button class="btn">About</button>
		<button class="btn">Test</button>
		<button class="btn">Test</button>
		<button class="btn">Test</button>
		<button class="btn">Test</button>
		<button class="btn">Test</button>
		<button class="btn">Other</button>
	</div>
	<div class="row"><br></div>
</div>
</body>
</html>