<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
	<div class="span12">
		<div id="signupSuccess" class="alert alert-info">
			<a class="close" data-dismiss="alert">
				<img alt="remove" src="img/glyphicons/glyphicons/png/glyphicons_197_remove.png">
			</a>
			<h3 class="alert-heading"><spring:message code="label.modal.signup.success"/></h3>
			<p><spring:message code="label.modal.username.not.taken"/></p>	
		</div>
	</div>
</div>
<div class="span4 offset1">
	<fieldset>
	<legend><spring:message code="label.now.signin"/></legend>
		<jsp:include page="signinForm.jsp"/>
	</fieldset>
</div>