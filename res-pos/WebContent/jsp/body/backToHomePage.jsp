<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<input id="homePage" type="hidden" value="<%=request.getContextPath()%>/login.html">
   
<div class="row">
	<div class="span12">
		<button id="home" type="button" class="btn btn-large btn-block">
			<spring:message code="label.back.to.homepage"/>
		</button>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		$('#home').click(function(){
			window.location.replace($('#homePage').val());
		});
	});
</script>