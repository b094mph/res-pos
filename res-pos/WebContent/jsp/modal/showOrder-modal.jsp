<!-- Modal -->
<div id="orderTypeModal" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<p>An order type is required to complete the order.</p>
	</div>
	<jsp:include page="modal-footer-close.jsp"/>
</div>

<div id="validateHasPhoneNumberModal" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<p>Phone1 field is required to complete the order.</p>
	</div>
	<jsp:include page="modal-footer-close.jsp"/>
</div>

<div id="validateDeliveryHasAddressModal" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<h4>A delivery order requires an address.</h4>
		<p>Fields: Street1, City, State, Zip Code are required.</p>
	</div>
	<jsp:include page="modal-footer-close.jsp"/>
</div>

<div id="voidAlertWarning" class="modal hide fade in display-none" tabindex="-1">
	<jsp:include page="modal-header-warning.jsp"/>
	<div class="modal-body">
		<p>Void this order?</p>
	</div>
	<jsp:include page="modal-footer-confirm.jsp"/>
</div>