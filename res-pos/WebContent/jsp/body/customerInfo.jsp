<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fieldset>
<legend><spring:message code="label.customer.info"/></legend>
	<div>
		<table>
			<tr>
				<td>
					<label class="control-label" for="firstName"><spring:message code="label.firstname"/></label>
					<input id="firstName" type="text" name="firstName" value="${firstName}" placeholder='<spring:message code="label.firstname"/>' data-provide="typeahead">
				</td>
				<td>	
					<label class="control-label" for="note"><spring:message code="label.note"/></label>
					<input id="note" type="text" name="note" value="${note}" placeholder='<spring:message code="label.note"/>' data-provide="typeahead">
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label" for="phone1"><spring:message code="label.phone1"/></label>
					<input id="phone1" type="text" name="phone1" value="${phone1}" placeholder='<spring:message code="label.phone1"/>' data-provide="typeahead">
				</td>
				<td>
					<label class="control-label" for="street1"><spring:message code="label.street1"/></label>
					<input id="street1" type="text" name="street1" value="${street1}" placeholder="<spring:message code="label.street1"/>" data-provide="typeahead">
				</td>
				<td>
					<label class="control-label" for="city"><spring:message code="label.city"/></label>
					<input id="city" type="text" name="city" value="${city}" placeholder="<spring:message code="label.city"/>" data-provide="typeahead">
				</td>
			</tr>
			<tr>

			</tr>
		</table>
	</div>
	<div>
		<button id="hiddenSubmit" type="submit" class="btn hidden">Submit</button>
		<button id="hiddenReset" type="reset" class="btn hidden">Reset</button>
	</div>

</fieldset>