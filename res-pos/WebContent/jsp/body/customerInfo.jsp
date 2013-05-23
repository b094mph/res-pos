<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend>Customer Information</legend>
	<form method="get" action="submitOrder.html">
		<table>
			<tr>
				<td>
					<input type="text" name="firstName" placeholder="First Name">
					<input type="text" name="lastName" placeholder="Last Name">
					<input type="text" name="phone1" placeholder="Phone 1">
					<input type="text" name="phone2" placeholder="Phone 2">
					<input type="text" name="ext" placeholder="Extention">
					<input type="text" name="email" placeholder="Email">
					<input type="text" name="street1" placeholder="<spring:message code="label.street1"/>">
					<input type="text" name="street2" placeholder="<spring:message code="label.street2"/>">
					<input type="text" name="city" placeholder="<spring:message code="label.city"/>">
					<input type="text" name="state" placeholder="<spring:message code="label.state"/>">
					<input type="text" name="zipCode" placeholder="<spring:message code="label.zipCode"/>">
					<input type="text" name="note" placeholder="Note">
				</td>
			</tr>
			<tr>
				<td>
					<button id="hiddenSubmit" type="submit" class="btn hidden">Submit</button>
					<button id="hiddenReset" type="reset" class="btn hidden">Reset</button>
				</td>
			</tr>
		</table>
	</form>
</fieldset>