<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Modal -->
<div id="orderTypeModal" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<p><spring:message code="label.modal.required.order.type"/></p>
	</div>
	<jsp:include page="modal-footer-close-warning.jsp"/>
</div>

<div id="validateHasPhoneNumberModal" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<p><spring:message code="label.modal.required.phone1"/></p>
	</div>
	<jsp:include page="modal-footer-close-warning.jsp"/>
</div>

<div id="validateDeliveryHasAddressModal" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<h4><spring:message code="label.modal.required.address"/></h4>
		<p><spring:message code="label.modal.required.address.fields"/></p>
	</div>
	<jsp:include page="modal-footer-close-warning.jsp"/>
</div>

<div id="voidAlertWarning" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<p><spring:message code="label.modal.void.order"/></p>
	</div>
	<jsp:include page="modal-footer-confirm.jsp"/>
</div>

<div id="saveConfirmation" class="modal hide in display-none" tabindex="-1">
	<jsp:include page="modal-header-success.jsp"/>
	<div class="modal-body">
		<p><spring:message code="save"/></p>
	</div>
	<jsp:include page="modal-footer-close-success.jsp"/>
</div>