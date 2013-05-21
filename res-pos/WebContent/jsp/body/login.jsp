<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body onload="document.loginform.j_username.focus();">
<div class="row">
	<fieldset>
	<legend>Restaurant_01</legend>
	</fieldset>
</div>
<div class="row">
	<div class="span4 offset1">
		<fieldset>
		<legend>Have a username? Sign in!</legend>
		<form name="loginform" class="form-horizontal" method="post" action="<c:url value='j_spring_security_check'/>">
			<div class="control-group">
				<label class="control-label" for="username">Username</label>
				<div class="controls">
					<input type="text" id="username" name="j_username" placeholder="Your username">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" id="password" name="j_password" placeholder="Your password">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn btn-success btn-large" name="submit">Log In</button>
					<button type="reset" class="btn btn-large" name="reset">Reset</button>
				</div>
			</div>
		</form>
		</fieldset>
	</div>
	<div class="span3 offset2">
		<fieldset>
		<legend>Sign Up</legend>
			<form class="form-horizontal" method="post" action="signup.html">
				<table>
					<tr>
						<td><input type="text" id="firstname" class="span12" name="firstname" placeholder="Your first name"></td>
					</tr>
					<tr>
						<td><input type="text" id="lastname" class="span12" name="lastname" placeholder="Your last name"></td>
					</tr>
					<tr>
						<td><input type="text" id="username" class="span12" name="username" placeholder="Pick a username"></td>
					</tr>
					<tr>
						<td><input type="password" id="password" class="span12" name="password" placeholder="Create a password"></td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="btn btn-success btn-large" name="signup">Sign up for free</button>
							<button type="reset" class="btn btn-large" name="reset">&nbsp;Reset&nbsp;&nbsp;</button>
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</div>
</body>
<br><br><br><br><br><br><br><br><br><br>