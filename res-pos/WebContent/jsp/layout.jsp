<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table align="center">
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
        <td colspan="2"><tiles:insertAttribute name="footer"/></td>
    </tr>
</table>
</body>
</html>