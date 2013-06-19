<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="navbar navbar-fixed-bottom">	
	<div class="navbar-inner">		
		<div class="container-fluid">
			<div class="row-fluid">
			<div class="span4">
				<button id="ToS" class="btn btn-link"><spring:message code="label.terms.of.service"/></button>
				<button id="privacy" class="btn btn-link"><spring:message code="label.privacy"/></button>
				<button id="security" class="btn btn-link"><spring:message code="label.security"/></button>
			</div>
			<div class="span4">
				<div class="center">
					<a id="facebook" href="https://www.facebook.com" data-toggle="tooltip" data-placement="top"><img alt="facebook" src="img/glyphicons/glyphicons/png/glyphicons_410_facebook.png"></a>
					<a id="twitter" href="https://www.twitter.com" data-toggle="tooltip" data-placement="top"><img alt="twitter" src="img/glyphicons/glyphicons/png/glyphicons_411_twitter.png"></a>
			 		<a id="google" href="https://plus.google.com" data-toggle="tooltip" data-placement="top"><img alt="google-plus" src="img/glyphicons/glyphicons/png/glyphicons_382_google_plus.png"></a>
			 		<a id="linkedin" href="https://www.linkedin.com" data-toggle="tooltip" data-placement="top"><img alt="linkedin" src="img/glyphicons/glyphicons/png/glyphicons_397_linked_in.png"></a>
			 		<a id="lovenyc" href="https://maps.google.com/maps?q=New+York,+NY&hl=en&sll=40.643136,-73.935242&sspn=1.133721,2.526855&oq=new+york&hnear=New+York&t=m&z=10" data-toggle="tooltip" data-placement="top">
			 			<img alt="Heart" src="img/glyphicons/glyphicons/png/glyphicons_012_heart.png">
			 		</a>
				</div>
			</div>
			<div class="span4">
			 	<div class="pull-right">
					<spring:message code="label.footer"/>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="modal/termsOfService.jsp"/>
<jsp:include page="modal/privacy.jsp"/>
<jsp:include page="modal/security.jsp"/>
<script type="text/javascript" src="js/footer.js"></script>