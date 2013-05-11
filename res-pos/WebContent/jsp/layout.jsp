<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<jsp:include page="common/bootstrap.jsp"/>
	<jsp:include page="common/jquery.jsp"/>
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div class="container">
	<table>
	    <tr>
	        <td colspan="2"><tiles:insertAttribute name="header" />
	        </td>
	    </tr>
	    <tr>
	    	<td><tiles:insertAttribute name="menu" /></td>
	    </tr>
	    <tr>
	        <td><tiles:insertAttribute name="body" /></td>
	    </tr>
	    <tr>
	        <td><tiles:insertAttribute name="footer"/></td>
	    </tr>
	    <tr>
	    	<td><tiles:insertAttribute name="copyright"/></td>
	    </tr>
	</table>
</div>
</body>
</html>