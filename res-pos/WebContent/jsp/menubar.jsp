<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="logoutUrl" value="/logout"/>

<div class="navbar navbar-inverse navbar-fixed-top">	
	<div class="navbar-inner">
		<div class="container-fluid">
			<div class="row-fluid">
				<a class="brand" href="index.jsp">RES-POS</a>
				<ul class="nav">
					<li id="home-link">
						<a id="home-link" href="welcome.html"><i class="icon-home icon-white"></i>&nbsp;<spring:message code="label.menu.home"/></a>
					</li>
				<c:if test="${not empty restaurantId }">
					<li><a id="menu-link" href="menu.html?restaurantId=${restaurantId}&restaurantName=${restaurantName}"><spring:message code="label.menu.order"/></a></li>
					<li id="search" class="dropdown">
						<a href="searchOrders.html?restaurantId=${restaurantId}"><spring:message code="label.menu.search"/></a>
					</li>
				<sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">	
					<li><a id="management-link" tabindex="-1" href="management.html?restaurantId=${restaurantId}"><spring:message code="label.menu.management"/></a></li>
				</sec:authorize>
				</c:if>
					<li><a id="wholeMenu-link" tabindex="-1" href="wholeMenu.html"><spring:message code="label.menu.menu"/></a></li>
				<sec:authorize ifAnyGranted="ROLE_ADMIN, ROLE_USER">	
					<li><a href="${logoutUrl}"><spring:message code="label.menu.logout"/></a></li>
				</sec:authorize>	
				</ul>
				<div class="btn-group pull-right" data-toggle="buttons-radio">
					<a id="english" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" href="?lang=en">en</a>
					<a id="chinese" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" href="?lang=zh">中</a>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript" src="js/menubar.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var lang = "<c:out value='${lang}'/>";
		if(lang == 'zh'){
			$("a").css("font-size","18px");
			$("b").css("font-size","18px");
			$("label").css("font-size","18px");
			$("input").css("font-size","18px");
			$("button").css("font-size","20px");
		}
	});
</script>
