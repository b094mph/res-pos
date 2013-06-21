<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script>
	$(".alert").alert('close');	
</script>
<div class="row">
	<div class="span12">
		<div id="loginfailalert" class="alert alert-error">
			<a class="close" data-dismiss="alert">
				<img alt="remove" src="img/glyphicons/glyphicons/png/glyphicons_197_remove.png">
			</a>
			<h3 class="alert-heading"><spring:message code="label.modal.login.failed"/></h3>
			<p><spring:message code="label.modal.username.password.incorrect"/></p>			
		</div>
	</div>
</div>
<jsp:include page="backToHomePage.jsp"/>


