<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table id="customerInfo" title="CustomerInfo">
	<tr>
		<td>
		<fieldset>
		<legend>Customer Information</legend>
			<div id="divCustomerInfo" class="sectionB colB">
				<table>
					<tr>
						<td>Telephone:</td>
						<td><input id="telephone" type="text" value="333-333-3333"/></td>
						<td>Name:</td>
						<td><input id="name" type="text" value="John"/></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><input id="address" type="text" value="100 Southern St"/></td>
						<td>City:</td>
						<td><input id="city" type="text" value="New York"/></td>
					</tr>							
				</table>							
			</div>
		</fieldset>
		</td>
	</tr>
</table>
