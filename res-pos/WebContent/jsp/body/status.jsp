<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row">
	<div class="span2">
		<h5><b><spring:message code="label.agent"/>:</b> <c:out value="${agentName}"/></h5>
	</div>
	<div class="span3">
		<h5><b><spring:message code="label.restaurant"/>:</b> <c:out value="${restaurantName}"/></h5>	
	</div>
	<div class="span2">
		<h5><b><spring:message code="label.order.num"/>:&nbsp;</b><b id="orderNum"></b></h5>
	</div>
	<div class="span2">
		<h5><b><spring:message code="label.order.type"/>:&nbsp;</b><b id="orderType"></b></h5>
	</div>
	<div class="span3">
		<div class="pull-right">
			<h5 id="currentDateTime"></h5>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		
		setInterval(function(){
			$("[id=currentDateTime]").text(moment().format('MMMM DD YYYY, hh:mm:ss A'));	
		}, 1000);
		
	});
</script>