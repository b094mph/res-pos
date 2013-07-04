<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row">
	<div class="span12">
		<div id="welcomealert" class="alert alert-info">
			<a class="close" data-dismiss="alert">
				<img alt="remove" src="img/glyphicons/glyphicons/png/glyphicons_197_remove.png">
			</a>
			<h3><spring:message code="label.hello"/>&nbsp;<c:out value="${agentName}"/>!</h3>
			<p><spring:message code="label.welcome.to.res.pos"/></p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<fieldset>
		<legend><spring:message code="label.choose.restaurant"/></legend>
			<table class="table table-striped table-hover">
				<thead id="header">
					<tr>
						<th><spring:message code="label.id"/></th>
						<th><spring:message code="label.restaurant"/></th>
						<th><spring:message code="label.location"/></th>
						<th><spring:message code="label.phone1"/></th>
						<th><spring:message code="label.phone2"/></th>
						<th><spring:message code="label.fax"/></th>
						<th><spring:message code="label.delivery.cost"/></th>
						<th><spring:message code="label.tax"/></th>
						<th><spring:message code="label.mon.to.thurs"/></th>
						<th><spring:message code="label.fri"/></th>
						<th><spring:message code="label.sat"/></th>
						<th><spring:message code="label.sun"/></th>
						<th><spring:message code="label.menu"/></th>
					</tr>
				</thead>
				<tbody>
			<c:forEach items="${restaurants}" var="res" varStatus="idx">
					<tr>
						<td>
							<button class="btn btn-primary" onclick="window.location.href='menu.html?restaurantId=${res.restaurantId}&restaurantName=${res.restaurantName}'" value="${res.restaurantId}" >${res.restaurantId}</button>
						</td>
						<td>${res.restaurantName}</td>
						<td>${res.location}</td>
						<td>${res.phone1}</td>
						<td>${res.phone2}</td>
						<td>${res.faxNumber}</td>
						<td>${res.deliveryCost}</td>
						<td>${res.tax * 100}&nbsp;%</td>
						<td>${res.monToThursOpen} - ${res.monToThursClose}</td>
						<td>${res.friOpen} - ${res.friClose}</td>
						<td>${res.satOpen} - ${res.satClose}</td>
						<td>${res.sunOpen} - ${res.sunClose}</td>
						<td>
							<a href="wholeMenu.html?restaurantId=${res.restaurantId}&restaurantName=${res.restaurantName}"><spring:message code="label.menu"/></a>
						</td>
					</tr>
			</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var lang = "<c:out value='${lang}'/>";
		if(lang == 'zh'){
			$("#header").css("font-size","18px");
		}
	});
</script>