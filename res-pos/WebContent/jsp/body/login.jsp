<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	<title>Restaurant_01</title>
</head>
<!-- http://localhost:8080/res-pos/index.jsp -->
<body onload="document.loginform.j_username.focus();">
<div class="container">
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	 
	<fieldset>
	<legend>Restaurant_01</legend>
		<div class="row">
			<div class="span4">
				<form name="loginform" class="form-horizontal" method="post" action="<c:url value='j_spring_security_check'/>">
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<input type="text" id="username" name="j_username" placeholder="Username">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<input type="password" id="password" name="j_password" placeholder="Password">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn" name="submit">Log In</button>
							<button type="reset" class="btn" name="reset">Reset</button>
						</div>
					</div>
				</form>
			</div>
			<div class="span2 offset2">
				<fieldset>
				<legend>Sign Up</legend>
					<form class="form-horizontal" method="post" action="signup.html">
						<div class="control-group">
							<div class="controls">
								<input type="text" id="firstname" name="firstname" placeholder="First Name">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="text" id="lastname" name="lastname" placeholder="Last Name">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="text" id="username" name="username" placeholder="Username">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="text" id="password" name="password" placeholder="Password">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn" name="signup">Sign Up</button>
								<button type="reset" class="btn" name="reset">Reset</button>
							</div>
						</div>
					</form>
				</fieldset>
			</div>
		</div>
	</fieldset>
</div>
</body>
</html>