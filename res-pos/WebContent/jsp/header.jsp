<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="common/bootstrap.jsp"/>
	<jsp:include page="common/jquery.jsp"/>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="span12">
			<fieldset>
			<legend><b>Welcome to RES-POS!</b>
				<span style="float: right">
				    <a href="?lang=en">en</a> 
				    | 
				    <a href="?lang=zh">ch</a>
				</span>
			</legend>
			</fieldset>		 
		</div>	
	</div><!-- .row -->
</div><!-- .container -->
</body>
</html>