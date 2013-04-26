<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script type="text/javascript" src="js/menubar.js"></script>

<div class="navbar navbar-static-top">	
	<div class="navbar-inner">
		<a class="brand" href="#">RES-POS</a>
		<ul class="nav">
			<li id="home-link">
				<a id="home-link" href="http://localhost:8080/res-pos/index.jsp">Home</a>
			</li>
			<li><a id="address-link" href="address.html">Address</a></li>
			<li><a id="customer-link" href="showCustomerForm.html">Customer</a></li>
			<li><a id="menu-link" href="menu.html"><spring:message code="label.menu"/></a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Careers</a></li>
		</ul>
	</div>
</div>
