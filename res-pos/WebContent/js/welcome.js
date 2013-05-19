var numOfRes = $('#numOfRes').val();

$(document).ready(function(){
	
	for(var i = 0; i < numOfRes; i++){
		var resId = "#resId_" + i.toString();
	
		$(resId).click(function(){
			alert($(this).val());
		});
	}
});