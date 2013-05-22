<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<script type="text/javascript" src="js/menubar.js"></script>

<c:url var="logoutUrl" value="/logout"/>

<div class="navbar navbar-inverse navbar-fixed-top">	
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="row-fluid">
				<a class="brand" href="index.jsp">RES-POS</a>
				<ul class="nav">
					<li id="home-link">
						<a id="home-link" href="welcome.html"><i class="icon-home icon-white"></i> Home</a>
					</li>
					<li id="file" class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">File</a>
					</li>
					<li id="search" class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Search</a>
					</li>
					<li><a id="address-link" href="addressForm.html">Address</a></li>
					<li><a id="customer-link" href="customerForm.html">Customer</a></li>
					<li><a id="menu-link" href="menu.html"><spring:message code="label.menu"/></a></li>
					<li id="help" class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Help</a>
					</li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Careers</a></li>
					<sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">	
						<li><a href="${logoutUrl}">Logout</a></li>
					</sec:authorize>	
				</ul>
				<div class="btn-group pull-right" data-toggle="buttons-radio">
					<a class="btn btn-danger" href="?lang=en">en</a>
					<a class="btn btn-danger" href="?lang=zh">ch</a>
				</div>
			</div>
		</div>
	</div>
</div>

