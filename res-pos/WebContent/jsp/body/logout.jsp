<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row">
	<div class="span12">
		<div id="logoutalert" class="alert alert-info">
			<a class="close" data-dismiss="alert">
				<img alt="remove" src="img/glyphicons/glyphicons/png/glyphicons_197_remove.png">
			</a>
			<h3 class="alert-heading"><spring:message code="label.modal.logout.goodbye"/></h3>
			<p><spring:message code="label.modal.logged.out"/></p>
		</div>
	</div>
</div>
<jsp:include page="backToHomePage.jsp"/>