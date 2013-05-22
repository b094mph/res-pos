<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<input id="numOfRes" type="hidden" value="${numOfRes}"> 

<script type="text/javascript" src="js/welcome.js"></script>

<div class="row">
	<div class="span12">
		<div id="welcomealert" class="alert alert-info">
			<a class="close" data-dismiss="alert">x</a>
			<h3>Hello <c:out value="${username}"/>!</h3>
			<p>Welcome to RES-POS!</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<fieldset>
		<legend>Choose a restaurant:</legend>
		<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Restaurant Name</th>
							<th>Location</th>
							<th>Phone1</th>
							<th>Phone2</th>
							<th>Fax</th>
							<th>Delivery Cost</th>
							<th>Tax</th>
							<th>Mon To Thurs</th>
							<th>Fri</th>
							<th>Sat</th>
							<th>Sun</th>
						</tr>
					</thead>
					<tbody>
				<c:forEach items="${restaurants}" var="res" varStatus="idx">
						<tr>
							<td>
								<button id="resId_${pageScope.idx.index}" class="btn btn-primary" value="${res.restaurantId}">${res.restaurantId}</button>
							</td>
							<td>${res.restaurantName}</td>
							<td>${res.location}</td>
							<td>${res.phone1}</td>
							<td>${res.phone2}</td>
							<td>${res.faxNumber}</td>
							<td>${res.deliveryCost}</td>
							<td>${res.tax}</td>
							<td>${res.monToThursOpen} - ${monToThursClose}</td>
							<td>${res.friOpen} - ${res.friClose}</td>
							<td>${res.satOpen} - ${res.satClose}</td>
							<td>${res.sunOpen} - ${res.sunClose}</td>
						</tr>
				</c:forEach>
					</tbody>
			</table>
			</fieldset>
	</div>
</div>


<br><br><br><br><br><br>