var id = "";

$.ajaxSetup({
	cache: true //true is the default value
});

$(document).ready(function(){
	//creating on click event for food category buttons
	for(var i=1; i <=foodCategoriesSize; i++){
		id = '#fc_'+i.toString();
		createFoodCategoryOnClick(id);
	}
});

function createFoodCategoryOnClick(id){
	$(id).click(function(){
		showSubCategory($(this).val());
	});
}

function showSubCategory(foodCategoryId){
	var params = {foodCategoryId : foodCategoryId};
	$.ajax({
		type: "GET",
		url: "subMenu.json",
		data: params,
		success: 
			function(data){
//				alert("successful " + data);
				$('#subcategoryajax').html(data).show();
//				'<button type="button" class="btn btn-info btn-large btn1">TEST</button>'
		},
		error: 
			function(data){
				alert("unsuccessful..." + data);
		}
	});
	
}
