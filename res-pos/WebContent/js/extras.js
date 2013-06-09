$(document).ready(function(){
	
	$('#veg').click(function(){
		extrasOption($(this).val());
	});
	
	$('#meat').click(function(){
		extrasOption($(this).val());
	});
	
	$('#taste').click(function(){
		extrasOption($(this).val());
	});
	
	$('#sauce').click(function(){
		extrasOption($(this).val());
	});
});

function extrasOption(option){
	var params = {extrasOption: option};
	$.ajax({
		type: "GET",
		url: "extrasOption.json",
		data: params,
		success:
			function(data){
				$('#extraMenu').html(data).show();
			},
		error:
			function(data){
				alert("unsuccessful displaying extras options in ajax call...");
			}
	});
}