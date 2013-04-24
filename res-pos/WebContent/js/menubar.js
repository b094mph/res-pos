$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	
	$('#addressBtn').click(function(){
		window.location = "http://localhost:8080/res-pos/address.html";
//		$.ajax({
//			type: "POST",
//			cache: false,
//			url: "address.html",
//			success: showSuccess,
//			error: showError
//		});
	});
	
	$('#customerBtn').click(function(){
		window.location = "http://localhost:8080/res-pos/showCustomerForm.html";
//		$.ajax({
//			type: "POST",
//			cache: false,
//			url: "showCustomerForm.html",
//			success: showSuccess,
//			error: showError
//		});
	});

});


function showSuccess(){
	alert("Success");
}

function showError(){
	alert("An error occured");
}

