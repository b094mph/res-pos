<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend><spring:message code="label.customer.info"/></legend>
		<table>
			<tr>
				<td>
					<input id="firstName" type="text" name="firstName" placeholder='<spring:message code="label.firstname"/>' data-provide="typeahead">
					<input id="lastName" type="text" name="lastName" placeholder='<spring:message code="label.lastname"/>' data-provide="typeahead">
					<input id="phone1" type="text" name="phone1" placeholder='<spring:message code="label.phone1"/>' data-provide="typeahead">
					<input id="phone2" type="text" name="phone2" placeholder='<spring:message code="label.phone2"/>' data-provide="typeahead">
					<input id="ext" type="text" name="ext" placeholder='<spring:message code="label.ext"/>' data-provide="typeahead">
					<input id="email" type="text" name="email" placeholder='<spring:message code="label.email"/>' data-provide="typeahead">
					<input id="street1" type="text" name="street1" placeholder="<spring:message code="label.street1"/>" data-provide="typeahead">
					<input id="street2" type="text" name="street2" placeholder="<spring:message code="label.street2"/>" data-provide="typeahead">
					<input id="city" type="text" name="city" placeholder="<spring:message code="label.city"/>" data-provide="typeahead">
					<input id="state" type="text" name="state" placeholder="<spring:message code="label.state"/>" data-provide="typeahead">
					<input id="zipCode" type="text" name="zipCode" placeholder="<spring:message code="label.zipCode"/>" data-provide="typeahead">
					<input id="note" type="text" name="note" placeholder='<spring:message code="label.note"/>' data-provide="typeahead">
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