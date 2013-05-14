<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="logoutUrl" value="/logout"/>

<div class="row">
	<div class="span12">
		<fieldset>
		<legend><b>Welcome to RES-POS!</b>
			<span class="pull-right">
				<sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">
					<a href="${logoutUrl}">Logout</a> |
				</sec:authorize>
			    <a href="?lang=en">en</a> 
			    | 
			    <a href="?lang=zh">ch</a>
			</span>
		</legend>
		</fieldset>		 
	</div>	
</div>