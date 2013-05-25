var numOfRes = $('#numOfRes').val();

$(document).ready(function(){
	
	for(var i = 0; i < numOfRes; i++){
		var resId = "#resId_" + i.toString();

		$(resId).click(function(){
			setSessionAttribute($(this).val());
		});
	}
});

function setSessionAttribute(restaurantId){
	var params = {restaurantId: restaurantId};
	$.ajax({
		type: "GET",
		url: "setSessionAttribute.json",
		data: params,
		success: 
			function(data){
				window.location.replace($('#menuPage').val());
		},
		error: 
			function(data){
				alert("unsuccessful setting session attribute in ajax..." + resId);
		}
	});
}
