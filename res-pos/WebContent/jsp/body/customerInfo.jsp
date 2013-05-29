<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend>Customer Information</legend>
		<table>
			<tr>
				<td>
					<input id="firstName" type="text" name="firstName" placeholder="First Name" data-provide="typeahead">
					<input id="lastName" type="text" name="lastName" placeholder="Last Name" data-provide="typeahead">
					<input id="phone1" type="text" name="phone1" placeholder="Phone 1" data-provide="typeahead">
					<input id="phone2" type="text" name="phone2" placeholder="Phone 2" data-provide="typeahead">
					<input id="ext" type="text" name="ext" placeholder="Extention" data-provide="typeahead">
					<input id="email" type="text" name="email" placeholder="Email" data-provide="typeahead">
					<input id="street1" type="text" name="street1" placeholder="<spring:message code="label.street1"/>" data-provide="typeahead">
					<input id="street2" type="text" name="street2" placeholder="<spring:message code="label.street2"/>" data-provide="typeahead">
					<input id="city" type="text" name="city" placeholder="<spring:message code="label.city"/>" data-provide="typeahead">
					<input id="state" type="text" name="state" placeholder="<spring:message code="label.state"/>" data-provide="typeahead">
					<input id="zipCode" type="text" name="zipCode" placeholder="<spring:message code="label.zipCode"/>" data-provide="typeahead">
					<input id="note" type="text" name="note" placeholder="Note" data-provide="typeahead">
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