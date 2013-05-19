<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<div class="container">
	<div class="row">
		<div class="span12">
			<div id="welcomealert" class="alert alert-success">
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
					<c:forEach items="${restaurants}" var="res">
							<tr>
								<td>${res.restaurantId}</td>
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
<!-- 		<div class="span6"> -->
<!-- 			<br> -->
<!-- 			<iframe width="425" height="350" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=New+York,+NY&amp;aq=0&amp;oq=New+Yo&amp;sll=42.746632,-75.770041&amp;sspn=4.485583,10.107422&amp;ie=UTF8&amp;hq=&amp;hnear=New+York&amp;t=m&amp;z=10&amp;ll=40.714353,-74.005973&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=New+York,+NY&amp;aq=0&amp;oq=New+Yo&amp;sll=42.746632,-75.770041&amp;sspn=4.485583,10.107422&amp;ie=UTF8&amp;hq=&amp;hnear=New+York&amp;t=m&amp;z=10&amp;ll=40.714353,-74.005973" style="color:#0000FF;text-align:right">View Larger Map</a></small> -->
<!-- 			<br> -->
<!-- 		</div>	 -->
	</div>
</div>
</body>
<br><br><br><br><br><br>