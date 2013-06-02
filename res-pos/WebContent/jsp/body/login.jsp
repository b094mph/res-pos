<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<body onload="document.loginform.j_username.focus();">
<div class="row">
	<fieldset>
	<legend>Restaurant_01</legend>
	</fieldset>
</div>
<br><br><br><br><br><br>
<div class="row">
	<div class="span4 offset1">
		<fieldset>
		<legend><spring:message code="label.choose.restaurant"/></legend>
		<form name="loginform" class="form-horizontal" method="post" action="<c:url value='j_spring_security_check'/>">
			<div class="control-group">
				<label class="control-label" for="username"><spring:message code="label.username"/></label>
				<div class="controls">
					<input type="text" id="username" name="j_username" placeholder='<spring:message code="label.your.username"/>'>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password"><spring:message code="label.password"/></label>
				<div class="controls">
					<input type="password" id="password" name="j_password" placeholder='<spring:message code="label.your.password"/>'>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-success btn-large" name="submit"><spring:message code="label.login"/></button>
					<button type="reset" class="btn btn-large" name="reset"><spring:message code="label.reset"/></button>
				</div>
			</div>
		</form>
		</fieldset>
	</div>
	<div class="span3 offset2">
		<fieldset>
		<legend><spring:message code="label.signup"/></legend>
			<form class="form-horizontal" method="post" action="signup.html">
				<table>
					<tr>
						<td><input type="text" id="firstname" class="span12" name="firstname" placeholder='<spring:message code="label.signup.firstname"/>'></td>
					</tr>
					<tr>
						<td><input type="text" id="lastname" class="span12" name="lastname" placeholder='<spring:message code="label.signup.lastname"/>'></td>
					</tr>
					<tr>
						<td><input type="text" id="username" class="span12" name="username" placeholder='<spring:message code="label.signup.username"/>'></td>
					</tr>
					<tr>
						<td><input type="password" id="password" class="span12" name="password" placeholder='<spring:message code="label.signup.password"/>'></td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="btn btn-success btn-large" name="signup"><spring:message code="label.signup.free"/></button>
							<button type="reset" class="btn btn-large" name="reset">&nbsp;<spring:message code="label.reset"/>&nbsp;&nbsp;</button>
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</div>
</body>
