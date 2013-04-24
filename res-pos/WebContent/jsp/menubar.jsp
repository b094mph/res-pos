<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="common/bootstrap.jsp"/>
	<jsp:include page="common/jquery.jsp"/>
	<script type="text/javascript" src="js/menubar.js"></script>
</head>
<body>
<div class="container">	
	<div class="btn-group row" data-toggle="buttons-radio">
		<button id="home" class="btn">Home</button>
		<button id="addressBtn" class="btn">Address</button>
		<button id="customerBtn" class="btn">Customer</button>
		<button id="showCustomerTable" class="btn">Show Customer Table</button>
		<button class="btn"><spring:message code="label.menu"/></button>
		<button id="about" class="btn">About</button>

		<button class="btn">Test</button>
		<button class="btn">Test</button>
		<button class="btn">Other</button>
	</div>
	<div class="row"><br></div>
</div>
</body>
</html>