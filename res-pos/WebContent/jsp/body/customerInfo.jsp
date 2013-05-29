<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend>Customer Information</legend>
		<table>
			<tr>
				<td>
					<input id="firstName" type="text" name="firstName" placeholder="First Name">
					<input id="lastName" type="text" name="lastName" placeholder="Last Name">
					<input id="phone1" type="text" name="phone1" placeholder="Phone 1" data-provide="typeahead">
					<input id="phone2" type="text" name="phone2" placeholder="Phone 2" data-provide="typeahead">
					<input id="ext" type="text" name="ext" placeholder="Extention">
					<input id="email" type="text" name="email" placeholder="Email">
					<input id="street1" type="text" name="street1" placeholder="<spring:message code="label.street1"/>">
					<input id="street2" type="text" name="street2" placeholder="<spring:message code="label.street2"/>">
					<input id="city" type="text" name="city" placeholder="<spring:message code="label.city"/>">
					<input id="state" type="text" name="state" placeholder="<spring:message code="label.state"/>">
					<input id="zipCode" type="text" name="zipCode" placeholder="<spring:message code="label.zipCode"/>">
					<input id="note" type="text" name="note" placeholder="Note">
				</td>
			</tr>
			<tr>
				<td>
					<button id="hiddenSubmit" type="submit" class="btn hidden">Submit</button>
					<button id="hiddenReset" type="reset" class="btn hidden">Reset</button>
				</td>
			</tr>
		</table>
</fieldset>