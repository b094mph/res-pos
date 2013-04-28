$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	
//	$('#address-link').click(function(){
//		window.location = "address.html";
//		$.ajax({
//			type: "POST",
//			cache: false,
//			url: "address.html",
//			success: showSuccess,
//			error: showError
//		});
//	});
	
//	$('#customer-link').click(function(){
//		window.location = "showCustomerForm.html";
//	});
	
//	$('#showCustomerTable').click(function(){
//		$.ajax({
//			type: "GET",
//			cache: false,
//			url: "listCustomers.html",
//			success: function(){
//				alert("list customer success");
//				$('#showCustomerList').html().show();
//			},
//			error: showError
//		});
//	});

});


function showSuccess(){
	alert("Success");
}

function showError(){
	alert("An error occured.");
}

