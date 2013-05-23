<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="common/jquery.jsp"/>
	<jsp:include page="common/bootstrap.jsp"/>
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	<link type="image/png" rel="icon" href="img/favicons/RP-favicon.ico">
	<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<script>
	var SCREEN_HEIGHT = screen.availHeight;
	var SCREEN_WIDTH = screen.availWidth;
</script>
	<div class="container-fluid">
		<div class="row-fluid">
			<tiles:insertAttribute name="menubar" />
		</div>
		<div class="row-fluid">
			<tiles:insertAttribute name="body" />
		</div>
		<div class="row-fluid">
			<tiles:insertAttribute name="copyright"/>
		</div>
	</div>
</body>
</html>