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
		type : "GET",
		url : "subMenu.json",
		dataType : "json",
		contentType : "application/json",
		data : params,
		success : 
			showSuccess,
		error : showError
	});
	
//	$.ajax({
//		type : "GET",
//		url : "subMenu.json",
//		data : params,
//		success : function(data){
//			//$("#subcategoryajax").html(data).show();
//			alert("success" + data);
//		},
//		error : showError()
//	});
}

function showSuccess(){
	alert("success");
}

function showError(){
	alert("An error occured.");
}