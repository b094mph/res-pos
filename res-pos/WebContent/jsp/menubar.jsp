<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script type="text/javascript" src="js/menubar.js"></script>

<div class="navbar navbar-static-top">	
	<div class="navbar-inner">
		<a class="brand" href="index.jsp">RES-POS</a>
		<ul class="nav">
			<li id="home-link">
				<a id="home-link" href="welcome.html">Home</a>
			</li>
			<li><a id="address-link" href="addressForm.html">Address</a></li>
			<li><a id="customer-link" href="customerForm.html">Customer</a></li>
			<li><a id="menu-link" href="menu.html"><spring:message code="label.menu"/></a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Careers</a></li>
			<li>&nbsp;</li>
			<li>
				<form class="navbar-search pull-right">
					<input type="text" class="search-query" placeholder="Search">
				</form>
			</li>
		</ul>
	</div>
</div>
