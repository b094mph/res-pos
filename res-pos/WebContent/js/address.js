$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	alert("address loaded.");
});

$('#addressBtn').click(function(){
	$.ajax({
		type: "POST",
		cache: false,
		url: "address.html",
		success: showSuccess,
		error: showError
	});
});

function showSuccess(){
	alert("succcess");
}

function showError(){
	alert("An error occured");
}