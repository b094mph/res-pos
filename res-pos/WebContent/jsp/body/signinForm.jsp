<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form name="loginform" class="form-horizontal" method="post" action="<c:url value='j_spring_security_check'/>">
	<div class="control-group">
		<label class="control-label" for="username"><spring:message code="label.username"/></label>
		<div class="controls">
			<input type="text" id="username" name="j_username" class="input-block-level" placeholder='<spring:message code="label.your.username"/>'>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="password"><spring:message code="label.password"/></label>
		<div class="controls">
			<input type="password" id="password" name="j_password" class="input-block-level" placeholder='<spring:message code="label.your.password"/>'>
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<button type="submit" class="btn btn-success btn-block" name="submit"><spring:message code="label.login"/></button>
			<button type="reset" class="btn btn-block" name="reset"><spring:message code="label.reset"/></button>
		</div>
	</div>
</form>