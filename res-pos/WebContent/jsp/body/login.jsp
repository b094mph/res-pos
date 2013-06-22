<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<body onload="document.loginform.j_username.focus();">
<div class="row">
	<fieldset>
	<legend>RES-POS</legend>
	</fieldset>
</div>
<div class="row-fluid">
	<ul class="nav nav-tabs">
	  <li class="active"><a href="#login" data-toggle="tab">Login</a></li>
	  <li><a href="#create" data-toggle="tab">Create an account</a></li>
	</ul>
	<div id="tabContent" class="tab-content">
       	<div class="tab-pane active in" id="login">
	       	<div class="row-fluid">
				<div class="span4">
					<fieldset>
					<legend><spring:message code="label.signin"/></legend>
						<jsp:include page="signinForm.jsp"/>
					</fieldset>
				</div>
			</div>
		</div>
		 <div class="tab-pane fade" id="create">
		 	<div class="row-fluid">
				<div class="span4">
				<fieldset>
				<legend><spring:message code="label.signup"/></legend>
					<form method="post" action="signup.html">
						<div class="controls controls-row">
								<input type="text" id="firstname" class="span6" name="firstname" placeholder='<spring:message code="label.signup.firstname"/>'>
								<input type="text" id="lastname" class="span6" name="lastname" placeholder='<spring:message code="label.signup.lastname"/>'>
						</div>
						<div class="control-group">
								<input type="text" id="username" class="span12" name="username" placeholder='<spring:message code="label.signup.username"/>'>
								<input type="password" id="password" class="span12" name="password" placeholder='<spring:message code="label.signup.password"/>'>
						</div>
						<div class="control-group">
							<button type="submit" class="btn btn-success btn-block" name="signup"><spring:message code="label.signup.free"/></button>
							<button type="reset" class="btn btn-block" name="reset"><spring:message code="label.reset"/></button>
						</div>
					</form>
				</fieldset>
				</div>
			</div>
		 </div>
	</div>
</div>


	

</body>
