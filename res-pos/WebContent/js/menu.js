$.ajaxSetup({
	cache: false
});

$(document).ready(function(){
	//creating on click event for food category buttons
	for(var i=1; i <=foodCategoriesSize; i++){
		var id = '#fc_'+i.toString();
		ajaxFoodCategory(id);
	}
});

function ajaxFoodCategory(id){
	$(id).click(function(){
		alert(id);
		showSubCategory($(this).val());
	});
}

function showSubCategory(foodCategoryId){
	var params = {foodCategoryId : foodCategoryId};
	$.ajax({
		type: "GET",
		url: "subMenu.json",
		dataType: "json",
		contentType: "application/json",
		data: params,
		success: 
			function(data){
				alert("successful " + data);
				$('#subcategoryajax').html("<h1>"+data+"</h1>").show();
		},
		error: 
			function(data){
				alert("unsuccessful..." + data);
		}
	});
	
}
