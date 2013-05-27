<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
	<div class="span2">
		<h6><b>AGENT:</b> <c:out value="${agentName}"/></h6>
	</div>
	<div class="span3">
		<h6><b>RESTAURANT:</b> <c:out value="${restaurantName}"/></h6>	
	</div>
	<div class="span2">
		<h6><b>ORDER TYPE:&nbsp;</b><b id="orderType"></b></h6>
	</div>
	<div class="span3 offset2">
		<div class="pull-right">
			<h6><%= new java.util.Date() %></h6>
		</div>
	</div>
</div>