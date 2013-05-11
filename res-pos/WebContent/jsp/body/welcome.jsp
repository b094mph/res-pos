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
		<table>
			<tr>
				<th><h1>Welcome <c:out value="${username}"/></h1></th>
				<td><h3><a href='<c:url value="/logout" />'>Logout</a></h3></td>
			</tr>
			<tr>
				<td><iframe width="425" height="350" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=New+York,+NY&amp;aq=0&amp;oq=New+Yo&amp;sll=42.746632,-75.770041&amp;sspn=4.485583,10.107422&amp;ie=UTF8&amp;hq=&amp;hnear=New+York&amp;t=m&amp;z=10&amp;ll=40.714353,-74.005973&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=New+York,+NY&amp;aq=0&amp;oq=New+Yo&amp;sll=42.746632,-75.770041&amp;sspn=4.485583,10.107422&amp;ie=UTF8&amp;hq=&amp;hnear=New+York&amp;t=m&amp;z=10&amp;ll=40.714353,-74.005973" style="color:#0000FF;text-align:left">View Larger Map</a></small></td>
			</tr>
		</table>
		<br><br><br><br>
	</div>
</body>
</html>